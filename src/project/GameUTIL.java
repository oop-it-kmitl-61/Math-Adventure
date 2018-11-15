package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.*;


public class GameUTIL{
	static long seed;
	static Random rand;
	static int d=0;
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
	static int hp_player=300,hp_monster=500;
	int dmg_monster=10,dmg_player=50;
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
			GameGUI.hpbar_player.setValue(hp_player);
		
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

}
