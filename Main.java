package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Main{
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
		gui.hp_player();
		gui.hp_monster();
		gui.textfield_hit();
		gui.button_hit();
		gui.b1(gui.index_button);
		gui.b2(gui.index_button);
		gui.b3(gui.index_button);
		gui.b4(gui.index_button);
		gui.b_plus();
		gui.b_minus();
		gui.b_multi();
		gui.b_divide();
		gui.b_eq();
		gui.b_clear();
		gui.b_change();
		gui.p_player.validate();
		gui.p_monster.validate();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(gui.a<5) {
		while(util.hp_monster>0) {
			util.damage();
			
		}
		gui.change_to_cutscene();
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