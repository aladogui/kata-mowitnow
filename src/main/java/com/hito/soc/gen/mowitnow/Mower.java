package com.hito.soc.gen.mowitnow;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Mower {

  private Position position;
  private List<Instruction> instructions;
  private GardenLimit gardenLimit;

  public Mower(final Position position, final List<Instruction> instructionList,
      final GardenLimit gardenLimit) {

    this.position = position;
    this.instructions= instructionList;
    this.gardenLimit= gardenLimit;

  }

  public List<Instruction> getInstructions() {
    if(instructions == null){
      instructions = new ArrayList<>();
    }
    return instructions;
  }

  public void executeMow() {
    for(Instruction inst: instructions){
      executeInstruction(inst);
    }
  }

  public void executeInstruction(final Instruction inst) {
    switch (inst){
      case A: position.move(gardenLimit.getLimitCoordinates()); break;
      case G: position.setOrientation(position.getOrientation().turnLeft()); break;
      case D: position.setOrientation(position.getOrientation().turnRight()); break;
    }
  }

}
