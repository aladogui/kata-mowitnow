package com.hito.soc.gen.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinatesTest {

  Coordinates coordinates = new Coordinates();

  @Test
  void should_descend_when_move_down() {
    coordinates.moveDown();
    Assertions.assertEquals("0 -1", coordinates.toString());
  }

  @Test
  void should_ascend_when_move_up() {
    coordinates.moveUp();
    Assertions.assertEquals("0 1", coordinates.toString());
  }

  @Test
  void should_ahead_when_move_right() {
    coordinates.moveRight();
    Assertions.assertEquals("1 0", coordinates.toString());
  }

  @Test
  void should_go_back_when_move_left() {
    coordinates.moveLeft();
    Assertions.assertEquals("-1 0", coordinates.toString());
  }

}