package com.hito.soc.gen.mowitnow;

public class Coordinates {

  private int x;
  private int y;

  public Coordinates() {
    this.x = 0;
    this.y = 0;
  }

  public Coordinates(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(final int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(final int y) {
    this.y = y;
  }
}
