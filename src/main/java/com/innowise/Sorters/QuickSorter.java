package com.innowise.Sorters;

import com.innowise.Balls.Ball;
import com.innowise.Exceptions.EmptyArrayException;

public class QuickSorter implements Sortable {

  public void sortByColor(Ball[] balls, int begin, int end) {
    if (balls.length == 0 || (begin >= end)) {
      return;
    }
    int point = (end - begin) / 2 + begin;
    point = balls[point].getColor().ordinal();
    int firstElementToSort = begin;
    int LastElementToSort = end;
    while (firstElementToSort <= LastElementToSort) {
      while (balls[firstElementToSort].getColor().ordinal() < point) {
        firstElementToSort++;
      }
      while (balls[LastElementToSort].getColor().ordinal() > point) {
        LastElementToSort--;
      }
      if (firstElementToSort <= LastElementToSort) {
        Ball swap = balls[firstElementToSort];
        balls[firstElementToSort] = balls[LastElementToSort];
        balls[LastElementToSort] = swap;
        firstElementToSort++;
        LastElementToSort--;
      }
    }
    if (begin < LastElementToSort) {
      sortByColor(balls, begin, LastElementToSort);
    }
    if (end > firstElementToSort) {
      sortByColor(balls, firstElementToSort, end);
    }
  }

  public void sortByDiameter(Ball[] balls, int begin, int end) {
    if (balls.length == 0 || (begin >= end)) {
      return;
    }
    double point = (end - begin) / 2 + begin;
    point = balls[(int) point].getDiameter();
    int firstElementToSort = begin;
    int LastElementToSort = end;
    while (firstElementToSort <= LastElementToSort) {
      while (balls[firstElementToSort].getDiameter() < point) {
        firstElementToSort++;
      }
      while (balls[LastElementToSort].getDiameter() > point) {
        LastElementToSort--;
      }
      if (firstElementToSort <= LastElementToSort) {
        Ball swap = balls[firstElementToSort];
        balls[firstElementToSort] = balls[LastElementToSort];
        balls[LastElementToSort] = swap;
        firstElementToSort++;
        LastElementToSort--;
      }
    }
    if (begin < LastElementToSort) {
      sortByDiameter(balls, begin, LastElementToSort);
    }
    if (end > firstElementToSort) {
      sortByDiameter(balls, firstElementToSort, end);
    }
  }

  public void sortByWeight(Ball[] balls, int begin, int end) {
    if (balls.length == 0 || (begin >= end)) {
      return;
    }
    double point = (end - begin) / 2 + begin;
    point = balls[(int) point].getWeight();
    int firstElementToSort = begin;
    int LastElementToSort = end;
    while (firstElementToSort <= LastElementToSort) {
      while (balls[firstElementToSort].getWeight() < point) {
        firstElementToSort++;
      }
      while (balls[LastElementToSort].getWeight() > point) {
        LastElementToSort--;
      }
      if (firstElementToSort <= LastElementToSort) {
        Ball swap = balls[firstElementToSort];
        balls[firstElementToSort] = balls[LastElementToSort];
        balls[LastElementToSort] = swap;
        firstElementToSort++;
        LastElementToSort--;
      }
    }
    if (begin < LastElementToSort) {
      sortByWeight(balls, begin, LastElementToSort);
    }
    if (end > firstElementToSort) {
      sortByWeight(balls, firstElementToSort, end);
    }
  }

  @Override
  public Ball[] sort(Ball[] balls, int sortTypeIndex) throws EmptyArrayException {
    if (balls == null) {
      throw new EmptyArrayException("Array is empty");
    }
    for (int i = 0; i < balls.length; i++) {
      if (balls[i] == null) {
        String exception = String.format("Element %d is null", i);
        throw new EmptyArrayException(exception);
      }
    }
    Ball[] resultArray = new Ball[balls.length];
    int begin = 0;
    int end = balls.length - 1;
    switch (Math.abs(sortTypeIndex)) {
      case 1 -> sortByColor(balls, begin, end);
      case 2 -> sortByDiameter(balls, begin, end);
      case 3 -> sortByWeight(balls, begin, end);
    }
    if (sortTypeIndex < 0) {
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
