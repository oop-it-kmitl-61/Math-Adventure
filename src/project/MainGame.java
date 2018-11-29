package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class MainGame{
	public static void main(String[] args) {
		int locks = 0,state = 0;
		GameGUI gui = new GameGUI();
		GameUTIL util = new GameUTIL();
		util.bonus_dmg=5;
		String[] backgroundlist = {"images\\bg_1_169.jpg", 
				"images\\bg_2_169.jpg", 
				"images\\bg_3_169.jpg", 
				"images\\bg_4_169.jpg",
				"images\\bg_5_169.jpg", 
				"images\\Bg_castle_1.png"};
		new HomePage();
		while(util.d==0) {
			System.out.println(util.d);
		}
		while(gui.a<=5) {
			if(locks == 0) {
				util.seed = System.nanoTime( );
				util.rand = new Random( util.seed );
				gui.index_button = util.rand.nextInt(23)+(gui.a*40);
				try {
					gui.add_img();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gui.change_to_first_cutscene();
				gui.change_to_cutscene();
				gui.change_to_fight(backgroundlist[state]);
				locks = 1;
			}
			while(util.hp_monster>0&&util.hp_player>0) {
				util.damage();
			}
			if(util.hp_monster<=0) {
				state++;
				gui.monster_dead();
				util.hp_player=300;
				gui.a++;
				switch(gui.a) {
				case 1:gui.b+=6;
				break;
				case 2:gui.b+=2;
				break;
				case 3:gui.b+=5;
				break;
				case 4:gui.b+=5;
				break;
				case 5:gui.b+=2;
				break;
				}
				util.seed = System.nanoTime( );
				util.rand = new Random( util.seed );
		        gui.index_button = util.rand.nextInt(23)+(gui.a*40);
		        gui.txt.setText(util.num_24[gui.index_button][0]);
				gui.change_to_cutscene();
				gui.change_to_fight(backgroundlist[state]);
				util.bonus_dmg=5;
			}
			else if(util.hp_player<=0) {
				gui.player_dead();
				state = 0;
				gui.fr.dispose();
				util.hp_player=300;
				gui.a=0;
				util.d=0;
				util.hp_monster=300;
				main(args);
			}
		}
	}

}