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
		try{
			bin.crop(-3);
			assertTrue(false);
		}catch(Exception e){
			assertTrue(true);
		}
		try{
			ott.crop(0);
			assertTrue(false);
		}catch(Exception e){
			assertTrue(true);
		}
		try{
			dec.crop(20);
			assertTrue(false);
		}catch(Exception e){
			assertTrue(true);
		}
	  Alphabet tmp=hex.crop(-3);
	  assertEquals(tmp.getBase(),13);
	  tmp=cus.crop(5);
	  assertEquals(tmp.getBase(),5);
	}
	@Test
	public void testConcat(){
		Alphabet tmp=null;
		try{
			tmp=bin.concat("z");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		assertEquals(tmp.getBase(),3);
		try{
			bin.concat(tmp);
			assertTrue(false);
		}catch(Exception e){
			assertTrue(true);
		}
	}
	@Test
	public void testCharAt(){
		assertEquals(cus.charAt(30),'u');
	}
	@Test
	public void testIndexOf(){
		assertEquals(cus.indexOf('z'),35);
	}
	@Test
	public void testGetBase() {
		assertEquals(bin.getBase(),2);
		assertEquals(ott.getBase(),8);
		assertEquals(dec.getBase(),10);
		assertEquals(hex.getBase(),16);
		assertEquals(cus.getBase(),36);
	}
	@Test
	public void testGetMax(){
		assertEquals(bin.getMax(),8);
		assertEquals(ott.getMax(),3);
		assertEquals(dec.getMax(),3);
		assertEquals(hex.getMax(),2);
		assertEquals(cus.getMax(),2);
	}
}
