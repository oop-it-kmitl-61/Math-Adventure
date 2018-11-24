package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
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
import javax.swing.border.LineBorder;

import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.tk.Toolkit;
import com.sun.prism.Graphics;

public class GameGUI implements ActionListener  {
	double num;
//	float alp_img;
	int a = 0, b=-1, index_button=0;
	static ImageIcon icon_player,icon_monster, icon_monster_character, icon_player_character;
	static JLabel lb_player,lb_monster, lb_player_character, lb_monster_character,txt, keeptxt;
	static JFrame fr;
	static JPanel p_player,p_monster,hpbarp_player,hpbarp_monster,p, p_chp, p_chm, p_cham;

	static JProgressBar hpbar_player,hpbar_monster;
	static JButton b1,b2,b3,b4,b_hit,b_plus,b_minus,b_multi,b_divide,b_eq,b_clear,b_change;
	static JTextField tf;
	ImageIcon img =null;
	Image img_background,img_player,img_boss;
	static List<ImageIcon> images = new ArrayList<ImageIcon>();
	static List<Image> images_background = new ArrayList<Image>();
	static List<Image> images_boss = new ArrayList<Image>();
	static List<Image> images_crystal_boss = new ArrayList<Image>();
	
	BufferedImage bim,bim2,bin,bin2,filter,filter2;
	Graphics2D createGraphics,createGraphics2;
	RescaleOp r;
	
//	public void init() {
//
//        GameGUI gui = new GameGUI();
//        p = new JPanel();
//
//        fr.getContentPane().removeAll();
//        fr.revalidate();
//        fr.pack();
//        fr.repaint();
//        fr.setLayout(new BorderLayout());
//        JLabel background=new JLabel(new ImageIcon("C:\\\\Users\\\\Cystle0\\\\eclipse-workspace\\\\projectjava\\\\Adventure-Game-OOP-Project\\\\images\\\\UZKEjzG.png"));
//        background.setLayout(new BorderLayout());
//        p_player = new JPanel();
//        p_monster = new JPanel();
//        p_player.setBackground(new Color(0,0,0,0));
//        p_chp = new JPanel();
//        p_chm = new JPanel();
//        lb_player = new JLabel();
//        lb_player_character = new JLabel();
//        lb_monster_character = new JLabel();
//        lb_monster = new JLabel();
//        txt = new JLabel(GameUTIL.num_24[index_button][0]);
//        txt.setFont(new Font(txt.getFont().getName(), txt.getFont().getStyle(), 108));
//        txt.setHorizontalAlignment(JLabel.CENTER);
//        txt.setPreferredSize( new Dimension( 1000, 300 ) );
//        icon_player = new ImageIcon("asset\\model\\knight\\badge_22.png");
//        icon_monster = new ImageIcon("asset\\model\\knight\\badge_11.png");
//        
//        icon_player_character = new ImageIcon("asset\\model\\knight\\dumb-knight-12.gif");
////      icon_monster_character = new ImageIcon("asset\\model\\knight\\Random_dragon_gif_by_ribozurai-d30makh.gif");
//        
////      lb_player_character.setIcon(icon_player_character);
////      lb_monster_character.setIcon(icon_monster_character);
//        
//        lb_player.setIcon(icon_player);
//        lb_monster.setIcon(icon_monster);
//
//        
//        p_player.add(lb_player);
//        hp_player();
//        textfield_hit();
//        button_hit();
//        b_change();
//        hp_monster();
//        p_player.add(lb_monster);
//        background.add(p_player,BorderLayout.NORTH);
//        background.add(lb_player_character,BorderLayout.WEST);
//        background.add(lb_monster_character,BorderLayout.EAST);
//        background.add(txt,BorderLayout.SOUTH);
//        fr.add(background);
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fr.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//        
//        fr.revalidate();
//        fr.repaint();
//        
////      for(float alp_img=0;alp_img<=1;alp_img+=0.1) 
////      {
////      BufferedImage bim = (BufferedImage) img_player;
////      BufferedImage bim2 = (BufferedImage) images_boss.get(a);
////      BufferedImage bin = new BufferedImage(bim.getWidth(), bim.getHeight(), BufferedImage.TYPE_INT_ARGB);
////      BufferedImage bin2 = new BufferedImage(bim2.getWidth(), bim2.getHeight(), BufferedImage.TYPE_INT_ARGB);
////      Graphics2D createGraphics = bin.createGraphics();
////      Graphics2D createGraphics2= bin2.createGraphics();
////      createGraphics.drawImage(bim, null, 0, 0);
////      createGraphics2.drawImage(bim2, null, 0, 0);
////      float alp[] = new float[] {1f,1f,1f,alp_img};
////      float def[] = new float[] {0,0,0,0};
////      RescaleOp r = new RescaleOp(alp,def,null);
////      BufferedImage filter = r.filter(bin, null);
////      BufferedImage filter2 = r.filter(bin2, null);
////      lb_player_character.setIcon(new ImageIcon(filter));
////      lb_monster_character.setIcon(new ImageIcon(filter2));
////      try {
////          TimeUnit.MILLISECONDS.sleep(200);
////      } catch (InterruptedException e) {
////          e.printStackTrace();
////      }
////      }
//        change();
//	}
	public void change() {
		tf.setEditable(true);
		for(float alp_img=0;alp_img<=1;alp_img+=0.1) 
		{
		try {
			bim = (BufferedImage) ImageIO.read(new File("asset\\model\\knight\\YSERA_DRAGON.gif"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		bim2 = (BufferedImage) images_boss.get(a);
		bin = new BufferedImage(bim.getWidth(), bim.getHeight(), BufferedImage.TYPE_INT_ARGB);
		bin2 = new BufferedImage(bim2.getWidth(), bim2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		createGraphics = bin.createGraphics();
		createGraphics2= bin2.createGraphics();
		createGraphics.drawImage(bim, null, 0, 0);
		createGraphics2.drawImage(bim2, null, 0, 0);
		float alp[] = new float[] {1f,1f,1f,alp_img};
		float def[] = new float[] {0,0,0,0};
		r = new RescaleOp(alp,def,null);
		filter = r.filter(bin, null);
		filter2 = r.filter(bin2, null);
		lb_player_character.setIcon(new ImageIcon(filter));
		lb_monster_character.setIcon(new ImageIcon(filter2));
		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		lb_player_character.setIcon(icon_player_character);
	}
	public void hp_player() {
		hpbarp_player = new JPanel();
		hpbarp_player.setBounds(0,0, 300, 200);
		
		hpbar_player = new JProgressBar(0,300);
		hpbar_player.setPreferredSize(new Dimension(300,35));
		hpbar_player.setBackground(Color.RED);
		hpbar_player.setForeground(Color.GREEN);
		hpbar_player.setValue(300);
		hpbarp_player.add(hpbar_player);
		p_player.add(hpbarp_player);
	}
	public void textfield_hit() {
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(300,30));
		tf.setEditable(true);
		p_player.add(tf);
		tf.requestFocusInWindow();
	}
	public void button_hit() {
		b_hit = new JButton("Hit");
		b_hit.addActionListener(this);
		p_player.add(b_hit);
	}
	public void hp_monster() {
		hpbarp_monster = new JPanel();
		hpbarp_monster.setBounds(0,0, 300, 200);
		
		hpbar_monster = new JProgressBar(0,500);
		hpbar_monster.setPreferredSize(new Dimension(300,35));
		hpbar_monster.setBackground(Color.RED);
		hpbar_monster.setForeground(Color.GREEN);
		hpbar_monster.setValue(500);
		hpbarp_monster.add(hpbar_monster);
		p_player.add(hpbarp_monster);
	}
	private class TransparentPanel extends JPanel {
	    {
	        setOpaque(false);
	    }
	    public void paintComponent(Graphics g) {
	        ((java.awt.Graphics) g).setColor(getBackground());
	        java.awt.Rectangle r = ((java.awt.Graphics) g).getClipBounds();
	        g.fillRect(r.x, r.y, r.width, r.height);
	        super.paintComponent((java.awt.Graphics) g);
	    }
	}
	public void b_change() {
		b_change = new JButton();
		b_change.setText("change");
		b_change.addActionListener(this);
		p_player.add(b_change);
	}
	public void change_monster() {
		hpbar_monster.setValue(500);
		GameUTIL.hp_monster = 500;
		change();
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
			e.printStackTrace();
		}
	}
	public void change_to_fight(String back) {
		fr.getContentPane().removeAll();
        fr.revalidate();
        fr.pack();
        fr.repaint();
        fr.setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon(back));
        background.setLayout(new BorderLayout());
        p_player = new TransparentPanel();
        p_monster = new JPanel();
        p_player.setBackground(new Color(0,0,0,0));
        p_chp = new JPanel();
        p_chm = new JPanel();
        p_cham = new TransparentPanel();
        p_cham.setLayout(new BorderLayout());
        JLabel keeptxt = new JLabel(new ImageIcon("C:\\\\\\\\Users\\\\\\\\Cystle0\\\\\\\\eclipse-workspace\\\\\\\\projectjava\\\\\\\\Adventure-Game-OOP-Project\\\\\\\\images\\\\\\\\old_paper.jpg"));
        lb_player = new JLabel();
        lb_player_character = new JLabel();
        lb_monster_character = new JLabel();
        lb_monster = new JLabel();
        txt = new JLabel(GameUTIL.num_24[index_button][0]);
        txt.setFont(new Font(txt.getFont().getName(), txt.getFont().getStyle(), 108));
        txt.setHorizontalAlignment(JLabel.CENTER);
        keeptxt.setLayout(new BorderLayout());
        keeptxt.add(txt, BorderLayout.CENTER);
        
        icon_player = new ImageIcon("asset\\model\\knight\\badge_22.png");
        icon_monster = new ImageIcon("asset\\model\\knight\\badge_11.png");
        
        icon_player_character = new ImageIcon("asset\\model\\knight\\YSERA_DRAGON.gif");
        icon_monster_character = new ImageIcon("asset\\model\\knight\\Random_dragon_gif_by_ribozurai-d30makh.gif");
        
//      lb_player_character.setIcon(icon_player_character);
//      lb_monster_character.setIcon(icon_monster_character);
        
        lb_player.setIcon(icon_player);
        lb_monster.setIcon(icon_monster);
        
        p_cham.add(lb_player_character, BorderLayout.WEST);
        p_cham.add(lb_monster_character, BorderLayout.EAST);
        p_player.add(lb_player);
        hp_player();
        textfield_hit();
        button_hit();
        b_change();
        hp_monster();
        p_player.add(lb_monster);

        
        background.add(p_player,BorderLayout.NORTH);
        background.add(keeptxt,BorderLayout.CENTER);
        background.add(p_cham,BorderLayout.SOUTH);
        fr.add(background);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        fr.revalidate();
        fr.repaint();
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
		tf.setEditable(false);
		for(float alp_img=1;alp_img>=0;alp_img-=0.1) 
		{
		BufferedImage bim2 = (BufferedImage) images_boss.get(a);
		BufferedImage bin2 = new BufferedImage(bim2.getWidth(), bim2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D createGraphics2= bin2.createGraphics();
		createGraphics2.drawImage(bim2, null, 0, 0);
		float alp[] = new float[] {1f,1f,1f,alp_img};
		float def[] = new float[] {0,0,0,0};
		RescaleOp r = new RescaleOp(alp,def,null);
		BufferedImage filter2 = r.filter(bin2, null);
		lb_monster_character.setIcon(new ImageIcon(filter2));
		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		for(float alp_img=0;alp_img<=1;alp_img+=0.5) 
		{
		BufferedImage bim2 = (BufferedImage) images_crystal_boss.get(a);
		BufferedImage bin2 = new BufferedImage(bim2.getWidth(), bim2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D createGraphics2= bin2.createGraphics();
		createGraphics2.drawImage(bim2, null, 0, 0);
		float alp[] = new float[] {1f,1f,1f,alp_img};
		float def[] = new float[] {0,0,0,0};
		RescaleOp r = new RescaleOp(alp,def,null);
		BufferedImage filter2 = r.filter(bin2, null);
		lb_monster_character.setIcon(new ImageIcon(filter2));
		}
	}
	public void add_img() {
		img = new ImageIcon("asset\\model\\knight\\testbac.jpg");
		images.add(img);
		img = new ImageIcon("asset\\model\\knight\\testbac2.png");
		images.add(img);
		try {
			img_boss = ImageIO.read(new File("asset\\model\\knight\\cystal_11.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		images_crystal_boss.add(img_boss);
		
		try {
			img_player = ImageIO.read(new File("asset\\model\\knight\\1520714775_tumblr_nzglpyfmE81tn3u0ao1_500.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			img_boss = ImageIO.read(new File("asset\\model\\knight\\1520714775_tumblr_nzglpyfmE81tn3u0ao1_500.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		images_boss.add(img_boss);
		try {
			img_boss = ImageIO.read(new File("asset\\model\\knight\\boss_22.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		images_boss.add(img_boss);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		GameUTIL gu = new GameUTIL();
		if(arg0.getSource()==b_hit) {
			num = Double.parseDouble(tf.getText());
			if(num==Double.parseDouble(gu.num_24[index_button][1])) {
				gu.hp_monster = gu.hp_monster-gu.dmg_player;
				hpbar_monster.setValue(gu.hp_monster);
				gu.seed = System.nanoTime( );
				gu.rand = new Random( gu.seed );
				index_button = gu.rand.nextInt(23)+(a*22);
				tf.setText("");
				tf.requestFocusInWindow();
				if(gu.hp_monster > 0) {
					txt.setText(GameUTIL.num_24[index_button][0]);
				} else {
					txt.setText("");
				}
			}
		}
		else if(arg0.getSource()==b_change) {
			gu.seed = System.nanoTime( );
			gu.rand = new Random( gu.seed );
			index_button = gu.rand.nextInt(23)+(a*22);
			gu.hp_player -= 20;
			hpbar_player.setValue(gu.hp_player);
			txt.setText(GameUTIL.num_24[index_button][0]);
		}
		
		
	}

}
