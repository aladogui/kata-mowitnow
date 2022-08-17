package com.hito.soc.gen.mowitnow;

import java.util.List;

public class Mower {

  private Position position;
  private List<Instruction> instructions;
  private GardenLimit gardenLimit;

  public Position getPosition() {
    return position;
  }

  public void setPosition(final Position position) {
    this.position = position;
  }

  public List<Instruction> getInstructions() {
    return instructions;
  }

  public void setInstructions(final List<Instruction> instructions) {
    this.instructions = instructions;
  }

  public GardenLimit getGardenLimit() {
    return gardenLimit;
  }

  public void setGardenLimit(final GardenLimit gardenLimit) {
    this.gardenLimit = gardenLimit;
  }
}
