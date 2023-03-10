import com.innowise.Balls.BallInterface;
import com.innowise.Balls.Ball;
import com.innowise.Balls.Colors;
import com.innowise.ConcurrentSorters.ConcurrentMergeSorter;
import com.innowise.Exceptions.EmptyArrayException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConcurrentMergeSorterTest {

  private static BallInterface[] balls;
  private static ConcurrentMergeSorter sorter;

  @BeforeAll
  public static void setup() {
    balls = new BallInterface[7];
    sorter = new ConcurrentMergeSorter();
  }

  @BeforeEach
  public void clean() {
    BallInterface ball1 = new Ball(17.4, 19.8, Colors.CYAN);
    BallInterface ball2 = new Ball(39.2, 27.0, Colors.GREEN);
    BallInterface ball3 = new Ball(44.0, 13.0, Colors.YELLOW);
    BallInterface ball4 = new Ball(17.4, 52.3, Colors.PURPLE);
    BallInterface ball5 = new Ball(17.4, 18.4, Colors.WHITE);
    BallInterface ball6 = new Ball(26.4, 19.8, Colors.YELLOW);
    BallInterface ball7 = new Ball(28, 23, Colors.ORANGE);
    balls[0] = ball1;
    balls[1] = ball2;
    balls[2] = ball3;
    balls[3] = ball4;
    balls[4] = ball5;
    balls[5] = ball6;
    balls[6] = ball7;
  }

  @Test
  public void mergeCheckExceptionTest() {
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
  public void mergeSortColors() {
    Colors[] expectedColors = new Colors[7];
    Colors[] realColors = new Colors[7];
    expectedColors[0] = Colors.WHITE;
    expectedColors[1] = Colors.ORANGE;
    expectedColors[2] = Colors.YELLOW;
    expectedColors[3] = Colors.YELLOW;
    expectedColors[4] = Colors.GREEN;
    expectedColors[5] = Colors.CYAN;
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
  public void mergeSortDiameters() {
    double[] expectedDiameters = new double[7];
    double[] realDiameters = new double[7];
    expectedDiameters[0] = 13.0;
    expectedDiameters[1] = 18.4;
    expectedDiameters[2] = 19.8;
    expectedDiameters[3] = 19.8;
    expectedDiameters[4] = 23.0;
    expectedDiameters[5] = 27.0;
    expectedDiameters[6] = 52.3;
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
  public void mergeSortWeights() {
    double[] expectedWeights = new double[7];
    double[] realWeights = new double[7];
    expectedWeights[0] = 17.4;
    expectedWeights[1] = 17.4;
    expectedWeights[2] = 17.4;
    expectedWeights[3] = 26.4;
    expectedWeights[4] = 28;
    expectedWeights[5] = 39.2;
    expectedWeights[6] = 44.0;
    try {
      balls = sorter.sort(balls, 3);
    } catch (EmptyArrayException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < realWeights.length; i++) {
      realWeights[i] = balls[i].getWeight();
    }
    Assertions.assertArrayEquals(expectedWeights, realWeights);
  }

  @Test
  public void mergeSortDescendingColors() {
    Colors[] expectedColors = new Colors[7];
    Colors[] realColors = new Colors[7];
    expectedColors[0] = Colors.PURPLE;
    expectedColors[1] = Colors.CYAN;
    expectedColors[2] = Colors.GREEN;
    expectedColors[3] = Colors.YELLOW;
    expectedColors[4] = Colors.YELLOW;
    expectedColors[5] = Colors.ORANGE;
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
  public void mergeSortDescendingDiameters() {
    double[] expectedDiameters = new double[7];
    double[] realDiameters = new double[7];
    expectedDiameters[0] = 52.3;
    expectedDiameters[1] = 27.0;
    expectedDiameters[2] = 23.0;
    expectedDiameters[3] = 19.8;
    expectedDiameters[4] = 19.8;
    expectedDiameters[5] = 18.4;
    expectedDiameters[6] = 13.0;
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
  public void mergeSortDescendingWeights() {
    double[] expectedWeights = new double[7];
    double[] realWeights = new double[7];
    expectedWeights[0] = 44.0;
    expectedWeights[1] = 39.2;
    expectedWeights[2] = 28;
    expectedWeights[3] = 26.4;
    expectedWeights[4] = 17.4;
    expectedWeights[5] = 17.4;
    expectedWeights[6] = 17.4;
    try {
      balls = sorter.sort(balls, -3);
    } catch (EmptyArrayException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < realWeights.length; i++) {
      realWeights[i] = balls[i].getWeight();
    }
    Assertions.assertArrayEquals(expectedWeights, realWeights);
  }
}
