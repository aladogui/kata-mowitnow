package com.hito.soc.gen.mowitnow;

public enum Instruction {

  G("Left"),
  D("Right"),
  A("Advance");

  private String label;

  Instruction(final String label) {
    this.label = label;
  }
}
