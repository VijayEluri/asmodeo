package dev.macrobug.asmodeo.core.interfaces;

import dev.macrobug.asmodeo.core.Alphabet;

public abstract class Coder<T> {
	public abstract String encode(T t);
	public abstract T decode(String s);
	
	protected Alphabet alphabet;
	protected String charPadding;
	protected boolean padding;
	
	public Coder(String s){ this(new Alphabet(s)); }
	public Coder(Alphabet alphabet2) {this(alphabet2,alphabet2.getMax());  }
	public Coder(Alphabet alphabet2, int max) {this(alphabet2.crop(max),true);}
	public Coder(Alphabet alphabet,int max, boolean b){this(alphabet.crop(max),b);}
	public Coder(Alphabet alphabet2, boolean b) {
		alphabet=alphabet2;
		padding=b;
		charPadding=""+alphabet2.charAt(0);
  }
}
