package com.innowise.ConcurrentSorters;

import com.innowise.Balls.Ball;
import com.innowise.Exceptions.EmptyArrayException;
import com.innowise.Sorters.Sortable;

public class ConcurrentEvenOddSorter implements Sortable {

  public Ball[] sortByColor(Ball[] balls) {
    final boolean[] isSorted = {false};
    //Using final one-element array to access variable within inner class
    Thread threadSorterOdd;
    Thread threadSorterEven;
    while (isSorted[0] == false) {
      isSorted[0] = true;
      threadSorterOdd = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < balls.length - 1; i += 2) {
            if (balls[i].getColor().ordinal() > balls[i + 1].getColor().ordinal()) {
              isSorted[0] = false;
              Ball swapBall = balls[i];
              balls[i] = balls[i + 1];
              balls[i + 1] = swapBall;
            }
          }
        }
      });
      threadSorterEven = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 1; i < balls.length - 1; i += 2) {
            if (balls[i].getColor().ordinal() > balls[i + 1].getColor().ordinal()) {
              isSorted[0] = false;
              Ball swapBall = balls[i];
              balls[i] = balls[i + 1];
              balls[i + 1] = swapBall;
            }
          }
        }
      });
      try {
        threadSorterOdd.start();
        threadSorterEven.start();
        threadSorterOdd.join();
        threadSorterEven.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    return balls;
  }

  public Ball[] sortByDiameter(Ball[] balls) {
    final boolean[] isSorted = {false};
    //Using final one-element array to access variable within inner class
    Thread threadSorterOdd;
    Thread threadSorterEven;
    while (isSorted[0] == false) {
      isSorted[0] = true;
      threadSorterOdd = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < balls.length - 1; i += 2) {
            if (balls[i].getDiameter() > balls[i + 1].getDiameter()) {
              isSorted[0] = false;
              Ball swapBall = balls[i];
              balls[i] = balls[i + 1];
              balls[i + 1] = swapBall;
            }
          }
        }
      });
      threadSorterEven = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 1; i < balls.length - 1; i += 2) {
            if (balls[i].getDiameter() > balls[i + 1].getDiameter()) {
              isSorted[0] = false;
              Ball swapBall = balls[i];
              balls[i] = balls[i + 1];
              balls[i + 1] = swapBall;
            }
          }
        }
      });
      try {
        threadSorterOdd.start();
        threadSorterEven.start();
        threadSorterOdd.join();
        threadSorterEven.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    return balls;
  }

  public Ball[] sortByWeight(Ball[] balls) {
    final boolean[] isSorted = {false};
    //Using final one-element array to access variable within inner class
    Thread threadSorterOdd;
    Thread threadSorterEven;
    while (isSorted[0] == false) {
      isSorted[0] = true;
      threadSorterOdd = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < balls.length - 1; i += 2) {
            if (balls[i].getWeight() > balls[i + 1].getWeight()) {
              isSorted[0] = false;
              Ball swapBall = balls[i];
              balls[i] = balls[i + 1];
              balls[i + 1] = swapBall;
            }
          }
        }
      });
      threadSorterEven = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 1; i < balls.length - 1; i += 2) {
            if (balls[i].getWeight() > balls[i + 1].getWeight()) {
              isSorted[0] = false;
              Ball swapBall = balls[i];
              balls[i] = balls[i + 1];
              balls[i + 1] = swapBall;
            }
          }
        }
      });
      try {
        threadSorterOdd.start();
        threadSorterEven.start();
        threadSorterOdd.join();
        threadSorterEven.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    return balls;
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
    switch (Math.abs(sortTypeIndex)) {
      case 1 -> sortByColor(balls);
      case 2 -> sortByDiameter(balls);
      case 3 -> sortByWeight(balls);
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
