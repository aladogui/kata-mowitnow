package com.hito.soc.gen.mowitnow;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {


  static Position position;

  private final Coordinates limitGarden = new Coordinates(3,3);
  Coordinates initialCoordinates = new Coordinates(2,2);

  @Test
  void should_move_up_when_orientation_north(){
    position = new Position(initialCoordinates, Orientation.N);
    Position expectedPosition = new Position(new Coordinates(2,3), Orientation.N);
    position.move(limitGarden);
    Assertions.assertEquals(expectedPosition, position);
  }

  @Test
  void should_move_down_when_orientation_south(){
    position = new Position(initialCoordinates, Orientation.S);
    Position expectedPosition = new Position(new Coordinates(2,1), Orientation.S);
    position.move(limitGarden);
    Assertions.assertEquals( expectedPosition, position);
  }
  @Test
  void should_move_right_when_orientation_east(){
    position = new Position(initialCoordinates, Orientation.E);
    Position expectedPosition = new Position(new Coordinates(3,2), Orientation.E);
    position.move(limitGarden);
    Assertions.assertEquals(expectedPosition, position);
  }
  @Test
  void should_move_left_when_orientation_west(){
    position = new Position(initialCoordinates, Orientation.W);
    Position expectedPosition = new Position(new Coordinates(1,2), Orientation.W);
    position.move(limitGarden);
    Assertions.assertEquals(expectedPosition, position);
  }

  @Test
  void should_not_move_when_limit_garden_achieved(){
    // When
    Coordinates limitGarden = new Coordinates(2,2);
    //Then
    position = new Position(initialCoordinates, Orientation.E);
    Position expectedPosition = new Position(new Coordinates(2,2), Orientation.E);
    position.move(limitGarden);
    Assertions.assertEquals(expectedPosition, position);
  }

}