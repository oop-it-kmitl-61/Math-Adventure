package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Main{
	public static void main(String[] args) {
		La l = new La();
		La.seed = System.nanoTime( );
        La.rand = new Random( La.seed );
        La.index_button = La.rand.nextInt(30);
		l.init();
		l.change();
		l.p_player.add(l.hp_player());
		l.p_monster.add(l.hp_monster());
		l.p_player.add(l.textfield_hit());
		l.p_player.add(l.button_hit());
		l.p_player.add(l.b1(La.index_button));
		l.p_player.add(l.b2(La.index_button));
		l.p_player.add(l.b3(La.index_button));
		l.p_player.add(l.b4(La.index_button));
		l.p_monster.add(l.b_plus());
		l.p_monster.add(l.b_minus());
		l.p_monster.add(l.b_multi());
		l.p_monster.add(l.b_divide());
		l.p_monster.add(l.b_eq());
		l.p_monster.add(l.b_clear());
		l.p_monster.add(l.b_change());
		l.p_player.validate();
		l.p_monster.validate();
		while(La.a<5) {
		while(La.hp_monster>0) {
			l.damage();
			
		}
		l.change_monster();
		La.seed = System.nanoTime( );
		La.rand = new Random( La.seed );
		La.index_button = La.rand.nextInt(30);
		l.b1.setText(La.num_24[La.index_button][0]);
		l.b2.setText(La.num_24[La.index_button][1]);
		l.b3.setText(La.num_24[La.index_button][2]);
		l.b4.setText(La.num_24[La.index_button][3]);
		La.a++;
	}

}}
