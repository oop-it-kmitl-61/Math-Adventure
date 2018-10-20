package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;

public class La implements ActionListener {
	int a = 0;
	ImageIcon icon;
	JLabel lb;
	JFrame fr;
	JPanel p;
	JButton b,b1,b2;
	ImageIcon img =null;
	List<ImageIcon> images = new ArrayList<ImageIcon>();
	public void init() {
		fr = new JFrame();
		p = new JPanel();
		lb = new JLabel();
		b = new JButton();
		b.addActionListener(this);
		b1 = new JButton();
		b1.addActionListener(this);
		b2 = new JButton();
		b2.addActionListener(this);
		icon = new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg");
		lb.setIcon(icon);
		p.add(lb);
		p.add(b);
		p.add(b1);
		p.add(b2);
		fr.add(p);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		img = new ImageIcon("C:\\Users\\poom\\Desktop\\2.png");
		images.add(img);
		
		img = new ImageIcon("C:\\Users\\poom\\Desktop\\3.gif");
		images.add(img);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		La l = new La();
		l.init();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==b) {
			lb.setIcon(null);
			icon = new ImageIcon("C:\\Users\\poom\\Desktop\\2.png");
			try {
				TimeUnit.MICROSECONDS.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lb.setIcon(icon);
		}
		else if(arg0.getSource()==b1) {
			lb.setIcon(null);
			icon = new ImageIcon("C:\\Users\\poom\\Desktop\\3.gif");
			try {
				TimeUnit.MICROSECONDS.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lb.setIcon(icon);
		}
		else {
			System.out.println(a);
			lb.setIcon(null);
//			icon = new ImageIcon("C:\\Users\\poom\\Desktop\\3.gif");
			icon = images.get(a);
			try {
				TimeUnit.MICROSECONDS.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lb.setIcon(icon);
			a++;
		}
		
		
	}

}
