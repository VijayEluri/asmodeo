package dev.macrobug.asmodeo.gui.listener;

import java.awt.event.*;
import javax.swing.*;

import dev.macrobug.asmodeo.gui.Calcolo;

public class CalcoR implements ActionListener{
	
	private JRadioButton[] jrb;
	private JTextField temp;
	
	public CalcoR(JRadioButton[] jrb){
		this.jrb=jrb;
		temp=new JTextField();
	}
	
	public void actionPerformed(ActionEvent eve){
		int i;
		for(i=0;i<jrb.length-1;i++)
			if(eve.getSource().equals(jrb[i]))
				break;
		switch(i){
			case 0:{temp.setText(""+2);break;}
			case 1:{temp.setText(""+8);break;}
			case 2:{temp.setText(""+10);break;}
			case 3:{temp.setText(""+16);break;}
			default:{
				System.out.println("Errore");
				System.exit(-1);
			}
		}
		Calcolo.change(temp);
	}
}