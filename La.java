package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class La implements ActionListener {
	static long seed;
	static Random rand;
	static int a=1,d=0,index_button = 0;
	Double sub,num;
	static String num_24[][] = new String[][] {
		{"6","8","2","2"},
		{"5","4","2","2"},
		{"8","4","4","2"},
		{"8","7","8","1"},
		{"5","4","4","8"},
		{"8","8","4","9"},
		{"1","5","5","9"},
		{"1","6","6","2"},
		{"6","4","2","2"},
		{"6","5","3","3"},
		{"6","7","2","2"},
		{"8","8","4","9"},
		{"1","6","3","6"},
		{"2","2","4","7"},
		{"5","6","4","8"},
		{"4","5","3","3"},
		{"6","5","6","2"},
		{"6","5","4","2"},
		{"7","4","2","8"},
		{"3","7","2","2"},
		{"7","3","8","1"},
		{"8","9","6","2"},
		{"8","8","3","1"},
		{"5","2","7","9"},
		{"2","6","5","6"},
		{"2","8","3","6"},
		{"2","7","3","6"},
		{"8","7","2","9"},
		{"8","1","4","5"},
		{"3","3","3","5"},
		{"2","9","5","6"}
	};
	static int hp_player;
	int dmg_monster;
	static int hp_monster;
	int dmg_player=50;
	ImageIcon icon_player,icon_monster;
	JLabel lb_player,lb_monster;
	JFrame fr;
	JPanel p_player,p_monster,hpbarp_player,hpbarp_monster,p;
	JProgressBar hpbar_player,hpbar_monster;
	JButton b1,b2,b3,b4,b_hit,b_plus,b_minus,b_multi,b_divide,b_eq,b_clear,b_change;
	JTextField tf;
	ImageIcon img =null;
	List<ImageIcon> images = new ArrayList<ImageIcon>();
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
		
		img = new ImageIcon("C:\\Users\\poom\\Desktop\\2.png");
		images.add(img);
		img = new ImageIcon("C:\\Users\\poom\\Desktop\\dumb-knight-12.gif");
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
		tf.setEditable(false);
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
	public JButton b1(int a) {
		b1 = new JButton();
		b1.setText(num_24[a][0]);
		b1.addActionListener(this);
		return b1;
	}
	public JButton b2(int a) {
		b2 = new JButton();
		b2.setText(num_24[a][1]);
		b2.addActionListener(this);
		return b2;
	}
	public JButton b3(int a) {
		b3 = new JButton();
		b3.setText(num_24[a][2]);
		b3.addActionListener(this);
		return b3;
	}
	public JButton b4(int a) {
		b4 = new JButton();
		b4.setText(num_24[a][3]);
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
	public static void main(String[] args) {
		La l = new La();
		seed = System.nanoTime( );
        rand = new Random( seed );
        index_button = rand.nextInt(30);
		l.init();
		l.change();
		l.p_player.add(l.hp_player());
		l.p_monster.add(l.hp_monster());
		l.p_player.add(l.textfield_hit());
		l.p_player.add(l.button_hit());
		l.p_player.add(l.b1(index_button));
		l.p_player.add(l.b2(index_button));
		l.p_player.add(l.b3(index_button));
		l.p_player.add(l.b4(index_button));
		l.p_monster.add(l.b_plus());
		l.p_monster.add(l.b_minus());
		l.p_monster.add(l.b_multi());
		l.p_monster.add(l.b_divide());
		l.p_monster.add(l.b_eq());
		l.p_monster.add(l.b_clear());
		l.p_monster.add(l.b_change());
		l.p_player.validate();
		l.p_monster.validate();
		while(a<5) {
		while(hp_monster>0) {
			l.damage();
			
		}
		l.change_monster();
		seed = System.nanoTime( );
        rand = new Random( seed );
        index_button = rand.nextInt(30);
		l.b1.setText(num_24[index_button][0]);
		l.b2.setText(num_24[index_button][1]);
		l.b3.setText(num_24[index_button][2]);
		l.b4.setText(num_24[index_button][3]);
		a++;
	}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		La l = new La();
		if(arg0.getSource()==b_hit) {
			num = l.computeAnother(tf.getText());
			if(num==24.0) {
				hp_monster = hp_monster-dmg_player;
				hpbar_monster.setValue(hp_monster);
				seed = System.nanoTime( );
				rand = new Random( seed );
				index_button = rand.nextInt(10)+(a-1)*10;
				b1.setText(num_24[index_button][0]);
				b2.setText(num_24[index_button][1]);
				b3.setText(num_24[index_button][2]);
				b4.setText(num_24[index_button][3]);
				tf.setText("");
				b1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				b4.setEnabled(true);
			}
		}
		else if(arg0.getSource()==b1) {
			tf.setText(tf.getText()+num_24[index_button][0]);
			b1.setEnabled(false);
		}
		else if(arg0.getSource()==b2) {
			tf.setText(tf.getText()+num_24[index_button][1]);
			b2.setEnabled(false);
		}
		else if(arg0.getSource()==b3) {
			tf.setText(tf.getText()+num_24[index_button][2]);
			b3.setEnabled(false);
		}
		else if(arg0.getSource()==b4) {
			tf.setText(tf.getText()+num_24[index_button][3]);
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
			num = l.computeAnother(tf.getText());
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
			index_button = rand.nextInt(10)+(a-1)*10;
			b1.setText(num_24[index_button][0]);
			b2.setText(num_24[index_button][1]);
			b3.setText(num_24[index_button][2]);
			b4.setText(num_24[index_button][3]);
			hp_player -= 20;
			hpbar_player.setValue(hp_player);
		}
		
		
	}

}
