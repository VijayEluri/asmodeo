package dev.macrobug.asmodeo.core;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import static java.lang.Math.pow;
import dev.macrobug.asmodeo.core.interfaces.Coder;

public class IntegerCoder extends Coder<Integer> {

	public IntegerCoder(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public IntegerCoder(Alphabet alphabet2) {
		super(alphabet2);
		// TODO Auto-generated constructor stub
	}

	public IntegerCoder(Alphabet alphabet2, int max) {
		super(alphabet2, max);
		// TODO Auto-generated constructor stub
	}

	@Override
  public String encode(Integer i) {
		long t=i<0?1-i:i;
		final int MAX=alphabet.getMax();
		LinkedList<Character> stack=new LinkedList<Character>();
		while(t>=MAX){
			int resto=(int) (t%MAX);
			stack.addFirst(alphabet.charAt(resto));
			t/=MAX;
		}
		stack.addFirst(alphabet.charAt((int) t));
		StringBuilder ret=new StringBuilder(stack.size());
		for(Character c:stack)
			ret.append(c);
	  return ret.toString();
  }

	@Override
  public Integer decode(String s) {
		if(!alphabet.isValid(s))
			throw new InvalidParameterException();
		int ret=0,BASE=alphabet.getBase(),LEN=s.length();
		for(int i=0;i<LEN;i++){
			ret+=s.charAt(i)*pow(LEN-i,BASE);
		}
	  return ret;
  }

}
