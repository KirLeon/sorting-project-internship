import Balls.Ball;
import Balls.BallImplementation;
import Balls.Colors;
import Sorters.QuickSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickSorterTest {

  private static Ball[] balls;
  private static QuickSorter sorter;

  @BeforeAll
  public static void setup() {
    balls = new Ball[7];
    sorter = new QuickSorter();
  }

  @BeforeEach
  public void clean() {
    Ball ball1 = new BallImplementation(40.4, 12.8, Colors.PURPLE);
    Ball ball2 = new BallImplementation(39.5, 15.8, Colors.RED);
    Ball ball3 = new BallImplementation(23.0, 16.0, Colors.YELLOW);
    Ball ball4 = new BallImplementation(49.8, 15.8, Colors.WHITE);
    Ball ball5 = new BallImplementation(25, 28.4, Colors.WHITE);
    Ball ball6 = new BallImplementation(17.3, 15.0, Colors.GREEN);
    Ball ball7 = new BallImplementation(25, 12.8, Colors.PURPLE);
    balls[0] = ball1;
    balls[1] = ball2;
    balls[2] = ball3;
    balls[3] = ball4;
    balls[4] = ball5;
    balls[5] = ball6;
    balls[6] = ball7;
  }

  //  @Test
//  public void FST_COLOR1() {
//    Balls.Colors[] expectedColors = new Balls.Colors[7];
//    Balls.Colors[] realColors = new Balls.Colors[7];
//    expectedColors[0] = Balls.Colors.WHITE;
//    expectedColors[1] = Balls.Colors.WHITE;
//    expectedColors[2] = Balls.Colors.RED;
//    expectedColors[3] = Balls.Colors.YELLOW;
//    expectedColors[4] = Balls.Colors.GREEN;
//    expectedColors[5] = Balls.Colors.PURPLE;
//    expectedColors[6] = Balls.Colors.PURPLE;
//    sorter.sortByColor(balls, 0, 6);
//    for (int i = 0; i < realColors.length; i++) {
//      realColors[i] = balls[i].getColor();
//    }
//    sorter.sortByColor(balls, 0, 6);
//    Assertions.assertArrayEquals(expectedColors, realColors);
//  }
//
//  @Test
//  public void FST_WEIGHT1(){
//    double[] expectedWeight = new double[7];
//    double[] realDiameters = new double[7];
//    expectedWeight[0] = 17.3;
//    expectedWeight[1] = 23.0;
//    expectedWeight[2] = 25;
//    expectedWeight[3] = 25;
//    expectedWeight[4] = 39.5;
//    expectedWeight[5] = 40.4;
//    expectedWeight[6] = 49.8;
//    sorter.sortByWeight(balls, 0, 6);
//    for(int i = 0; i< realDiameters.length; i++){
//      realDiameters[i] = balls[i].getWeight();
//    }
//    Assertions.assertArrayEquals(expectedWeight, realDiameters);
//  }
//
//  @Test
//  public void FST_DIAMETER1(){
//    double[] expectedDiameters = new double[7];
//    double[] realDiameters = new double[7];
//    expectedDiameters[0] = 12.8;
//    expectedDiameters[1] = 12.8;
//    expectedDiameters[2] = 15.0;
//    expectedDiameters[3] = 15.8;
//    expectedDiameters[4] = 15.8;
//    expectedDiameters[5] = 16.0;
//    expectedDiameters[6] = 28.4;
//    sorter.sortByDiameter(balls, 0, 6);
//    for(int i = 0; i< realDiameters.length; i++){
//      realDiameters[i] = balls[i].getDiameter();
//    }
//    Assertions.assertArrayEquals(expectedDiameters, realDiameters);
//  }
  @Test
  public void FST_MENU_COLORS1() {
    Colors[] expectedColors = new Colors[7];
    Colors[] realColors = new Colors[7];
    expectedColors[0] = Colors.WHITE;
    expectedColors[1] = Colors.WHITE;
    expectedColors[2] = Colors.RED;
    expectedColors[3] = Colors.YELLOW;
    expectedColors[4] = Colors.GREEN;
    expectedColors[5] = Colors.PURPLE;
    expectedColors[6] = Colors.PURPLE;
    balls = sorter.sort(balls, 1);
    for (int i = 0; i < realColors.length; i++) {
      realColors[i] = balls[i].getColor();
    }
    Assertions.assertArrayEquals(expectedColors, realColors);
  }

  @Test
  public void FST_MENU_DIAMETER1() {
    double[] expectedDiameters = new double[7];
    double[] realDiameters = new double[7];
    expectedDiameters[0] = 12.8;
    expectedDiameters[1] = 12.8;
    expectedDiameters[2] = 15.0;
    expectedDiameters[3] = 15.8;
    expectedDiameters[4] = 15.8;
    expectedDiameters[5] = 16.0;
    expectedDiameters[6] = 28.4;
    balls = sorter.sort(balls, 2);
    for (int i = 0; i < realDiameters.length; i++) {
      realDiameters[i] = balls[i].getDiameter();
    }
    Assertions.assertArrayEquals(expectedDiameters, realDiameters);
  }

  @Test
  public void FST_MENU_WEIGHT1() {
    double[] expectedWeight = new double[7];
    double[] realDiameters = new double[7];
    expectedWeight[0] = 17.3;
    expectedWeight[1] = 23.0;
    expectedWeight[2] = 25;
    expectedWeight[3] = 25;
    expectedWeight[4] = 39.5;
    expectedWeight[5] = 40.4;
    expectedWeight[6] = 49.8;
    balls = sorter.sort(balls, 3);
    for (int i = 0; i < realDiameters.length; i++) {
      realDiameters[i] = balls[i].getWeight();
    }
    Assertions.assertArrayEquals(expectedWeight, realDiameters);
  }

  @Test
  public void FST_MENU_REVERSE_COLORS1() {
    Colors[] expectedColors = new Colors[7];
    Colors[] realColors = new Colors[7];
    expectedColors[0] = Colors.PURPLE;
    expectedColors[1] = Colors.PURPLE;
    expectedColors[2] = Colors.GREEN;
    expectedColors[3] = Colors.YELLOW;
    expectedColors[4] = Colors.RED;
    expectedColors[5] = Colors.WHITE;
    expectedColors[6] = Colors.WHITE;
    balls = sorter.sort(balls, -1);
    for (int i = 0; i < realColors.length; i++) {
      realColors[i] = balls[i].getColor();
    }
    Assertions.assertArrayEquals(expectedColors, realColors);
  }

  @Test
  public void FST_MENU_REVERSE_DIAMETER1() {
    double[] expectedDiameters = new double[7];
    double[] realDiameters = new double[7];
    expectedDiameters[0] = 28.4;
    expectedDiameters[1] = 16.0;
    expectedDiameters[2] = 15.8;
    expectedDiameters[3] = 15.8;
    expectedDiameters[4] = 15.0;
    expectedDiameters[5] = 12.8;
    expectedDiameters[6] = 12.8;
    balls = sorter.sort(balls, -2);
    for (int i = 0; i < realDiameters.length; i++) {
      realDiameters[i] = balls[i].getDiameter();
    }
    Assertions.assertArrayEquals(expectedDiameters, realDiameters);
  }

  @Test
  public void FST_MENU_REVERSE_WEIGHT1() {
    double[] expectedWeight = new double[7];
    double[] realDiameters = new double[7];
    expectedWeight[0] = 49.8;
    expectedWeight[1] = 40.4;
    expectedWeight[2] = 39.5;
    expectedWeight[3] = 25;
    expectedWeight[4] = 25;
    expectedWeight[5] = 23.0;
    expectedWeight[6] = 17.3;
    balls = sorter.sort(balls, -3);
    for (int i = 0; i < realDiameters.length; i++) {
      realDiameters[i] = balls[i].getWeight();
    }
    Assertions.assertArrayEquals(expectedWeight, realDiameters);
  }
}
