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
public class IntegerCoderTest {
  private IntegerCoder bin, ott, dec, hex, cus;
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    bin=new IntegerCoder(new Alphabet("01"));
    ott=new IntegerCoder("01234567");
    dec=new IntegerCoder(new Alphabet("0123456789abcdef"),10);
    hex=new IntegerCoder(new Alphabet("0123456789abcdef"));
    cus=new IntegerCoder("0123456789abcdefghijklmnopqrstuvwxyz");
  }

  /**
   * Test method for {@link dev.macrobug.asmodeo.core.IntegerCoder#encode(java.lang.Integer)}.
   */
  @Test
  public void testEncodeInteger() {
    assertEquals(bin.encode(290983),"1000111000010100111");
    assertEquals(ott.encode(290983),"1070247");
    assertEquals(dec.encode(290983),"290983");
    assertEquals(hex.encode(290983),"470a7");
    assertEquals(cus.encode(37),"11");
  }

  /**
   * Test method for {@link dev.macrobug.asmodeo.core.IntegerCoder#decode(java.lang.String)}.
   */
  @Test
  public void testDecodeString() {
    assertEquals((int)bin.decode("101"),5);
    assertEquals((int)bin.decode("1000111000010100111"),290983);
    assertEquals((int)ott.decode("1070247"),290983);
    assertEquals((int)dec.decode("290983"),290983);
    assertEquals((int)hex.decode("470a7"),290983);
    assertEquals((int)cus.decode("11"),37);
  }

}
