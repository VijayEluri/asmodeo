/**
 * 
 */
package dev.macrobug.asmodeo.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author dices
 *
 */
public class StringCoderTest {
	private StringCoder bin, ott, dec, hex, cus;
	private StringCoder binp, ottp, decp, hexp, cusp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bin=new StringCoder(new Alphabet("01"));
		ott=new StringCoder("01234567");
		dec=new StringCoder(new Alphabet("0123456789abcdef"),10);
		hex=new StringCoder(new Alphabet("0123456789abcdef"));
		cus=new StringCoder("0123456789abcdefghijklmnopqrstuvwxyz");
		binp=new StringCoder(new Alphabet("01"),'|');
		ottp=new StringCoder("01234567",'|');
		decp=new StringCoder(new Alphabet("0123456789"),'|');
		hexp=new StringCoder(new Alphabet("0123456789abcdef"),'|');
		cusp=new StringCoder("0123456789abcdefghijklmnopqrstuvwxyz",'|');
	}

	/**
	 * Test method for {@link dev.macrobug.asmodeo.core.IntegerCoder#encode(java.lang.Integer)}.
	 */
	@Test
	public void testEncodeInteger() {
		assertEquals(bin.encode(" "),"00100000");
		assertEquals(binp.encode(" "),"100000");
		assertEquals(bin.encode("Aa"),"0100000101100001");
		assertEquals(binp.encode("Aa"),"1000001|1100001");
		
		assertEquals(ott.encode(" "),"040");
		assertEquals(ottp.encode(" "),"40");
		assertEquals(ott.encode("Aa"),"101141");
		assertEquals(ottp.encode("Aa"),"101|141");
		
		assertEquals(dec.encode(" "),"032");
		assertEquals(decp.encode(" "),"32");
		assertEquals(dec.encode("Aa"),"065097");
		assertEquals(decp.encode("Aa"),"65|97");
		
		assertEquals(hex.encode("\n"),"0a");
		assertEquals(hexp.encode("\n"),"a");
		assertEquals(hex.encode("Aa"),"4161");
		assertEquals(hexp.encode("Aa"),"41|61");
		
		assertEquals(cus.encode(" "),"0w");
		assertEquals(cusp.encode(" "),"w");
		assertEquals(cus.encode("Aa"),"1t2p");
		assertEquals(cusp.encode("Aa"),"1t|2p");
		
	}

	/**
	 * Test method for {@link dev.macrobug.asmodeo.core.IntegerCoder#decode(java.lang.String)}.
	 */
	@Test
	public void testDecodeString() {
		assertEquals(bin.decode("00100000")," ");
		assertEquals(binp.decode("100000")," ");
		assertEquals(bin.decode("0100000101100001"),"Aa");
		assertEquals(binp.decode("|1000001|1100001|"),"Aa");
		assertEquals(ott.decode("040")," ");
		assertEquals(ottp.decode("40")," ");
		assertEquals(ott.decode("101141"),"Aa");
		assertEquals(ottp.decode("|101|141|"),"Aa");
		assertEquals(dec.decode("032")," ");
		assertEquals(decp.decode("32")," ");
		assertEquals(dec.decode("065097"),"Aa");
		assertEquals(decp.decode("|65|97|"),"Aa");
		assertEquals(hex.decode("0a"),"\n");
		assertEquals(hexp.decode("a"),"\n");
		assertEquals(hex.decode("4161"),"Aa");
		assertEquals(hexp.decode("|41|61|"),"Aa");
		assertEquals(cus.decode("0w")," ");
		assertEquals(cusp.decode("w")," ");
		assertEquals(cus.decode("1t2p"),"Aa");
		assertEquals(cusp.decode("|1t|2p|"),"Aa");
	}

}
