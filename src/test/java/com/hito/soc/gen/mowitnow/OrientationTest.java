package com.hito.soc.gen.mowitnow;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class OrientationTest {

  @Test
  public void should_return_left_orientation(){
    assertSame(Orientation.N, Orientation.E.turnLeft());
    assertSame(Orientation.W, Orientation.N.turnLeft());
    assertSame(Orientation.S, Orientation.W.turnLeft());
    assertSame(Orientation.E, Orientation.S.turnLeft());
  }

  @Test
  public void should_return_right_orientation(){
    assertSame(Orientation.S, Orientation.E.turnRight());
    assertSame(Orientation.E, Orientation.N.turnRight());
    assertSame(Orientation.N, Orientation.W.turnRight());
    assertSame(Orientation.W, Orientation.S.turnRight());
  }


}