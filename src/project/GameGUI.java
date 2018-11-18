package project.src.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameGUI implements ActionListener  {
	double num;
	int a = 1,b=-1, index_button=0;
	static ImageIcon icon_player,icon_monster;
	static JLabel lb_player,lb_monster;
	static JFrame fr;
	static JPanel p_player,p_monster,hpbarp_player,hpbarp_monster,p;
	static JProgressBar hpbar_player,hpbar_monster;
	static JButton b1,b2,b3,b4,b_hit,b_plus,b_minus,b_multi,b_divide,b_eq,b_clear,b_change;
	static JTextField tf;
	ImageIcon img =null;
	static List<ImageIcon> images = new ArrayList<ImageIcon>();
	public void init() {
		fr.getContentPane().removeAll();
		fr.revalidate();
		fr.pack();
		fr.repaint();
		p_player = new JPanel();
		p_monster = new JPanel();
		lb_player = new JLabel();
		lb_monster = new JLabel();
		icon_player = new ImageIcon("src\\project\\asset\\model\\knight\\1.jpg");
		icon_monster = new ImageIcon("src\\project\\asset\\model\\knight\\1.jpg");
		lb_player.setIcon(icon_player);
		lb_monster.setIcon(icon_monster);
		p_player.add(lb_player);
		p_monster.add(lb_monster);
		fr.add(p_player,BorderLayout.NORTH);
		fr.add(p_monster,BorderLayout.SOUTH);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		fr.revalidate();
		fr.repaint();
//		img = new ImageIcon("src\\project\\asset\\model\\knight\\dumb-knight-12.gif");
//		images.add(img);

	}
	public void change() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		icon_player = new ImageIcon("src\\project\\asset\\model\\knight\\dumb-knight-12.gif");
		icon_monster = new ImageIcon("src\\project\\asset\\model\\knight\\dumb-knight-12.gif");
		lb_player.setIcon(null);
		lb_player.setIcon(icon_player);
		lb_monster.setIcon(null);
		lb_monster.setIcon(icon_monster);
	}
	public void hp_player() {
		hpbarp_player = new JPanel();
		hpbarp_player.setBounds(0,0, 300, 30);
		
		hpbar_player = new JProgressBar(0,300);
		hpbar_player.setPreferredSize(new Dimension(300,30));
		hpbar_player.setBackground(Color.RED);
		hpbar_player.setForeground(Color.GREEN);
		hpbar_player.setValue(300);
		hpbarp_player.add(hpbar_player);
		p_player.add(hpbarp_player);
	}
	public void hp_monster() {
		hpbarp_monster = new JPanel();
		hpbarp_monster.setBounds(0,0, 300, 30);
		
		hpbar_monster = new JProgressBar(0,500);
		hpbar_monster.setPreferredSize(new Dimension(300,30));
		hpbar_monster.setBackground(Color.RED);
		hpbar_monster.setForeground(Color.GREEN);
		hpbar_monster.setValue(500);
		hpbarp_monster.add(hpbar_monster);
		p_monster.add(hpbarp_monster);
	}
	public void textfield_hit() {
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(300,30));
		tf.setEditable(true);
		p_player.add(tf);
	}
	public void button_hit() {
		b_hit = new JButton("Hit");
		b_hit.addActionListener(this);
		p_player.add(b_hit);
	}
	public void b_change() {
		b_change = new JButton();
		b_change.setText("change");
		b_change.addActionListener(this);
		p_monster.add(b_change);
	}
	public void change_monster() {
		hpbar_monster.setValue(500);
		GameUTIL.hp_monster = 500;
		icon_monster = new ImageIcon("src\\project\\asset\\model\\knight\\1.jpg");
		lb_monster.setIcon(null);
		lb_monster.setIcon(icon_monster);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		icon_monster = new ImageIcon("src\\project\\asset\\model\\knight\\dumb-knight-12.gif");
		lb_monster.setIcon(null);
		lb_monster.setIcon(icon_monster);
	}
	public void change_to_cutscene() {
		b++;
		JLabel lb = new JLabel();
		fr.getContentPane().removeAll();
		fr.repaint();
		lb.setIcon(images.get(b));
		fr.add(lb);
		fr.validate();
		fr.repaint();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void change_to_fight() {
		fr.getContentPane().removeAll();
		fr.pack();
		fr.repaint();
		p_player.add(lb_player);
		p_monster.add(lb_monster);
		p_player.add(hpbarp_player);
		p_monster.add(hpbarp_monster);
		p_player.add(tf);
		p_player.add(b_hit);
		p_player.add(b_change);
		fr.add(p_player,BorderLayout.NORTH);
		fr.add(p_monster,BorderLayout.SOUTH);
		change_monster();
		p_player.validate();
		p_monster.validate();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void monster_dead() {
		BufferedImage bin = null;
		try {
			BufferedImage bim = ImageIO.read(new File("src\\project\\asset\\model\\knight\\dumb-knight-12.gif"));
			bin = new BufferedImage(bim.getWidth(), bim.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D createGraphics = bin.createGraphics();
			createGraphics.drawImage(bim, null, 0, 0);
			float alp[] = new float[] {1f,1f,1f,0.7f};
			float def[] = new float[] {0,0,0,0};
			RescaleOp r = new RescaleOp(alp,def,null);
			BufferedImage filter = r.filter(bin, null);
			lb_monster.setIcon(new ImageIcon(filter));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		float alp[] = new float[] {1f,1f,1f,0.5f};
		float def[] = new float[] {0,0,0,0};
		RescaleOp r = new RescaleOp(alp,def,null);
		BufferedImage filter = r.filter(bin, null);
		lb_monster.setIcon(new ImageIcon(filter));
	try {
		TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	alp = new float[] {1f,1f,1f,0.2f};
	def = new float[] {0,0,0,0};
	r = new RescaleOp(alp,def,null);
	filter = r.filter(bin, null);
	lb_monster.setIcon(new ImageIcon(filter));
	try {
		TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	alp = new float[] {1f,1f,1f,0};
	def = new float[] {0,0,0,0};
	r = new RescaleOp(alp,def,null);
	filter = r.filter(bin, null);
	lb_monster.setIcon(new ImageIcon(filter));
	try {
		TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	public void add_img() {
		img = new ImageIcon("src\\project\\asset\\model\\knight\\testbac.jpg");
		images.add(img);
		img = new ImageIcon("src\\project\\asset\\model\\knight\\testbac2.png");
		images.add(img);
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
				tf.setText("");
			}
		}
		else if(arg0.getSource()==b_change) {
			index_button = gu.rand.nextInt(10)+(a-1)*10;
			gu.hp_player -= 20;
			hpbar_player.setValue(gu.hp_player);
		}
		
		
	}

}
