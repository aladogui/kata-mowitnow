package com.hito.soc.gen.mowitnow;

import java.util.Arrays;
import java.util.LinkedList;

public enum Orientation {
  N("NORTH"),
  E("EST"),
  W("WEST"),
  S("SOUTH");

  private static LinkedList<Orientation> orientations = new LinkedList<>(Arrays.asList(N,E,S,W));

  Orientation(final String label) {
  }

  public Orientation turnRight(){
    return null;
  }

  public Orientation turnLeft(){
    return null;
  }




}
