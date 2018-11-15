package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class MainGame{
	// how to remove and add
//	try {
//		TimeUnit.SECONDS.sleep(3);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	gui.fr.getContentPane().removeAll();
//	gui.fr.repaint();
//	try {
//		TimeUnit.SECONDS.sleep(3);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	gui.fr.add(gui.p_player,BorderLayout.NORTH);
//	gui.fr.add(gui.p_monster,BorderLayout.SOUTH);
//	gui.fr.validate();
//	gui.fr.repaint();
	public static void main(String[] args) {
		GameGUI gui = new GameGUI();
		GameUTIL util = new GameUTIL();
		util.seed = System.nanoTime( );
		util.rand = new Random( util.seed );
		gui.index_button = util.rand.nextInt(30);
		gui.init();
		gui.change();
		gui.p_player.add(gui.hp_player());
		gui.p_monster.add(gui.hp_monster());
		gui.p_player.add(gui.textfield_hit());
		gui.p_player.add(gui.button_hit());
		gui.p_player.add(gui.b1(gui.index_button));
		gui.p_player.add(gui.b2(gui.index_button));
		gui.p_player.add(gui.b3(gui.index_button));
		gui.p_player.add(gui.b4(gui.index_button));
		gui.p_monster.add(gui.b_plus());
		gui.p_monster.add(gui.b_minus());
		gui.p_monster.add(gui.b_multi());
		gui.p_monster.add(gui.b_divide());
		gui.p_monster.add(gui.b_eq());
		gui.p_monster.add(gui.b_clear());
		gui.p_monster.add(gui.b_change());
		gui.p_player.validate();
		gui.p_monster.validate();
		while(gui.a<5) {
		while(util.hp_monster>0) {
			util.damage();
			
		}
		gui.change_monster();
		util.seed = System.nanoTime( );
		util.rand = new Random( util.seed );
        gui.index_button = util.rand.nextInt(10)+(gui.a-1)*10;
        gui.b1.setText(util.num_24[gui.index_button][0]);
        gui.b2.setText(util.num_24[gui.index_button][1]);
        gui.b3.setText(util.num_24[gui.index_button][2]);
        gui.b4.setText(util.num_24[gui.index_button][3]);
        gui.a++;
	}
	}

}