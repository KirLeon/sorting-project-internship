package Sorters;

import Balls.Ball;

public class MergeSorter implements Sorter {

  public Ball[] sortByColor(Ball[] balls) {
    switch (balls.length) {
      case 1:
        return balls;
      case 2:
        if (balls[0].getColor().ordinal() > balls[1].getColor().ordinal()) {
          Ball swapBall = balls[0];
          balls[0] = balls[1];
          balls[1] = swapBall;
        }
        return balls;
      default: {
        Ball[] leftHalf;
        Ball[] rightHalf;
        int rightSize = balls.length / 2;
        rightHalf = new Ball[rightSize];
        int leftSize = balls.length % 2 == 0 ? rightSize : rightSize + 1;
        leftHalf = new Ball[leftSize];
        rightSize = 0;
        for (int i = 0; i < balls.length; i++) {
          if (i < leftSize) {
            leftHalf[i] = balls[i];
          } else {
            rightHalf[rightSize] = balls[i];
            rightSize++;
          }
        }
        sortByColor(leftHalf);
        sortByColor(rightHalf);
        int leftInd = 0, rightInd = 0;
        for (int i = 0; i < balls.length; i++) {
          if (leftInd >= leftHalf.length) {
            while (rightInd < rightHalf.length) {
              balls[i] = rightHalf[rightInd];
              i++;
              rightInd++;
            }
            break;
          } else if (rightInd >= rightHalf.length) {
            while (leftInd < leftHalf.length) {
              balls[i] = leftHalf[leftInd];
              i++;
              leftInd++;
            }
            break;
          }
          if (leftHalf[leftInd].getColor().ordinal() <
              rightHalf[rightInd].getColor().ordinal()) {
            balls[i] = leftHalf[leftInd];
            leftInd++;
          } else {
            balls[i] = rightHalf[rightInd];
            rightInd++;
          }
        }
        return balls;
      }
    }
  }

  public Ball[] sortByDiameter(Ball[] balls) {
    switch (balls.length) {
      case 1:
        return balls;
      case 2:
        if (balls[0].getDiameter() > balls[1].getDiameter()) {
          Ball swapBall = balls[0];
          balls[0] = balls[1];
          balls[1] = swapBall;
        }
        return balls;
      default: {
        Ball[] leftHalf;
        Ball[] rightHalf;
        int rightSize = balls.length / 2;
        rightHalf = new Ball[rightSize];
        int leftSize = balls.length % 2 == 0 ? rightSize : rightSize + 1;
        leftHalf = new Ball[leftSize];
        rightSize = 0;
        for (int i = 0; i < balls.length; i++) {
          if (i < leftSize) {
            leftHalf[i] = balls[i];
          } else {
            rightHalf[rightSize] = balls[i];
            rightSize++;
          }
        }
        sortByDiameter(leftHalf);
        sortByDiameter(rightHalf);
        int leftInd = 0, rightInd = 0;
        for (int i = 0; i < balls.length; i++) {
          if (leftInd >= leftHalf.length) {
            while (rightInd < rightHalf.length) {
              balls[i] = rightHalf[rightInd];
              i++;
              rightInd++;
            }
            break;
          } else if (rightInd >= rightHalf.length) {
            while (leftInd < leftHalf.length) {
              balls[i] = leftHalf[leftInd];
              i++;
              leftInd++;
            }
            break;
          }
          if (leftHalf[leftInd].getDiameter() <
              rightHalf[rightInd].getDiameter()) {
            balls[i] = leftHalf[leftInd];
            leftInd++;
          } else {
            balls[i] = rightHalf[rightInd];
            rightInd++;
          }
        }
        return balls;
      }
    }
  }

  public Ball[] sortByWeight(Ball[] balls) {
    switch (balls.length) {
      case 1:
        return balls;
      case 2:
        if (balls[0].getWeight() > balls[1].getWeight()) {
          Ball swapBall = balls[0];
          balls[0] = balls[1];
          balls[1] = swapBall;
        }
        return balls;
      default: {
        Ball[] leftHalf;
        Ball[] rightHalf;
        int rightSize = balls.length / 2;
        rightHalf = new Ball[rightSize];
        int leftSize = balls.length % 2 == 0 ? rightSize : rightSize + 1;
        leftHalf = new Ball[leftSize];
        rightSize = 0;
        for (int i = 0; i < balls.length; i++) {
          if (i < leftSize) {
            leftHalf[i] = balls[i];
          } else {
            rightHalf[rightSize] = balls[i];
            rightSize++;
          }
        }
        sortByWeight(leftHalf);
        sortByWeight(rightHalf);
        int leftInd = 0, rightInd = 0;
        for (int i = 0; i < balls.length; i++) {
          if (leftInd >= leftHalf.length) {
            while (rightInd < rightHalf.length) {
              balls[i] = rightHalf[rightInd];
              i++;
              rightInd++;
            }
            break;
          } else if (rightInd >= rightHalf.length) {
            while (leftInd < leftHalf.length) {
              balls[i] = leftHalf[leftInd];
              i++;
              leftInd++;
            }
            break;
          }
          if (leftHalf[leftInd].getWeight() <
              rightHalf[rightInd].getWeight()) {
            balls[i] = leftHalf[leftInd];
            leftInd++;
          } else {
            balls[i] = rightHalf[rightInd];
            rightInd++;
          }
        }
        return balls;
      }
    }
  }

  @Override
  public Ball[] sort(Ball[] balls, int k) {
    Ball[] resultArray = new Ball[balls.length];
    switch (Math.abs(k)) {
      case 1:
        sortByColor(balls);
        break;
      case 2:
        sortByDiameter(balls);
        break;
      case 3:
        sortByWeight(balls);
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
