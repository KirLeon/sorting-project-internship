import com.innowise.Balls.BallInterface;
import com.innowise.Balls.Ball;
import com.innowise.Balls.Colors;
import com.innowise.Exceptions.EmptyArrayException;
import com.innowise.Sorters.QuickSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickSorterTest {

  private static BallInterface[] balls;
  private static QuickSorter sorter;

  @BeforeAll
  public static void setup() {
    balls = new BallInterface[7];
    sorter = new QuickSorter();
  }

  @BeforeEach
  public void clean() {
    BallInterface ball1 = new Ball(40.4, 12.8, Colors.PURPLE);
    BallInterface ball2 = new Ball(39.5, 15.8, Colors.RED);
    BallInterface ball3 = new Ball(23.0, 16.0, Colors.YELLOW);
    BallInterface ball4 = new Ball(49.8, 15.8, Colors.WHITE);
    BallInterface ball5 = new Ball(25, 28.4, Colors.WHITE);
    BallInterface ball6 = new Ball(17.3, 15.0, Colors.GREEN);
    BallInterface ball7 = new Ball(25, 12.8, Colors.PURPLE);
    balls[0] = ball1;
    balls[1] = ball2;
    balls[2] = ball3;
    balls[3] = ball4;
    balls[4] = ball5;
    balls[5] = ball6;
    balls[6] = ball7;
  }

  @Test
  public void quickCheckExceptionTest() {
    BallInterface[] emptyBalls = null;
    BallInterface[] halfEmptyBallArray = new BallInterface[]{balls[2], balls[5], null, balls[1], null};
    EmptyArrayException thrownException1 = Assertions.assertThrows(EmptyArrayException.class,
        () -> sorter.sort(emptyBalls, -3));
    EmptyArrayException thrownException2 = Assertions.assertThrows(EmptyArrayException.class,
        () -> sorter.sort(halfEmptyBallArray, 2));
    Assertions.assertTrue(thrownException1.getMessage().contentEquals("Array is empty"));
    Assertions.assertTrue(thrownException2.getMessage().contentEquals("Element 2 is null"));
  }

  @Test
  public void quickSorterColors() {
    Colors[] expectedColors = new Colors[7];
    Colors[] realColors = new Colors[7];
    expectedColors[0] = Colors.WHITE;
    expectedColors[1] = Colors.WHITE;
    expectedColors[2] = Colors.RED;
    expectedColors[3] = Colors.YELLOW;
    expectedColors[4] = Colors.GREEN;
    expectedColors[5] = Colors.PURPLE;
    expectedColors[6] = Colors.PURPLE;
    try {
      balls = sorter.sort(balls, 1);
    } catch (EmptyArrayException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < realColors.length; i++) {
      realColors[i] = balls[i].getColor();
    }
    Assertions.assertArrayEquals(expectedColors, realColors);
  }

  @Test
  public void quickSorterDiameters() {
    double[] expectedDiameters = new double[7];
    double[] realDiameters = new double[7];
    expectedDiameters[0] = 12.8;
    expectedDiameters[1] = 12.8;
    expectedDiameters[2] = 15.0;
    expectedDiameters[3] = 15.8;
    expectedDiameters[4] = 15.8;
    expectedDiameters[5] = 16.0;
    expectedDiameters[6] = 28.4;
    try {
      balls = sorter.sort(balls, 2);
    } catch (EmptyArrayException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < realDiameters.length; i++) {
      realDiameters[i] = balls[i].getDiameter();
    }
    Assertions.assertArrayEquals(expectedDiameters, realDiameters);
  }

  @Test
  public void quickSorterWeights() {
    double[] expectedWeight = new double[7];
    double[] realDiameters = new double[7];
    expectedWeight[0] = 17.3;
    expectedWeight[1] = 23.0;
    expectedWeight[2] = 25;
    expectedWeight[3] = 25;
    expectedWeight[4] = 39.5;
    expectedWeight[5] = 40.4;
    expectedWeight[6] = 49.8;
    try {
      balls = sorter.sort(balls, 3);
    } catch (EmptyArrayException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < realDiameters.length; i++) {
      realDiameters[i] = balls[i].getWeight();
    }
    Assertions.assertArrayEquals(expectedWeight, realDiameters);
  }

  @Test
  public void quickSorterDescendingColors() {
    Colors[] expectedColors = new Colors[7];
    Colors[] realColors = new Colors[7];
    expectedColors[0] = Colors.PURPLE;
    expectedColors[1] = Colors.PURPLE;
    expectedColors[2] = Colors.GREEN;
    expectedColors[3] = Colors.YELLOW;
    expectedColors[4] = Colors.RED;
    expectedColors[5] = Colors.WHITE;
    expectedColors[6] = Colors.WHITE;
    try {
      balls = sorter.sort(balls, -1);
    } catch (EmptyArrayException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < realColors.length; i++) {
      realColors[i] = balls[i].getColor();
    }
    Assertions.assertArrayEquals(expectedColors, realColors);
  }

  @Test
  public void quickSorterDescendingDiameters() {
    double[] expectedDiameters = new double[7];
    double[] realDiameters = new double[7];
    expectedDiameters[0] = 28.4;
    expectedDiameters[1] = 16.0;
    expectedDiameters[2] = 15.8;
    expectedDiameters[3] = 15.8;
    expectedDiameters[4] = 15.0;
    expectedDiameters[5] = 12.8;
    expectedDiameters[6] = 12.8;
    try {
      balls = sorter.sort(balls, -2);
    } catch (EmptyArrayException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < realDiameters.length; i++) {
      realDiameters[i] = balls[i].getDiameter();
    }
    Assertions.assertArrayEquals(expectedDiameters, realDiameters);
  }

  @Test
  public void quickSorterDescendingWeights() {
    double[] expectedWeight = new double[7];
    double[] realDiameters = new double[7];
    expectedWeight[0] = 49.8;
    expectedWeight[1] = 40.4;
    expectedWeight[2] = 39.5;
    expectedWeight[3] = 25;
    expectedWeight[4] = 25;
    expectedWeight[5] = 23.0;
    expectedWeight[6] = 17.3;
    try {
      balls = sorter.sort(balls, -3);
    } catch (EmptyArrayException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < realDiameters.length; i++) {
      realDiameters[i] = balls[i].getWeight();
    }
    Assertions.assertArrayEquals(expectedWeight, realDiameters);
  }
}
