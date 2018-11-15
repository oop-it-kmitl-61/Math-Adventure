package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class GameGUI implements ActionListener  {
	double num;
	int a = 1, index_button=0;
	static ImageIcon icon_player,icon_monster;
	static JLabel lb_player,lb_monster;
	JFrame fr;
	static JPanel p_player,p_monster,hpbarp_player,hpbarp_monster,p;
	static JProgressBar hpbar_player,hpbar_monster;
	static JButton b1,b2,b3,b4,b_hit,b_plus,b_minus,b_multi,b_divide,b_eq,b_clear,b_change;
	static JTextField tf;
	ImageIcon img =null;
	static List<ImageIcon> images = new ArrayList<ImageIcon>();
	public void init() {
		fr = new JFrame();
		p = new JPanel();
		p_player = new JPanel();
		p_monster = new JPanel();
		lb_player = new JLabel();
		lb_monster = new JLabel();
		icon_player = new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg");
		icon_monster = new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg");
		lb_player.setIcon(icon_player);
		lb_monster.setIcon(icon_monster);
		p_player.add(lb_player);
		p_monster.add(lb_monster);
		fr.add(p_player,BorderLayout.NORTH);
		fr.add(p_monster,BorderLayout.SOUTH);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(1000,1000);
		fr.setVisible(true);
//		try {
//			TimeUnit.SECONDS.sleep(3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		p_player.remove(lb_player);
//		p_player.revalidate();
//		p_player.repaint();
		img = new ImageIcon("C:\\Users\\poom\\Desktop\\2.png");
		images.add(img);
		img = new ImageIcon("C:\\Users\\poom\\Desktop\\dumb-knight-12.gif");
		images.add(img);

	}
	public void change() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		icon_player = new ImageIcon("C:\\Users\\poom\\Desktop\\dumb-knight-12.gif");
		icon_monster = new ImageIcon("C:\\Users\\poom\\Desktop\\dumb-knight-12.gif");
		lb_player.setIcon(null);
		lb_player.setIcon(images.get(1));
		lb_monster.setIcon(null);
		lb_monster.setIcon(icon_monster);
	}
	public JPanel hp_player() {
		hpbarp_player = new JPanel();
		hpbarp_player.setBounds(0,0, 300, 30);
		
		hpbar_player = new JProgressBar(0,300);
		hpbar_player.setPreferredSize(new Dimension(300,30));
		hpbar_player.setBackground(Color.RED);
		hpbar_player.setForeground(Color.GREEN);
		hpbar_player.setValue(300);
		hpbarp_player.add(hpbar_player);
		return hpbarp_player;
	}
	public JPanel hp_monster() {
		hpbarp_monster = new JPanel();
		hpbarp_monster.setBounds(0,0, 300, 30);
		
		hpbar_monster = new JProgressBar(0,500);
		hpbar_monster.setPreferredSize(new Dimension(300,30));
		hpbar_monster.setBackground(Color.RED);
		hpbar_monster.setForeground(Color.GREEN);
		hpbar_monster.setValue(500);
		hpbarp_monster.add(hpbar_monster);
		return hpbarp_monster;
	}
	public JTextField textfield_hit() {
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(300,30));
		tf.setEditable(false);
		return tf;
	}
	public JButton button_hit() {
		b_hit = new JButton("Hit");
		b_hit.addActionListener(this);
		return b_hit;
	}
	public JButton b1(int a) {
		b1 = new JButton();
		b1.setText(GameUTIL.num_24[a][0]);
		b1.addActionListener(this);
		return b1;
	}
	public JButton b2(int a) {
		b2 = new JButton();
		b2.setText(GameUTIL.num_24[a][1]);
		b2.addActionListener(this);
		return b2;
	}
	public JButton b3(int a) {
		b3 = new JButton();
		b3.setText(GameUTIL.num_24[a][2]);
		b3.addActionListener(this);
		return b3;
	}
	public JButton b4(int a) {
		b4 = new JButton();
		b4.setText(GameUTIL.num_24[a][3]);
		b4.addActionListener(this);
		return b4;
	}
	public JButton b_plus() {
		b_plus = new JButton();
		b_plus.setText("+");
		b_plus.addActionListener(this);
		return b_plus;
	}
	public JButton b_minus() {
		b_minus = new JButton();
		b_minus.setText("-");
		b_minus.addActionListener(this);
		return b_minus;
	}
	public JButton b_multi() {
		b_multi = new JButton();
		b_multi.setText("x");
		b_multi.addActionListener(this);
		return b_multi;
	}
	public JButton b_divide() {
		b_divide = new JButton();
		b_divide.setText("/");
		b_divide.addActionListener(this);
		return b_divide;
	}
	public JButton b_eq() {
		b_eq = new JButton();
		b_eq.setText("=");
		b_eq.addActionListener(this);
		return b_eq;
	}
	public JButton b_clear() {
		b_clear = new JButton();
		b_clear.setText("clear");
		b_clear.addActionListener(this);
		return b_clear;
	}
	public JButton b_change() {
		b_change = new JButton();
		b_change.setText("change");
		b_change.addActionListener(this);
		return b_change;
	}
	public void change_monster() {
		icon_monster = new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg");
		lb_monster.setIcon(null);
		lb_monster.setIcon(icon_monster);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		icon_monster = new ImageIcon("C:\\Users\\poom\\Desktop\\3.gif");
		lb_monster.setIcon(null);
		lb_monster.setIcon(icon_monster);
		hpbar_monster.setValue(500);
		GameUTIL.hp_monster = 500;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		GameUTIL gu = new GameUTIL();
		if(arg0.getSource()==b_hit) {
			num = gu.computeAnother(tf.getText());
			if(num==24.0) {
				gu.hp_monster = gu.hp_monster-gu.dmg_player;
				hpbar_monster.setValue(gu.hp_monster);
				gu.seed = System.nanoTime( );
				gu.rand = new Random( gu.seed );
				index_button = gu.rand.nextInt(10)+(a-1)*10;
				b1.setText(gu.num_24[index_button][0]);
				b2.setText(gu.num_24[index_button][1]);
				b3.setText(gu.num_24[index_button][2]);
				b4.setText(gu.num_24[index_button][3]);
				tf.setText("");
				b1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				b4.setEnabled(true);
			}
		}
		else if(arg0.getSource()==b1) {
			tf.setText(tf.getText()+gu.num_24[index_button][0]);
			b1.setEnabled(false);
		}
		else if(arg0.getSource()==b2) {
			tf.setText(tf.getText()+gu.num_24[index_button][1]);
			b2.setEnabled(false);
		}
		else if(arg0.getSource()==b3) {
			tf.setText(tf.getText()+gu.num_24[index_button][2]);
			b3.setEnabled(false);
		}
		else if(arg0.getSource()==b4) {
			tf.setText(tf.getText()+gu.num_24[index_button][3]);
			b4.setEnabled(false);
		}
		else if(arg0.getSource()==b_plus) {
			tf.setText(tf.getText()+"+");
		}
		else if(arg0.getSource()==b_minus) {
			tf.setText(tf.getText()+"-");
		}
		else if(arg0.getSource()==b_multi) {
			tf.setText(tf.getText()+"*");
		}
		else if(arg0.getSource()==b_divide) {
			tf.setText(tf.getText()+"/");
		}
		else if(arg0.getSource()==b_eq) {
			num = gu.computeAnother(tf.getText());
			tf.setText(Double.toString(num));
		}
		else if(arg0.getSource()==b_clear) {
			tf.setText("");
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);
		}
		else if(arg0.getSource()==b_change) {
			index_button = gu.rand.nextInt(10)+(a-1)*10;
			b1.setText(gu.num_24[index_button][0]);
			b2.setText(gu.num_24[index_button][1]);
			b3.setText(gu.num_24[index_button][2]);
			b4.setText(gu.num_24[index_button][3]);
			gu.hp_player -= 20;
			hpbar_player.setValue(gu.hp_player);
		}
		
		
	}

}
