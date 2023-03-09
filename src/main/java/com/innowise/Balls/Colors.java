package com.innowise.Balls;

public enum Colors {
  WHITE("White"), RED("Red"), ORANGE("Orange"), YELLOW("Yellow"),
  GREEN("Green"), CYAN("Cyan"), BLUE("Blue"), PURPLE("Purple");
  private String color;

  Colors(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return this.color;
  }
}
