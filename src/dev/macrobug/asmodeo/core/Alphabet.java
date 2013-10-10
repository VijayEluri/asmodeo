package dev.macrobug.asmodeo.core;

import java.security.InvalidParameterException;

public class Alphabet {
	private String alphabet;
	
	private static boolean check(String alphabet){
		for(int i = 0; i < alphabet.length(); i++){
		   char c = alphabet.charAt(i);
		   if(alphabet.lastIndexOf(c)>i)
		  	 return false;
		}
		return true;
	}
	
	public Alphabet(String alphabet){
		if(!Alphabet.check(alphabet))
			throw new InvalidParameterException();
		this.alphabet=alphabet;
	}
	
	public Alphabet crop(int lenght){
		if(lenght==0)
			throw new InvalidParameterException();
		if(lenght>alphabet.length())
			throw new InvalidParameterException();
		if(lenght<0)
			return new Alphabet(alphabet.substring(-lenght));
		else
			return new Alphabet(alphabet.substring(0, lenght));
	}
	
	public Alphabet concat(String alphabet){
		return concat(new Alphabet(alphabet));
	}
	
	public Alphabet concat(Alphabet alphabet){
		return new Alphabet(this.alphabet+alphabet);
	}
	
	public char charAt(int i){
		return alphabet.charAt(i);
	}
	public int indexOf(char c){
		return alphabet.indexOf(c);
	}
}
