package dev.macrobug.asmodeo.core;

import static java.lang.Math.ceil;
import static java.lang.Math.log;

import java.security.InvalidParameterException;

import dev.macrobug.asmodeo.core.interfaces.Code;

public class Alphabet implements Code{
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
    return new Alphabet(this.alphabet+alphabet.alphabet);
  }
  
  public char charAt(int i){
    return alphabet.charAt(i);
  }
  public int indexOf(char c){
    return alphabet.indexOf(c);
  }

  @Override
  public int getBase() {
    return alphabet.length();
  }
  @Override
  public int getMax(){
    return (int)ceil(log(255)/log(getBase()));
  }
  @Override
  public boolean isValid(String s){
    for(Character c:s.toCharArray()){
      if(alphabet.indexOf(c)<0)
        return false;
    }
    return true;
  }
}
