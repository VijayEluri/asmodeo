package dev.macrobug.asmodeo.core.interfaces;

public interface Code {
  int getBase();
  int getMax();
  boolean isValid(String s);
}
