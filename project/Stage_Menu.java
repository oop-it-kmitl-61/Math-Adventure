package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Stage_Menu implements ActionListener {
	Main m = new Main();
	private JFrame fr;
	private JPanel p1,p2,p3;
	private JButton bn_Stage1,bn_Stage2,bn_Stage3,bn_Stage4,bn_back;
	public void init2() {
		fr = new JFrame("Ad Game");
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(1000,1000);
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		bn_Stage1 = new JButton(new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg"));
		bn_Stage2 = new JButton(new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg"));
		bn_Stage3 = new JButton(new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg"));
		bn_Stage4 = new JButton(new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg"));
		bn_back = new JButton(new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg"));
		bn_back.addActionListener(this);
		p1.add(bn_Stage1);
		p1.add(bn_Stage2);
		p1.add(bn_Stage3);
		p1.add(bn_Stage4);
		p1.setLayout(new GridLayout(2,2));
		p2.add(bn_back);
		p3.add(p1,BorderLayout.NORTH);
		p3.add(p2,BorderLayout.SOUTH);
		fr.add(p3);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==bn_back) {
			fr.dispose();
			m.init();
		}
		
	}
}
