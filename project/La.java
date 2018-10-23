package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

//import javax.imageio.ImageIO;
import javax.swing.*;

public class La implements ActionListener {
	static int a=1,d=0;
	Double sub;
//	int a = 0;
	static int hp_player;
	int dmg_monster;
	static int hp_monster;
	int dmg_player=50;
	ImageIcon icon_player,icon_monster;
	JLabel lb_player,lb_monster;
	JFrame fr;
	JPanel p_player,p_monster,hpbarp_player,hpbarp_monster;
	JProgressBar hpbar_player,hpbar_monster;
	JButton b,b1,b2,b_hit;
	JTextField tf;
	ImageIcon img =null;
	List<ImageIcon> images = new ArrayList<ImageIcon>();
	public void init() {
		fr = new JFrame();
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
		
		img = new ImageIcon("C:\\Users\\poom\\Desktop\\2.png");
		images.add(img);
		img = new ImageIcon("C:\\Users\\poom\\Desktop\\3.gif");
		images.add(img);
		
		hp_player = 300;
		dmg_monster = 10;
	}
	public void damage() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			hp_player = hp_player-dmg_monster;
			hpbar_player.setValue(hp_player);
		
	}
	public void change() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		icon_player = new ImageIcon("C:\\Users\\poom\\Desktop\\3.gif");
		icon_monster = new ImageIcon("C:\\Users\\poom\\Desktop\\3.gif");
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
		hp_monster = 500;
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
		return tf;
	}
	public JButton button_hit() {
		b_hit = new JButton("Hit");
		b_hit.addActionListener(this);
		return b_hit;
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
				hp_monster = 500;
	}
	public double computeAnother(String equation) {
        double result = 0.0;
        String noMinus = equation.replace("-", "+-");
        String[] byPluses = noMinus.split("\\+");

        for (String multipl : byPluses) {
            String[] byMultipl = multipl.split("\\*");
            double multiplResult = 1.0;
            for (String operand : byMultipl) {
                if (operand.contains("/")) {
                    String[] division = operand.split("\\/");
                    double divident = Double.parseDouble(division[0]);
                    for (int i = 1; i < division.length; i++) {
                        divident /= Double.parseDouble(division[i]);
                    }
                    multiplResult *= divident;
                } else {
                    multiplResult *= Double.parseDouble(operand);
                }
            }
            result += multiplResult;
        }

        return result;
    }
	public static void main(String[] args) {
		La l = new La();
		l.init();
		l.change();
		l.p_player.add(l.hp_player());
		l.p_monster.add(l.hp_monster());
		l.p_player.add(l.textfield_hit());
		l.p_player.add(l.button_hit());
		l.p_player.validate();
		while(a<5) {
		while(hp_monster!=0) {
			l.damage();
			
		}
		l.change_monster();
		a++;
	}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		La l = new La();
		Double num = l.computeAnother(tf.getText());
		System.out.println(num);
		if(arg0.getSource()==b_hit && num==24.0) {
			hp_monster = hp_monster-dmg_player;
			hpbar_monster.setValue(hp_monster);
//			tf.setText("");
//			if(hp_monster==0) {
//				a=1;
//			}
			System.out.println(a);
			System.out.println(hp_monster);
		}
		
		
	}

}
