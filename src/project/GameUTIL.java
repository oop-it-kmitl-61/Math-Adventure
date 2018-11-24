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
	static int d=0,time_dmg = 0 ;
	Double sub,num;
	static String num_24[][] = new String[][] {
//		"�ͧ�֧�ҡ���"
		{"2(5+4)","18"},
		{"2(8+3)","22"},
		{"2(7+6)","26"},
		{"(8-5)4","12"},
		{"(27-19)4","32"},
		{"(62-49)3","39"},
		{"5(7x3)","105"},
		{"(15/5)3","9"},
		{"(32/8)5","20"},
		{"(48/6)7","56"},
		{"(19+11)/3","10"},
		{"(81/9)8","72"},
		{"3(5+8)","39"},
		{"6(7+2)","54"},
		{"10(4+5)","90"},
		{"3(6+5)","33"},
		{"4(5+6)","44"},
		{"(56/8)7","49"},
		{"(18x4)+8","80"},
		{"(3x3)-5","4"},
		{"4(5+9)","56"},
		{"(4x4)-10","6"},//22

		{"(5-2)(2-2)","0"},
		{"(7+3)(6x4)","240"},
		{"(7-4)(5+4)","27"},
		{"(6x2)+(7x4)","40"},
		{"(8x3)+(9x2)","42"},
		{"(9x5)+(4x7)","73"},
		{"(3x3)+(2x5)","19"},
		{"(2x7)+(3x9)","41"},
		{"(3x5)+(3x8)","39"},
		{"(7x6)+(6x2)","54"},
		{"(4x10)+(10x5)","90"},
		{"(8x6)+(3x8)","72"},
		{"(4x5)+(4x6)","44"},
		{"(7x7)-(42/2)","28"},
		{"(3x6)-(6x2)","6"},
		{"(4x9)-(5x7)","11"},
		{"(7x9)-(5x7)","25"},
		{"(7x4)-(3x3)","37"},
		{"(8x6)-(3x9)","21"},
		{"(3x5)+(3x9)","42"},
		{"(5x9)-(6x3)","27"},
		{"(4x8)+(3x3)","41"},//22


		{"(4+7)(6-2)(1)","44"},
		{"(9+0)(4-1^5)","27"},
		{"(8-1^6)(2)(5)","70"},
		{"(3+6)(2)(1^7)","18"},
		{"(1)(6)(7)(2^2)","168"},
		{"(7)(4+1+4+1)","70"},
		{"(5+6)(2)(3)(1)","66"},
		{"(7+1)(9+2)","40"},
		{"(0+7)(9-3+1)","49"},
		{"(7+2)(2+5+0)","63"},
		{"(2+7)(5+5-1)", "81"},
		{"(1+8)(3)(3)(1)", "54"},
		{"(2+6+16)(2)","18"},
		{"(7)(7�12+4)","42"},
		{"(9�70)(3+2)", "40"},
		{"(7+16+4)(4)", "32"},
		{"(4+4+1)(5)(2)","90"},
		{"(0+7�1)(3+2)","30"},
		{"(5+1(4))(3+0)","27"},
		{"(7+18-6(4)", "76"},
		{"(7)(4)(3)", "84"},
		{"(3)(6)(1)(16)","18"},//22

		{"48/6x32","256"},
		{"72x14/8","126"},
		{"34/7x21","102"},
		{"61/7x21","183"},
		{"54x37/9","222"},
		{"63x18/7","162"},
		{"54/6x47","416"},
		{"81x18/9","162"},
		{"39x12/6","78"},
		{"108x13/9","156"},
		{"47/7x42","282"},
		{"63/9x17","119"},
		{"42x40/8","210"},
		{"71x45/9","353"},
		{"35/4x36","315"},
		{"25/12x60","125"},
		{"48/6x34","282"},
		{"56x27/9","168"},
		{"37x99/11","333"},
		{"66x49/7","462"},
		{"28x45/3","420"},
		{"110x42/11","10"},//22

		{"(125x7)+(7x55)","1260"},
		{"(105/5)+(216/3)","93"},
		{"(176/4)x(408/8)","2244"},
		{"(307-299)200","1600"},
		{"(288/12)6","144"},
		{"(204x50)/200","51"},
		{"(25x3)/(3x5)","5"},
		{"(44x8)+(9x44)","748"},
		{"(66x100)/33","200"},
		{"(1,008/12)5","420"},
		{"(18x4)+(18x6)","180"},
		{"(48+36)+(54+2)","140"},
		{"(18x24)/(24x9)","162"},
		{"(37x15)+(15x25)","930"},
		{"(101+85)-(209-114)","91"},
		{"(435-165)/(5x3)","18"},
		{"(200/8)x(122-119)","75"},
		{"27.4+32.6+5.8","65.8"},
		{"17.5+12.54+2.1","32.14"},
		{"135.6-52.8-14.96","67.84"},
		{"341+56.6+38.88+215.679", "652.159"},
		{"919.95-105-201.156-99.999","513.795"},//22

		{"(34.70x10)/5","69.4"},
		{"(36.7+2.254)/100","0.38954"},
		{"(93.63-89.76)x0.7", "2.709"},
		{"(212.24x1.4)-188.98","108.156"},
		{"(101.7-84.52)+186.50","203.68"},
		{"(91.97+18.52)x9.5","1049.655"},
		{"(352,901-293,785)+1,000","60116"},
		{"(41,295+26,215)-1,000","66510"},
		{"(1,400-1,298)+(3,005-2,198)","909"},
		{"(41x70)+(41x30)","4100"},
		{"(597-436)x(360/6)","9660"},
		{"(4,016-1,895)/7","303"},
		{"(574+426)x105","105000"},
		{"(438+262)x15","10500"},
		{"(737+472)x17","20553"},
		{"(46.43+87.37)+(153.47-68.12)","219.15"},
		{"(36+85)x33","3993"},
		{"(6577+488)/3","2355"},
		{"(65+65)x(49-36+8)","2730"},
		{"(8,347+967)-(3,947+67)","5300"},
		{"(36x258)+(36x25)","10188"},
		{"(39x9)+(39x9)","702"},//22
	};
	static int hp_player=300,hp_monster=500;
	int dmg_monster=10,dmg_player=50;
	public void damage() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(time_dmg!=5) {
			time_dmg+=1;
		}
		else {
		hp_player = hp_player-dmg_monster;
		GameGUI.hpbar_player.setValue(hp_player);
		time_dmg=0;
		}
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
