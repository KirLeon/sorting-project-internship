package com.innowise.Balls;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ball implements BallInterface {

  private double weight;
  private double diameter;
  private Colors color;

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = Ball.this.weight;
  }

  public double getDiameter() {
    return diameter;
  }

  public void setDiameter(double diameter) {
    this.diameter = diameter;
  }

  public Colors getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = Colors.valueOf(color);
  }

}
