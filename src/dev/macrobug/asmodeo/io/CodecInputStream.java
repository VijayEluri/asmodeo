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
  	StringBuilder st=new StringBuilder();
  	int t;
  	for(int i=0;i<coder.getMax();i++){
  		if((t=in.read())<0)
        return t;
  		st.append((char)t);
  	}
    return coder.decode(st.toString());
  }
}
