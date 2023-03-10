package com.innowise.ConcurrentSorters;

import com.innowise.Balls.BallInterface;
import com.innowise.Exceptions.EmptyArrayException;
import com.innowise.Sorters.Sortable;

public class ConcurrentMergeSorter implements Sortable {

  public BallInterface[] sortByColor(BallInterface[] balls) {
    switch (balls.length) {
      case 1 -> {
        return balls;
      }
      case 2 -> {
        if (balls[0].getColor().ordinal() > balls[1].getColor().ordinal()) {
          BallInterface swapBall = balls[0];
          balls[0] = balls[1];
          balls[1] = swapBall;
        }
        return balls;
      }
      default -> {
        BallInterface[] leftHalfArray;
        BallInterface[] rightHalfArray;
        int sizeOfRightArray = balls.length / 2;
        rightHalfArray = new BallInterface[sizeOfRightArray];
        int sizeOfLeftArray = balls.length % 2 == 0 ? sizeOfRightArray : sizeOfRightArray + 1;
        leftHalfArray = new BallInterface[sizeOfLeftArray];
        sizeOfRightArray = 0;
        for (int i = 0; i < balls.length; i++) {
          if (i < sizeOfLeftArray) {
            leftHalfArray[i] = balls[i];
          } else {
            rightHalfArray[sizeOfRightArray] = balls[i];
            sizeOfRightArray++;
          }
        }
        try {
          Thread leftSorterThread = new Thread(() -> sortByColor(rightHalfArray));
          Thread rightSorterThread = new Thread(() -> sortByColor(leftHalfArray));
          leftSorterThread.start();
          rightSorterThread.start();
          leftSorterThread.join();
          rightSorterThread.join();
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        }
        int leftInd = 0, rightInd = 0;
        for (int i = 0; i < balls.length; i++) {
          if (leftInd >= leftHalfArray.length) {
            while (rightInd < rightHalfArray.length) {
              balls[i] = rightHalfArray[rightInd];
              i++;
              rightInd++;
            }
            break;
          } else if (rightInd >= rightHalfArray.length) {
            while (leftInd < leftHalfArray.length) {
              balls[i] = leftHalfArray[leftInd];
              i++;
              leftInd++;
            }
            break;
          }
          if (leftHalfArray[leftInd].getColor().ordinal() < rightHalfArray[rightInd].getColor()
              .ordinal()) {
            balls[i] = leftHalfArray[leftInd];
            leftInd++;
          } else {
            balls[i] = rightHalfArray[rightInd];
            rightInd++;
          }
        }
        return balls;
      }
    }
  }

  public BallInterface[] sortByDiameter(BallInterface[] balls) {
    switch (balls.length) {
      case 1 -> {
        return balls;
      }
      case 2 -> {
        if (balls[0].getDiameter() > balls[1].getDiameter()) {
          BallInterface swapBall = balls[0];
          balls[0] = balls[1];
          balls[1] = swapBall;
        }
        return balls;
      }
      default -> {
        BallInterface[] leftHalfArray;
        BallInterface[] rightHalfArray;
        int sizeOfRightArray = balls.length / 2;
        rightHalfArray = new BallInterface[sizeOfRightArray];
        int sizeOfLeftArray = balls.length % 2 == 0 ? sizeOfRightArray : sizeOfRightArray + 1;
        leftHalfArray = new BallInterface[sizeOfLeftArray];
        sizeOfRightArray = 0;
        for (int i = 0; i < balls.length; i++) {
          if (i < sizeOfLeftArray) {
            leftHalfArray[i] = balls[i];
          } else {
            rightHalfArray[sizeOfRightArray] = balls[i];
            sizeOfRightArray++;
          }
        }
        try {
          Thread leftSorterThread = new Thread(() -> sortByDiameter(rightHalfArray));
          Thread rightSorterThread = new Thread(() -> sortByDiameter(leftHalfArray));
          leftSorterThread.start();
          rightSorterThread.start();
          leftSorterThread.join();
          rightSorterThread.join();
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        }
        int leftInd = 0, rightInd = 0;
        for (int i = 0; i < balls.length; i++) {
          if (leftInd >= leftHalfArray.length) {
            while (rightInd < rightHalfArray.length) {
              balls[i] = rightHalfArray[rightInd];
              i++;
              rightInd++;
            }
            break;
          } else if (rightInd >= rightHalfArray.length) {
            while (leftInd < leftHalfArray.length) {
              balls[i] = leftHalfArray[leftInd];
              i++;
              leftInd++;
            }
            break;
          }
          if (leftHalfArray[leftInd].getDiameter() < rightHalfArray[rightInd].getDiameter()) {
            balls[i] = leftHalfArray[leftInd];
            leftInd++;
          } else {
            balls[i] = rightHalfArray[rightInd];
            rightInd++;
          }
        }
        return balls;
      }
    }
  }

  public BallInterface[] sortByWeight(BallInterface[] balls) {
    switch (balls.length) {
      case 1 -> {
        return balls;
      }
      case 2 -> {
        if (balls[0].getWeight() > balls[1].getWeight()) {
          BallInterface swapBall = balls[0];
          balls[0] = balls[1];
          balls[1] = swapBall;
        }
        return balls;
      }
      default -> {
        BallInterface[] leftHalfArray;
        BallInterface[] rightHalfArray;
        int sizeOfRightArray = balls.length / 2;
        rightHalfArray = new BallInterface[sizeOfRightArray];
        int sizeOfLeftArray = balls.length % 2 == 0 ? sizeOfRightArray : sizeOfRightArray + 1;
        leftHalfArray = new BallInterface[sizeOfLeftArray];
        sizeOfRightArray = 0;
        for (int i = 0; i < balls.length; i++) {
          if (i < sizeOfLeftArray) {
            leftHalfArray[i] = balls[i];
          } else {
            rightHalfArray[sizeOfRightArray] = balls[i];
            sizeOfRightArray++;
          }
        }
        try {
          Thread leftSorterThread = new Thread(() -> sortByWeight(rightHalfArray));
          Thread rightSorterThread = new Thread(() -> sortByWeight(leftHalfArray));
          leftSorterThread.start();
          rightSorterThread.start();
          leftSorterThread.join();
          rightSorterThread.join();
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        }
        int leftInd = 0, rightInd = 0;
        for (int i = 0; i < balls.length; i++) {
          if (leftInd >= leftHalfArray.length) {
            while (rightInd < rightHalfArray.length) {
              balls[i] = rightHalfArray[rightInd];
              i++;
              rightInd++;
            }
            break;
          } else if (rightInd >= rightHalfArray.length) {
            while (leftInd < leftHalfArray.length) {
              balls[i] = leftHalfArray[leftInd];
              i++;
              leftInd++;
            }
            break;
          }
          if (leftHalfArray[leftInd].getWeight() < rightHalfArray[rightInd].getWeight()) {
            balls[i] = leftHalfArray[leftInd];
            leftInd++;
          } else {
            balls[i] = rightHalfArray[rightInd];
            rightInd++;
          }
        }
        return balls;
      }
    }
  }

  @Override
  public BallInterface[] sort(BallInterface[] balls, int sortTypeIndex) throws EmptyArrayException {
    if (balls == null) {
      throw new EmptyArrayException("Array is empty");
    }
    for (int i = 0; i < balls.length; i++) {
      if (balls[i] == null) {
        String exception = String.format("Element %d is null", i);
        throw new EmptyArrayException(exception);
      }
    }
    BallInterface[] resultArray = new BallInterface[balls.length];
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
