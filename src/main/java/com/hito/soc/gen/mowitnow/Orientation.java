package com.hito.soc.gen.mowitnow;

import java.util.Arrays;
import java.util.LinkedList;

public enum Orientation {
  N("NORTH"),
  E("EAST"),
  W("WEST"),
  S("SOUTH");

  private static LinkedList<Orientation> orientations = new LinkedList<>(Arrays.asList(N,E,S,W));

  Orientation(final String label) {
  }

  public Orientation turnRight(){
    Orientation orientation;
    int indexOfElement = orientations.indexOf(this);
    if (indexOfElement==orientations.size()-1){
      orientation= orientations.getFirst();
    }else
      orientation= orientations.get(indexOfElement+1);
    return orientation;
  }

  public Orientation turnLeft(){
    Orientation orientation;
    int indexOfElement = orientations.indexOf(this);
    if (indexOfElement==0){
      orientation= orientations.getLast();
    }else
      orientation= orientations.get(indexOfElement-1);
    return orientation;
  }




}
