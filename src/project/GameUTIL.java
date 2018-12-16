package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javazoom.jl.decoder.*;
import javazoom.jl.player.*;

import javax.swing.*;


public class GameUTIL implements Runnable{
	static long seed = System.nanoTime( );
	static Random rand = new Random( seed );
	static int d=0,time_dmg = 0,bonus_dmg=5,sound=0,time=0,play_time_min=0,play_time_sec=0,play_time_millisec=0,play=0;
	Double sub,num;
	static String num_24[][]=new String[240][2]; 	
	static int hp_player=300,hp_monster=300;
	int dmg_player=30;
	int dmg_monster=rand.nextInt(10)+10;
	List<String> score = new ArrayList<String>();
	static String leaderboard = "";
	public void add_quiz() throws IOException {
		int a=0;
		BufferedReader br = new BufferedReader(new FileReader("quiz.txt"));
	    try {
	        String line = br.readLine();
	        while (line != null) {
	        	num_24[a][0] = line;
	        	num_24[a][1] = br.readLine();
	            line = br.readLine();
	            a++;
	        }
	    } finally {
	        br.close();
	    }
	}
	public void damage() throws Exception {
		TimeUnit.SECONDS.sleep(1);
		bonus_dmg-=1;
		if(time_dmg!=5) {
			time_dmg+=1;
		}
		else {
		if(bonus_dmg<0) {
			bonus_dmg=0;
		}
		hp_player = hp_player-dmg_monster;
		FileInputStream fin = new FileInputStream("sound\\hit1.mp3");
		Player p;
			p = new Player(fin);
			p.play();
		GameGUI.hpbar_player.setValue(hp_player);
		time_dmg=0;
		}
	}
	
	public static void play_music() throws Exception {
		while(true) {
		if(d==0) {//sound first cut scene
			FileInputStream fin = new FileInputStream("sound\\titlescene.mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
		else if(GameGUI.a==6) {//end scene
			FileInputStream fin = new FileInputStream("sound\\endscene.mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
		else if(sound==0) {//sound cut scene
			FileInputStream fin = new FileInputStream("sound\\cutscene.mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
		else if(hp_player>75&&GameGUI.a==5) {//sound start boss fight
			FileInputStream fin = new FileInputStream("sound\\boss_sound(yugi).mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
		else if(hp_player>75) {//sound start fight
			FileInputStream fin = new FileInputStream("sound\\test.mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
		else if(hp_player<75&&hp_player>0) {//sound when almost die
			FileInputStream fin = new FileInputStream("sound\\test2.mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
		else if(hp_player<=0) {//sound when die
			FileInputStream fin = new FileInputStream("sound\\test.mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
	}
	}
	public void play_time() throws InterruptedException {
		while(true) {
		TimeUnit.MILLISECONDS.sleep(10);
		play_time_millisec+=10;
		if(play_time_millisec==1000) {
			play_time_sec++;
			play_time_millisec=0;
			if(play_time_sec==60) {
				play_time_min++;
				play_time_sec=0;
			}
		}
		}
	}
	public void readscore() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("scoreboard.txt"));
	    try {
	        String line = br.readLine();
	        while (line != null) {
	        	score.add(line);
	            line = br.readLine();
	        }
	    } finally {
	        br.close();
	    }
	    score.add(play_time_min+":"+play_time_sec+":"+play_time_millisec);
	    score.sort(null);
	}
	public void writescore() throws IOException {
	    PrintWriter writer = new PrintWriter("scoreboard.txt", "UTF-8");
	    for(int i=0;i<score.size();i++) {
	    	writer.println(score.get(i));
	    }
		writer.close();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(play==1) {
			try {
				play_time();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				play_music();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
