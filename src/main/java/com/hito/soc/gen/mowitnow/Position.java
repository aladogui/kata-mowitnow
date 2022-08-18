package com.hito.soc.gen.mowitnow;

import com.hito.soc.gen.exceptions.InvalidParamsException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
@AllArgsConstructor
public class Position {

  private Coordinates coordinates;
  private Orientation orientation;

  public Position(String[] args)  {
    if(args.length!= 3){
      log.error("Invalid position parameters");
      throw new InvalidParamsException("Invalid position parameters");
    }
    this.coordinates = new Coordinates(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    this.orientation = Orientation.valueOf(args[2]);
  }

  public void move(Coordinates limit){
    switch (this.orientation){
      case E: if(coordinates.getX() < limit.getX()) coordinates.moveRight(); break;
      case N: if(coordinates.getY() < limit.getY()) coordinates.moveUp(); break;
      case S: if(coordinates.getY() > 0) coordinates.moveDown(); break;
      case W: if(coordinates.getX() > 0) coordinates.moveLeft(); break;
    }
  }

  @Override
  public String toString() {
    return coordinates.toString()+ " "+ orientation.toString();
  }
}
