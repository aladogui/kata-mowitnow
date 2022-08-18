package com.hito.soc.gen.mowitnow;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MowerTest {

  private final Position initPosition = Position.builder().coordinates(new Coordinates(1,2)).orientation(Orientation.N).build();
  private final GardenLimit gardenLimit = new GardenLimit(5, 5);

  @Test
  void should_stop_in_right_position(){
    List<Instruction> instructions = List.of("G","A","G","A","G","A","G","A","A").stream()
        .map(Instruction::valueOf).collect(Collectors.toList());
    Mower mower = new Mower(initPosition, instructions, gardenLimit);
    mower.executeMow();
    Position expectedPosition = new Position(new String[]{"1", "3", "N"});
    Assertions.assertEquals(expectedPosition, mower.getPosition());
  }

  @Test
  void should_move_on_when_instruction_A(){
    Mower mower = new Mower(initPosition, null, gardenLimit);
    mower.executeInstruction(Instruction.A);
    Assertions.assertEquals(new Position(new String[]{"1", "3", "N"}), mower.getPosition());
  }

  @Test
  void should_change_direction_to_E_when_instruction_D(){
    Mower mower = new Mower(initPosition, null, gardenLimit);
    mower.executeInstruction(Instruction.D);
    Assertions.assertEquals(new Position(new String[]{"1", "2", "E"}), mower.getPosition());
  }

  @Test
  void should_change_direction_to_W_when_instruction_G(){
    Mower mower = new Mower(initPosition, null, gardenLimit);
    mower.executeInstruction(Instruction.G);
    Assertions.assertEquals(new Position(new String[]{"1", "2", "W"}), mower.getPosition());
  }
}