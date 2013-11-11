package dev.macrobug.asmodeo.core;

import java.util.StringTokenizer;

import dev.macrobug.asmodeo.core.interfaces.Coder;

public class StringCoder extends Coder<String>{
  
  private char charPadding;
  private boolean padding;
  private IntegerCoder coder;
  private int MAX;
  
  // pagging
  public StringCoder(String s){ this(new Alphabet(s)); }
  public StringCoder(Alphabet alphabet2) {this(alphabet2,true);  }
  public StringCoder(Alphabet alphabet2, int max) { this(alphabet2,true,max); }
  public StringCoder(String s, boolean b){ this(new Alphabet(s),b); }
  public StringCoder(Alphabet alphabet2, boolean b){ this(alphabet2,b,b?alphabet2.getBase():' '); }
  public StringCoder(Alphabet alphabet2, boolean b, int max2) {this(alphabet2,b,' ',max2);}
  // no padding
  public StringCoder(String s, char c){ this(new Alphabet(s),c); }
  public StringCoder(Alphabet alphabet2, char c){ this(alphabet2,false,c); }
  
  private StringCoder(Alphabet alphabet2, boolean b, char c) {this(alphabet2,b,c,alphabet2.getBase()); }
  private StringCoder(Alphabet a, boolean b, char c, int d){
    super(a,d);
    coder=new IntegerCoder(a,d);
    padding=b;
    if(b)
      charPadding=a.charAt(0);
    else
      charPadding=c;
    MAX=alphabet.getMax();
  }

  @Override
  public String encode(String s) {
    StringBuilder build=new StringBuilder();
    for(Byte c:s.getBytes()){
      String t=coder.encode(c.intValue());
      if(padding)
        while(t.length()<MAX) t=charPadding+t;
      else
        t+=charPadding;
      build.append(t);
    }
    return padding?build.toString():build.substring(0, build.length()-1);
  }
  @Override
  public String decode(String s) {
    StringBuilder ret = new StringBuilder();
    if(padding){
      for(int i=0;i<s.length();i+=MAX){
        ret.append(Character.toChars(coder.decode(s.substring(i, i+MAX))));
      }
    }else{
      StringTokenizer st=new StringTokenizer(s,""+charPadding);
      while(st.hasMoreTokens()){
        ret.append(Character.toChars(coder.decode(st.nextToken())));
      }
    }
    return ret.toString();
  }
}
