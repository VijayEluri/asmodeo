package dev.macrobug.asmodeo.io;

import java.io.*;
import dev.macrobug.asmodeo.core.IntegerCoder;

public class CodecOutputStream extends OutputStream{

  private OutputStream out;
  private IntegerCoder coder;
  public CodecOutputStream(OutputStream out,String code) {
    this.coder=new IntegerCoder(code);
    this.out=out;
  }
  public void write(int c) throws IOException {
    String s=coder.encode(c);
    for(Byte b:s.getBytes())
      out.write(b);
  }
}
