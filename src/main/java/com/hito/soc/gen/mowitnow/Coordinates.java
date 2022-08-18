package com.hito.soc.gen.mowitnow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinates {

  private int x;
  private int y;

  public Coordinates() {
    this.x = 0;
    this.y = 0;
  }

  public void moveRight(){
    this.x++ ;
  }

  public void moveLeft(){
    this.x--;
  }

  public void moveDown(){
    this.y--;
  }

  public void moveUp(){
    this.y++;
  }

  @Override
  public String toString() {
    return x+" "+y;
  }
}
