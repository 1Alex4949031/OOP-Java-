import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

/**
 * Class with Tests examples for heapsort.
 */
public class Tests {
  /** Test number 1. */
  public static void theFirstTest() {

    Heapsort test = new Heapsort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test1 = {1, 2, 3, 4, 5};

    Heapsort.heapsort(test1);
    Assertions.assertEquals(test1, correct);
  }

  /** Test number 2. */
  public static void theSecondTest() {

    Heapsort test = new Heapsort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test2 = {5, 4, 3, 2, 1};

    Heapsort.heapsort(test2);
    Assertions.assertEquals(test2, correct);
  }
  /** Test number 3. */
  public static void theThirdTest() {

    Heapsort test = new Heapsort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test3 = {0, 0, 0, 0, 0};

    Heapsort.heapsort(test3);
    Assertions.assertEquals(test3, correct);
  }
  /** Test number 4. */
  public static void theFourthTest() {

    Heapsort test = new Heapsort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test4 = {};

    Heapsort.heapsort(test4);
    Assertions.assertEquals(test4, correct);
  }
  /** Test number 5. */
  public static void theFifthTest() {

    Heapsort test = new Heapsort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test5 = {51, 43, 11, 1, 14, 5};

    Heapsort.heapsort(test5);
    Assertions.assertEquals(test5, correct);
  }
  /** Test number 6. */
  public static void theSixthTest() {

    Heapsort test = new Heapsort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test6 = {3, 4, 5, 6, 1};

    Heapsort.heapsort(test6);
    Assertions.assertEquals(test6, correct);
  }
  /** Test number 7. */
  public static void theSeventhTest() {

    Heapsort test = new Heapsort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test7 = {1, 2, 1, 1, 2};

    Heapsort.heapsort(test7);
    Assertions.assertEquals(test7, correct);
  }
  /** Test number 8. */
  public static void theEighthTest() {

    Heapsort test = new Heapsort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test8 = {1};

    Heapsort.heapsort(test8);
    Assertions.assertEquals(test8, correct);
  }
}