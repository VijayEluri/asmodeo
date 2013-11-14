package dev.macrobug.asmodeo.io;

import java.io.IOException;
import java.io.OutputStream;

import dev.macrobug.asmodeo.core.StringCoder;

public class CodecOutputStream extends OutputStream{

  private OutputStream out;
  private StringCoder coder;
  public CodecOutputStream(OutputStream out,String code) {
    this.coder=new StringCoder(code);
    this.out=out;
  }
  public void write(int c) throws IOException {
  	StringBuilder t=new StringBuilder();
    String s=coder.encode(t.append((char)c).toString());
    for(Byte b:s.getBytes())
      out.write(b);
  }
}
