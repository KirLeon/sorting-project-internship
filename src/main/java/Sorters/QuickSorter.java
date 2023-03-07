package Sorters;

import Balls.Ball;

public class QuickSorter implements Sorter {

  public void sortByColor(Ball[] balls, int begin, int end) {
    if (balls.length == 0 || (begin >= end)) {
      return;
    }
    int point = (end - begin) / 2 + begin;
    point = balls[point].getColor().ordinal();
    int min = begin;
    int max = end;
    while (min <= max) {
      while (balls[min].getColor().ordinal() < point) {
        min++;
      }
      while (balls[max].getColor().ordinal() > point) {
        max--;
      }
      if (min <= max) {
        Ball swap = balls[min];
        balls[min] = balls[max];
        balls[max] = swap;
        min++;
        max--;
      }
    }
    if (begin < max) {
      sortByColor(balls, begin, max);
    }
    if (end > min) {
      sortByColor(balls, min, end);
    }
  }

  public void sortByDiameter(Ball[] balls, int begin, int end) {
    if (balls.length == 0 || (begin >= end)) {
      return;
    }
    double point = (end - begin) / 2 + begin;
    point = balls[(int) point].getDiameter();
    int min = begin;
    int max = end;
    while (min <= max) {
      while (balls[min].getDiameter() < point) {
        min++;
      }
      while (balls[max].getDiameter() > point) {
        max--;
      }
      if (min <= max) {
        Ball swap = balls[min];
        balls[min] = balls[max];
        balls[max] = swap;
        min++;
        max--;
      }
    }
    if (begin < max) {
      sortByDiameter(balls, begin, max);
    }
    if (end > min) {
      sortByDiameter(balls, min, end);
    }
  }

  public void sortByWeight(Ball[] balls, int begin, int end) {
    if (balls.length == 0 || (begin >= end)) {
      return;
    }
    double point = (end - begin) / 2 + begin;
    point = balls[(int) point].getWeight();
    int min = begin;
    int max = end;
    while (min <= max) {
      while (balls[min].getWeight() < point) {
        min++;
      }
      while (balls[max].getWeight() > point) {
        max--;
      }
      if (min <= max) {
        Ball swap = balls[min];
        balls[min] = balls[max];
        balls[max] = swap;
        min++;
        max--;
      }
    }
    if (begin < max) {
      sortByWeight(balls, begin, max);
    }
    if (end > min) {
      sortByWeight(balls, min, end);
    }
  }

  @Override
  public Ball[] sort(Ball[] balls, int k) {
    Ball[] resultArray = new Ball[balls.length];
    int begin = 0;
    int end = balls.length - 1;
    switch (Math.abs(k)) {
      case 1:
        sortByColor(balls, begin, end);
        break;
      case 2:
        sortByDiameter(balls, begin, end);
        break;
      case 3:
        sortByWeight(balls, begin, end);
        break;
    }
    if (k < 0) {
      int index = 0;
      for (int i = balls.length - 1; i >= 0; i--) {
        resultArray[index] = balls[i];
        index++;
      }
      return resultArray;
    } else {
      return balls;
    }
  }
}
