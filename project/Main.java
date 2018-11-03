package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame implements ActionListener {
	public JFrame fr;
	private JPanel p1;
	private JButton bn_start,bn_exit;
	public void init() {
		fr = new JFrame("Ad Game");
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(1000,1000);
		
		p1 = new JPanel();
		bn_start = new JButton(new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg"));
		bn_exit = new JButton(new ImageIcon("C:\\Users\\poom\\Desktop\\1.jpg"));
		bn_start.addActionListener(this);
		bn_exit.addActionListener(this);
		p1.add(bn_start);
		p1.add(bn_exit);
		fr.add(p1,BorderLayout.SOUTH);
		fr.validate();
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.init();

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Stage_Menu sm = new Stage_Menu();
		if(arg0.getSource()==bn_start) {
			fr.dispose();
			sm.init2();
		}
		else if(arg0.getSource()==bn_exit) {
			System.exit(0);
		}
		
	}

}
