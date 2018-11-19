package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class MainGame{
	public static void main(String[] args) {
		GameGUI gui = new GameGUI();
		GameUTIL util = new GameUTIL();
		new HomePage();
		while(util.d==0) {
			System.out.println(util.d);
		}
		util.seed = System.nanoTime( );
		util.rand = new Random( util.seed );
		gui.index_button = util.rand.nextInt(30);
		gui.add_img();
		gui.change_to_cutscene();
		gui.init();
		gui.change();
		gui.p_player.validate();
		gui.p_monster.validate();
		while(gui.a<=5) {
		while(util.hp_monster>0) {
			util.damage();
			
		}
		gui.monster_dead();
		gui.a++;
		gui.change_to_cutscene();
		gui.change_to_fight();
		util.seed = System.nanoTime( );
		util.rand = new Random( util.seed );
        gui.index_button = util.rand.nextInt(10)+(gui.a-1)*10;
	}
	}

}