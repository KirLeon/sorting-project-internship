package com.innowise.ConcurrentSorters;

import com.innowise.Balls.Ball;
import com.innowise.Exceptions.EmptyArrayException;
import com.innowise.Sorters.Sortable;

public class ConcurrentMergeSorter implements Sortable {

  public Ball[] sortByColor(Ball[] balls) {
    switch (balls.length) {
      case 1 -> {
        return balls;
      }
      case 2 -> {
        if (balls[0].getColor().ordinal() > balls[1].getColor().ordinal()) {
          Ball swapBall = balls[0];
          balls[0] = balls[1];
          balls[1] = swapBall;
        }
        return balls;
      }
      default -> {
        Ball[] leftHalfArray;
        Ball[] rightHalfArray;
        int sizeOfRightArray = balls.length / 2;
        rightHalfArray = new Ball[sizeOfRightArray];
        int sizeOfLeftArray = balls.length % 2 == 0 ? sizeOfRightArray : sizeOfRightArray + 1;
        leftHalfArray = new Ball[sizeOfLeftArray];
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
          Thread leftSorterThread = new Thread(new Runnable() {
            @Override
            public void run() {
              sortByColor(rightHalfArray);
            }
          });
          Thread rightSorterThread = new Thread(new Runnable() {
            @Override
            public void run() {
              sortByColor(leftHalfArray);
            }
          });
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

  public Ball[] sortByDiameter(Ball[] balls) {
    switch (balls.length) {
      case 1 -> {
        return balls;
      }
      case 2 -> {
        if (balls[0].getDiameter() > balls[1].getDiameter()) {
          Ball swapBall = balls[0];
          balls[0] = balls[1];
          balls[1] = swapBall;
        }
        return balls;
      }
      default -> {
        Ball[] leftHalfArray;
        Ball[] rightHalfArray;
        int sizeOfRightArray = balls.length / 2;
        rightHalfArray = new Ball[sizeOfRightArray];
        int sizeOfLeftArray = balls.length % 2 == 0 ? sizeOfRightArray : sizeOfRightArray + 1;
        leftHalfArray = new Ball[sizeOfLeftArray];
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
          Thread leftSorterThread = new Thread(new Runnable() {
            @Override
            public void run() {
              sortByDiameter(rightHalfArray);
            }
          });
          Thread rightSorterThread = new Thread(new Runnable() {
            @Override
            public void run() {
              sortByDiameter(leftHalfArray);
            }
          });
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

  public Ball[] sortByWeight(Ball[] balls) {
    switch (balls.length) {
      case 1 -> {
        return balls;
      }
      case 2 -> {
        if (balls[0].getWeight() > balls[1].getWeight()) {
          Ball swapBall = balls[0];
          balls[0] = balls[1];
          balls[1] = swapBall;
        }
        return balls;
      }
      default -> {
        Ball[] leftHalfArray;
        Ball[] rightHalfArray;
        int sizeOfRightArray = balls.length / 2;
        rightHalfArray = new Ball[sizeOfRightArray];
        int sizeOfLeftArray = balls.length % 2 == 0 ? sizeOfRightArray : sizeOfRightArray + 1;
        leftHalfArray = new Ball[sizeOfLeftArray];
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
          Thread leftSorterThread = new Thread(new Runnable() {
            @Override
            public void run() {
              sortByWeight(rightHalfArray);
            }
          });
          Thread rightSorterThread = new Thread(new Runnable() {
            @Override
            public void run() {
              sortByWeight(leftHalfArray);
            }
          });
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
