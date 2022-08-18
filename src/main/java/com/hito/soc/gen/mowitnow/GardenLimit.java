package com.hito.soc.gen.mowitnow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GardenLimit {

  private Coordinates limitCoordinates;

  public GardenLimit(int x , int y) {
    limitCoordinates = new Coordinates(x,y);
  }

  public GardenLimit(String x, String y) {
    try {
      int xLimit= Integer.parseInt(x);
      int yLimit = Integer.parseInt(y);
      this.limitCoordinates = new Coordinates(xLimit, yLimit);
    }catch(NumberFormatException ne){
      log.error("Cannot parse garden limit coordinates parameters");
      throw ne;
    }
  }

  public Coordinates getLimitCoordinates() {
    return limitCoordinates;
  }

  public void setLimitCoordinates(final Coordinates limitCoordinates) {
    this.limitCoordinates = limitCoordinates;
  }
}
