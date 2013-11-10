package dev.macrobug.asmodeo.core.interfaces;

import dev.macrobug.asmodeo.core.Alphabet;

public abstract class Coder<T> {
	public abstract String encode(T t);
	public abstract T decode(String s);
	
	protected Alphabet alphabet;
	
	public Coder(String s){ this(new Alphabet(s)); }
	public Coder(Alphabet alphabet2) {this(alphabet2,alphabet2.getBase());  }
	public Coder(Alphabet alphabet2, int max) {
		alphabet=alphabet2.crop(max);
	}
}
