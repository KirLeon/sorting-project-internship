package com.innowise.Balls;

public class BallImplementation implements Ball {

  public BallImplementation(double weight, double diameter, Colors color) {
    this.weight = weight;
    this.diameter = diameter;
    this.color = color;
  }

  private double weight;
  private double diameter;
  private Colors color;

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = BallImplementation.this.weight;
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

  @Override
  public String toString() {
    return "The ball is " + color + ", " + diameter + "in diameter and the weight is: " + weight;
  }
}
