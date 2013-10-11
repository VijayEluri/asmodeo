package dev.macrobug.asmodeo.core;

import org.junit.*;
import static org.junit.Assert.*;

public class AlphabetTest{
	private Alphabet bin,ott,dec,hex,cus;
	
	@Before
  public void setUp(){
		bin=new Alphabet("01");
		ott=new Alphabet("01234567");
		dec=new Alphabet("0123456789");
		hex=new Alphabet("0123456789abcdef");
		cus=new Alphabet("0123456789abcdefghijklmnopqrstuvwxyz");
  }
	@Test
	public void testCrop(){
	}
	@Test
	public void testConcat(String alphabet){
	}
	@Test
	public void testCharAt(){
	}
	@Test
	public void testIndexOf(){
	}
	@Test
  public void testGetBase() {
  }
	@Test
	public void testGetMax(){
	}
}
