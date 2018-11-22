package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainGame{
	public MainGame() {
		GameGUI gui = new GameGUI();
		GameUTIL util = new GameUTIL();
		new HomePage();
		while(util.d==0) {
			System.out.println(util.d);
		}
		util.seed = System.nanoTime( );
		util.rand = new Random( util.seed );
		gui.index_button = util.rand.nextInt(23)+(gui.a*22);
		gui.add_img();
		gui.change_to_cutscene();
		gui.init();
		gui.p_player.validate();
		gui.p_monster.validate();
		
	}
	public static void main(String[] args) {
		GameGUI gui = new GameGUI();
		GameUTIL util = new GameUTIL();
		new MainGame();
		while(gui.a<=5) {
			while(util.hp_monster>0&&util.hp_player>0) {
				util.damage();
				
			}
			if(util.hp_monster<=0) {
			gui.monster_dead();
			gui.a++;
			util.seed = System.nanoTime( );
			util.rand = new Random( util.seed );
	        gui.index_button = util.rand.nextInt(23)+(gui.a*22);
	        gui.txt.setText(util.num_24[gui.index_button][0]);
			gui.change_to_cutscene();
			gui.change_to_fight();
			}
			else if(util.hp_player<=0) {
				gui.fr.dispose();
				util.hp_player=300;
				gui.a=0;
				util.d=0;
				new MainGame();
			}
		}
	}

}