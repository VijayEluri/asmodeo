package dev.macrobug.asmodeo.gui;

import dev.macrobug.asmodeo.core.StringCoder;

public class JCoder{
	private StringCoder coder;
	private String name;
	
	public JCoder(String name, StringCoder coder){
		this.coder=coder;
		this.name=name;
	}
	
	public String toString(){
		return name;
	}
	public StringCoder getCoder(){
		return coder;
	}
}
