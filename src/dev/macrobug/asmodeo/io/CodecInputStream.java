package dev.macrobug.asmodeo.io;

import java.io.IOException;
import java.io.InputStream;
import dev.macrobug.asmodeo.core.IntegerCoder;

public class CodecInputStream extends InputStream{

  private IntegerCoder coder;
  private InputStream in;
  public CodecInputStream(InputStream in,String s) {
    coder=new IntegerCoder(s);
    this.in=in;
  }
  public int read() throws IOException {
    int t=in.read();
    if(t<0)
      return t;
    return coder.decode(""+((char)t));
  }
}
