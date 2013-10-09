package dev.macrobug.asmodeo.gui.listener;

import java.awt.event.*;
import javax.swing.*;

public class Bottoni implements ActionListener{
	
	private Princi ascolto;
	private Scr liste;
	private JTextArea out;
	private JTextField in;
	private boolean bool;
	private JLabel cod,num;
	private JButton b;
	private JFrame f;
	private JCheckBoxMenuItem cb;
	
	public Bottoni(JCheckBoxMenuItem cb,JTextField in,JTextArea out,JButton b,boolean bool,JLabel cod,JLabel num,JFrame f){
		this.b=b;
		this.cb=cb;
		this.f=f;
		this.cod=cod;
		this.num=num;
		this.in=in;
		this.bool=bool;
		this.out=out;
		}
		
	public void actionPerformed(ActionEvent e){
        b.setEnabled(true);
        in.setEditable(true);
        out.setText("");
        in.setText("");
        in.requestFocus();
        ActionListener[] action=b.getActionListeners();
        for(int i=0;i<action.length;i++){
        	try{b.removeActionListener(action[i]);}
        	catch(Exception ex){}}
		ascolto=new Princi(cb,b,in,out,cod,num);
		liste=new Scr(cb,in,out,cod,num,f);
		if(bool)
			b.addActionListener(liste);
		else
			b.addActionListener(ascolto);
			
		}
	}
	