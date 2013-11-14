/**
 * 
 */
package dev.macrobug.asmodeo.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author dices
 *
 */
public class CodecOutputStreamTest {
	private CodecOutputStream stream;
	private File file;
	private String lorem;
	private String result;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lorem="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis iaculis laoreet justo, sed viverra libero ornare porta. Nulla a faucibus enim. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sed diam eget quam tempus gravida non volutpat arcu. Praesent mi nibh, aliquet vitae dignissim id, gravida quis nulla. Vivamus sed dui aliquam, posuere leo in, dictum est. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec at laoreet orci. Curabitur sed auctor ipsum. Quisque pellentesque, urna et aliquet vulputate, lorem turpis gravida nisl, eu gravida justo dui nec elit.\n\nVivamus nisl quam, commodo et aliquam eget, aliquet eu leo. Fusce bibendum convallis felis vitae bibendum. Etiam at pellentesque massa, non varius eros. Etiam interdum ante at velit facilisis ornare. Nunc nec nisl vitae tellus rhoncus dignissim sed nec erat. Ut iaculis mollis leo vitae tempor. Proin facilisis aliquam dui non gravida.";
		result="4c6f72656d20697073756d20646f6c6f722073697420616d65742c20636f6e73656374657475722061646970697363696e6720656c69742e204475697320696163756c6973206c616f72656574206a7573746f2c207365642076697665727261206c696265726f206f726e61726520706f7274612e204e756c6c61206120666175636962757320656e696d2e204c6f72656d20697073756d20646f6c6f722073697420616d65742c20636f6e73656374657475722061646970697363696e6720656c69742e20457469616d20736564206469616d2065676574207175616d2074656d7075732067726176696461206e6f6e20766f6c757470617420617263752e205072616573656e74206d69206e6962682c20616c6971756574207669746165206469676e697373696d2069642c20677261766964612071756973206e756c6c612e20566976616d7573207365642064756920616c697175616d2c20706f7375657265206c656f20696e2c2064696374756d206573742e204c6f72656d20697073756d20646f6c6f722073697420616d65742c20636f6e73656374657475722061646970697363696e6720656c69742e20446f6e6563206174206c616f72656574206f7263692e204375726162697475722073656420617563746f7220697073756d2e20517569737175652070656c6c656e7465737175652c2075726e6120657420616c69717565742076756c7075746174652c206c6f72656d207475727069732067726176696461206e69736c2c2065752067726176696461206a7573746f20647569206e656320656c69742e0a0a566976616d7573206e69736c207175616d2c20636f6d6d6f646f20657420616c697175616d20656765742c20616c6971756574206575206c656f2e20467573636520626962656e64756d20636f6e76616c6c69732066656c697320766974616520626962656e64756d2e20457469616d2061742070656c6c656e746573717565206d617373612c206e6f6e207661726975732065726f732e20457469616d20696e74657264756d20616e74652061742076656c697420666163696c69736973206f726e6172652e204e756e63206e6563206e69736c2076697461652074656c6c75732072686f6e637573206469676e697373696d20736564206e656320657261742e20557420696163756c6973206d6f6c6c6973206c656f2076697461652074656d706f722e2050726f696e20666163696c6973697320616c697175616d20647569206e6f6e20677261766964612e";
		String code = "0123456789abcdef";
		file=File.createTempFile("junit", "test");
		stream=new CodecOutputStream(new FileOutputStream(file),code);
	}

	/**
	 * Test method for {@link dev.macrobug.asmodeo.io.CodecOutputStream#write(int)}.
	 */
	@Test
	public void testWrite() {
		try {
			for(byte c:lorem.getBytes()){
	      stream.write(c);
      }
			stream.flush();
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s=br.readLine();
			assertEquals(s,result);
			br.close(); 
		} catch (IOException e) {
    	fail(e.getMessage());
	    e.printStackTrace();
    }
	}

}
