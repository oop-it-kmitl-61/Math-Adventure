package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.BufferedReader;
import java.io.File;
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

import javax.imageio.ImageIO;
import javax.swing.*;


public class GameUTIL implements Runnable{
	static long seed = System.nanoTime( );
	static Random rand = new Random( seed );
	static int d=0,time_dmg = 0,sound=0,time=0,play_time_min=0,play_time_sec=0,play_time_millisec=0,play=0;
	Double sub;
	static String num_24[][]=new String[240][2]; 	
	static int hp_player=300,hp_monster=300;
	static int dmg_player=60;
	int dmg_monster=10;
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
	public void got_damage() throws Exception {
		if(GameGUI.num==Double.parseDouble(num_24[GameGUI.index_button][1])) {
	    		hp_monster = hp_monster-(300);
			
				GameGUI.lb_player_character.setIcon(GameGUI.img);
				FileInputStream fin;
				fin = new FileInputStream("sound\\hitsoco.mp3");
				Player p;
				p = new Player(fin);
				TimeUnit.MILLISECONDS.sleep(100);
				p.play();
				TimeUnit.MILLISECONDS.sleep(100);
				BufferedImage bim2 = (BufferedImage) GameGUI.images_boss.get(GameGUI.a);
				BufferedImage bin2 = new BufferedImage(bim2.getWidth(), bim2.getHeight(), BufferedImage.TYPE_INT_ARGB);
				Graphics2D createGraphics2= bin2.createGraphics();
				createGraphics2.drawImage(bim2, null, 0, 0);
				float alp[] = new float[] {250f,0,0,0.5f};
				float def[] = new float[] {0,0,0,0};
				RescaleOp r = new RescaleOp(alp,def,null);
				BufferedImage filter2 = r.filter(bin2, null);
				GameGUI.lb_monster_character.setIcon(new ImageIcon(filter2));
					
				GameGUI.hpbar_monster.setValue(hp_monster);
				seed = System.nanoTime( );
				rand = new Random( seed );
				GameGUI.index_button = rand.nextInt(23)+(GameGUI.a*40);
				GameGUI.tf.setText("");
				GameGUI.tf.requestFocus();
				if(hp_monster > 0) {
					GameGUI.txt.setText(num_24[GameGUI.index_button][0]);
				} else {
					GameGUI.txt.setText("");
				}
			}
			else {
				hp_player -= 10;
				GameGUI.hpbar_player.setValue(hp_player);
			}
		TimeUnit.MILLISECONDS.sleep(600);
		GameGUI.lb_monster_character.setIcon(GameGUI.images_icon_boss.get(GameGUI.a));
			TimeUnit.MILLISECONDS.sleep(1000);
	    	GameGUI.lb_player_character.setIcon(GameGUI.icon_player_character);
	    	GameGUI.num=0.0;
	}
	public void damage() throws Exception {
		TimeUnit.MILLISECONDS.sleep(10);
		if(time_dmg!=5000) {
			time_dmg+=20;
		}
		else {
		hp_player = hp_player-dmg_monster;
		FileInputStream fin = new FileInputStream("sound\\hit1.mp3");
		Player p;
		p = new Player(fin);
		p.play();
		BufferedImage bim2 = (BufferedImage) ImageIO.read(new File("images\\knight\\dumb-knight-2.gif"));
		BufferedImage bin2 = new BufferedImage(bim2.getWidth(), bim2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D createGraphics2= bin2.createGraphics();
		createGraphics2.drawImage(bim2, null, 0, 0);
		float alp[] = new float[] {250f,0,0,0.5f};
		float def[] = new float[] {0,0,0,0};
		RescaleOp r = new RescaleOp(alp,def,null);
		BufferedImage filter2 = r.filter(bin2, null);
		GameGUI.lb_player_character.setIcon(new ImageIcon(filter2));
		TimeUnit.MILLISECONDS.sleep(600);
		GameGUI.lb_player_character.setIcon(GameGUI.icon_player_character);
		
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
			FileInputStream fin = new FileInputStream("sound\\Pokemon_sound_boss.mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
		else if(hp_player>75) {//sound start fight
			FileInputStream fin = new FileInputStream("sound\\Pirates.mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
		else if(hp_player<75&&hp_player>0) {//sound when almost die
			FileInputStream fin = new FileInputStream("sound\\boss_sound(yugi).mp3");
			Player p;
				p = new Player(fin);
				p.play();
		}
		else if(hp_player<=0) {//sound when die
			FileInputStream fin = new FileInputStream("sound\\gameover.mp3");
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
		if(play==1) {
			try {
				play_time();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				play_music();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
