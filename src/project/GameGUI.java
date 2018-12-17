package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class GameGUI implements ActionListener,KeyListener  {
	GameUTIL gu = new GameUTIL();
	static double num;
	static int a = 0,index_button=0;
	int b=2,i=0,change,c=0;
	static ImageIcon icon_player,icon_monster, icon_monster_character, icon_player_character;
	static JLabel lb_player,lb_monster, lb_player_character, lb_monster_character,txt, keeptxt;
	static JFrame fr;
	static JPanel p_player,p_monster,hpbarp_player,hpbarp_monster,p, p_chp, p_chm, p_cham;

	static JProgressBar hpbar_player,hpbar_monster;
	static JButton b1,b2,b3,b4,b_hit,b_plus,b_minus,b_multi,b_divide,b_eq,b_clear,b_change;
	static JTextField tf;
	static ImageIcon img =null;
	Image img_background,img_player,img_boss;
	static List<ImageIcon> images_cutscene = new ArrayList<ImageIcon>();
	static List<ImageIcon> images_history = new ArrayList<ImageIcon>();
	static List<ImageIcon> images_icon_boss = new ArrayList<ImageIcon>();
	static List<Image> images_boss = new ArrayList<Image>();
	static List<Image> images_crystal_boss = new ArrayList<Image>();
	String last_scene;
	BufferedImage bim,bim2,bin,bin2,filter,filter2;
	Graphics2D createGraphics,createGraphics2;
	RescaleOp r;
	
	public void change() throws Exception {
		tf.setEditable(false);
		for(float alp_img=0;alp_img<=1;alp_img+=0.1) {
		bim = (BufferedImage) ImageIO.read(new File("images\\knight\\dumb-knight-2.gif"));
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
		TimeUnit.MILLISECONDS.sleep(200);
		}
		lb_player_character.setIcon(icon_player_character);
		lb_monster_character.setIcon(images_icon_boss.get(a));
		tf.setEditable(true);
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
		tf.addKeyListener(this);
		p_player.add(tf);
	}
	public void button_hit() {
		b_hit = new JButton("Hit");
		b_hit.addActionListener(this);
		p_player.add(b_hit);
	}
	public void hp_monster() {
		hpbarp_monster = new JPanel();
		hpbarp_monster.setBounds(0,0, 300, 200);
		
		hpbar_monster = new JProgressBar(0,300);
		hpbar_monster.setPreferredSize(new Dimension(300,35));
		hpbar_monster.setBackground(Color.RED);
		hpbar_monster.setForeground(Color.GREEN);
		hpbar_monster.setValue(300);
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
	public void change_monster() throws Exception {
		GameUTIL.hp_monster = 300;
		hpbar_monster.setValue(GameUTIL.hp_monster);
		change();
	}
	public void change_to_cutscene() throws Exception {
		i=0;
		for(;c<b;c++) {
		change = 0;
		JLabel lb = new JLabel(new ImageIcon(images_history.get(c)+""));
		fr.getContentPane().removeAll();
		fr.repaint();
		fr.getContentPane().add(lb);
		fr.validate();
		fr.repaint();
		fr.requestFocus();
		fr.addKeyListener(this);
		while(change < 20) {
			if(i==1) {
				break;
			}
			TimeUnit.SECONDS.sleep(1);
			change++;
		}
		}
	}
	public void change_to_how() throws Exception {
		JLabel lb = new JLabel(new ImageIcon("images\\howtoplay.jpg"));
		fr.getContentPane().removeAll();
		fr.repaint();
		fr.getContentPane().add(lb);
		fr.validate();
		fr.repaint();
		fr.addKeyListener(this);
		while(change < 20) {
			if(this.i==1) {
				break;
			}
			TimeUnit.SECONDS.sleep(1);
			change++;
		}
	}
	public void change_to_first_cutscene() throws Exception {
		i=0;
		JLabel textbox = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("script.txt"), "UTF8"));
		for(int i=0;i<=14;i++) {
		if(i==14) {
			last_scene = br.readLine();
			break;
		}
		change = 0;
		JLabel lb = new JLabel(new ImageIcon(images_cutscene.get(i)+""));
		lb.setLayout(new BorderLayout());
	    String line = br.readLine();
	    textbox = new JLabel(line);	
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 28);
	    textbox.setFont(myFont);
		lb.add(textbox,BorderLayout.SOUTH);
		fr.getContentPane().removeAll();
		fr.repaint();
		fr.getContentPane().add(lb);
		fr.validate();
		fr.repaint();
		fr.addKeyListener(this);
		while(change < 20) {
			if(this.i==1) {
				break;
			}
			TimeUnit.SECONDS.sleep(1);
			change++;
		}
		}
		br.close();
	}
	public void change_to_fight(String back) throws Exception {
		fr.getContentPane().removeAll();
		fr.revalidate();
		fr.pack();
		fr.repaint();
		fr.getContentPane().setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon(back));
        background.setLayout(new BorderLayout());
        p_player = new TransparentPanel();
        p_monster = new JPanel();
        p_player.setBackground(new Color(0,0,0,0));
        p_chp = new JPanel();
        p_chm = new JPanel();
        p_cham = new TransparentPanel();
        p_cham.setLayout(new BorderLayout());
        p_cham.setBackground(new Color(0,0,0,0));
        JLabel keeptxt = new JLabel(new ImageIcon("images\\old_paper3.jpg"));
        lb_player = new JLabel();
        lb_player_character = new JLabel();
        lb_monster_character = new JLabel();
        lb_monster = new JLabel();
        txt = new JLabel(GameUTIL.num_24[index_button][0]);
        txt.setFont(new Font(txt.getFont().getName(), txt.getFont().getStyle(), 108));
        txt.setHorizontalAlignment(JLabel.CENTER);
        keeptxt.setLayout(new BorderLayout());
        keeptxt.add(txt, BorderLayout.CENTER);
        
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
        fr.getContentPane().add(background);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        fr.revalidate();
        fr.repaint();
		change_monster();
		p_player.validate();
		p_monster.validate();
		tf.requestFocus();
		TimeUnit.SECONDS.sleep(2);
	}
	public void change_to_end() throws Exception {
		i=0;
		for(int i=14;i<=15;i++) {
		change = 0;
		JLabel lb = new JLabel(new ImageIcon(images_cutscene.get(i)+""));
		lb.setLayout(new BorderLayout());
		if(i==14) {
		JLabel textbox = new JLabel(last_scene);	
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 28);
	    textbox.setFont(myFont);
		lb.add(textbox,BorderLayout.SOUTH);
		}
		fr.getContentPane().removeAll();
		fr.repaint();
		fr.getContentPane().add(lb);
		fr.validate();
		fr.repaint();
		fr.addKeyListener(this);
		fr.requestFocus();
		while(change < 20) {
			if(this.i==1) {
				break;
			}
			TimeUnit.SECONDS.sleep(1);
			change++;
		}
		}
		fr.getContentPane().removeAll();
		fr.revalidate();
		fr.pack();
		fr.repaint();
		fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel time = new JLabel(new ImageIcon("images\\old_paper1.jpg"));
		time.setLayout(new BorderLayout());
		JLabel textbox = new JLabel(gu.leaderboard,SwingConstants.CENTER);	
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 34);
	    textbox.setFont(myFont);
		time.add(textbox,BorderLayout.CENTER);
		fr.getContentPane().add(time);
		this.i=0;
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
		BufferedImage bim2 = (BufferedImage) images_crystal_boss.get(0);
		BufferedImage bin2 = new BufferedImage(bim2.getWidth(), bim2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D createGraphics2= bin2.createGraphics();
		createGraphics2.drawImage(bim2, null, 0, 0);
		float alp[] = new float[] {1f,1f,1f,alp_img};
		float def[] = new float[] {0,0,0,0};
		RescaleOp r = new RescaleOp(alp,def,null);
		BufferedImage filter2 = r.filter(bin2, null);
		lb_monster_character.setIcon(new ImageIcon(filter2));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void player_dead() throws Exception {
		txt.setText(null);
		for(float alp_img=0;alp_img<=1;alp_img+=0.25) 
		{
		BufferedImage bim2 = null;
		try {
			bim2 = (BufferedImage) ImageIO.read(new File("images\\banner\\gameover.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		};
		BufferedImage bin2 = new BufferedImage(bim2.getWidth(), bim2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D createGraphics2= bin2.createGraphics();
		createGraphics2.drawImage(bim2, null, 0, 0);
		float alp[] = new float[] {1f,1f,1f,alp_img};
		float def[] = new float[] {0,0,0,0};
		RescaleOp r = new RescaleOp(alp,def,null);
		BufferedImage filter2 = r.filter(bin2, null);
		txt.setIcon(new ImageIcon(filter2));
		TimeUnit.MILLISECONDS.sleep(500);
		}
		TimeUnit.MILLISECONDS.sleep(1000);
	}
	public void add_img() throws IOException {
		icon_player = new ImageIcon("images\\knight\\badge_222.png");
        icon_monster = new ImageIcon("images\\knight\\badge_111.png");
        
        icon_player_character = new ImageIcon("images\\knight\\dumb-knight-2.gif");
        
		img = new ImageIcon("images\\cutscene\\Paper.Project.1.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.2.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.3.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.4.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.5.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.6.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.7.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.8.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.9.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.10.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.11.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.12.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.13.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.14.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.15.jpg");//add cutsecene
		images_cutscene.add(img);
		img = new ImageIcon("images\\cutscene\\Paper.Project.16.jpg");//add cutsecene
		images_cutscene.add(img);
		
		img = new ImageIcon("images\\Stage Scene\\Babilonia\\Babilonia_st.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Babilonia\\Babilonia_1.jpg");
		images_history.add(img);
		
		img = new ImageIcon("images\\Stage Scene\\Greek\\Greek_st.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Greek\\Greek_1.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Greek\\Greek_2.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Greek\\Greek_3.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Greek\\Greek_4.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Greek\\Greek_5.jpg");
		images_history.add(img);
		
		img = new ImageIcon("images\\Stage Scene\\Middle (stage 3)\\Middle_st_1.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Middle (stage 3)\\Middle_1_1.jpg");
		images_history.add(img);
		
		img = new ImageIcon("images\\Stage Scene\\Renaissance\\Renaissance_st.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Renaissance\\Renaissance_1.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Renaissance\\Renaissance_2.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Renaissance\\Renaissance_3.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Renaissance\\Renaissance_4.jpg");
		images_history.add(img);
		
		img = new ImageIcon("images\\Stage Scene\\New-era\\New-era.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\New-era\\New-era_1.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\New-era\\New-era_2.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\New-era\\New-era_3.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\New-era\\New-era_4.jpg");
		images_history.add(img);
		
		img = new ImageIcon("images\\Stage Scene\\Present\\Present_st.jpg");
		images_history.add(img);
		img = new ImageIcon("images\\Stage Scene\\Present\\Present_1.jpg");
		images_history.add(img);
		
		img_boss = ImageIO.read(new File("images\\knight\\cystal_1.png"));
		images_crystal_boss.add(img_boss);

		img_boss = ImageIO.read(new File("images\\knight\\boss_1.gif"));//add boss for opa
		images_boss.add(img_boss);
		img_boss = ImageIO.read(new File("images\\knight\\boss_2.gif"));
		images_boss.add(img_boss);
		img_boss = ImageIO.read(new File("images\\knight\\boss_3.gif"));
		images_boss.add(img_boss);
		img_boss = ImageIO.read(new File("images\\knight\\boss_4.gif"));
		images_boss.add(img_boss);
		img_boss = ImageIO.read(new File("images\\knight\\boss_5.gif"));
		images_boss.add(img_boss);
		img_boss = ImageIO.read(new File("images\\knight\\boss_6.gif"));
		images_boss.add(img_boss);
		
		img = new ImageIcon("images\\knight\\boss_1.gif");//add boss for icon
		images_icon_boss.add(img);
		img = new ImageIcon("images\\knight\\boss_2.gif");//add boss for icon
		images_icon_boss.add(img);
		img = new ImageIcon("images\\knight\\boss_3.gif");//add boss for icon
		images_icon_boss.add(img);
		img = new ImageIcon("images\\knight\\boss_4.gif");//add boss for icon
		images_icon_boss.add(img);
		img = new ImageIcon("images\\knight\\boss_5.gif");//add boss for icon
		images_icon_boss.add(img);
		img = new ImageIcon("images\\knight\\boss_6.gif");//add boss for icon
		images_icon_boss.add(img);
		
		img = new ImageIcon("images\\knight\\dumb-knight-action.gif");
	}
	 public boolean Checknum(String input) 
	    {     
	        try 
	        { 
	            // checking valid integer using parseInt() method 
	            Double.parseDouble(input); 
	            return true;
	        }  
	        catch (NumberFormatException e)  
	        { 
	            return false;
	        } 
	          
	    } 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==b_hit && Checknum(tf.getText())) {
			try {
			num = Double.parseDouble(tf.getText());
			}
			catch(NumberFormatException e){	
				System.out.println("please enter number");
			}
			if(num==Double.parseDouble(gu.num_24[index_button][1])) {
				gu.hp_monster = gu.hp_monster -(gu.dmg_player);
				FileInputStream fin = null;
				try {
					fin = new FileInputStream("sound\\hitsoco.mp3");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				Player p;
					try {
						p = new Player(fin);
						p.play();
					} catch (JavaLayerException e) {
						e.printStackTrace();
					}
				hpbar_monster.setValue(gu.hp_monster);
				gu.seed = System.nanoTime( );
				gu.rand = new Random( gu.seed );
				index_button = gu.rand.nextInt(23)+(a*40);
				tf.setText("");
				tf.requestFocus();
				if(gu.hp_monster > 0) {
					txt.setText(GameUTIL.num_24[index_button][0]);
				} else {
					txt.setText("");
				}
			}
			else {
				gu.hp_player -= 10;
				hpbar_player.setValue(gu.hp_player);
			}
		}
		else if(arg0.getSource()==b_change) {
			if(gu.hp_player>0) {
			gu.seed = System.nanoTime( );
			gu.rand = new Random( gu.seed );
			index_button = gu.rand.nextInt(23)+(a*40);
			gu.hp_player -= 20;
			hpbar_player.setValue(gu.hp_player);
			txt.setText(GameUTIL.num_24[index_button][0]);
			tf.requestFocus();
		}
		}
		
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		 if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
			 try {
				num = 1;
				}
				catch(NumberFormatException e){	
					System.out.println("please enter number");
				}
		    }
		 else if(arg0.getKeyCode()==KeyEvent.VK_SPACE) {
			 change = 20;
		 }
		 else if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
		    {
		        i=1;
		    }
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
}
}