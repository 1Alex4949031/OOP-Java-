import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

/**
 * Class with Tests examples for heapsort.
 */
public class Tests {
  /** Test number 1. */
  public static void theFirstTest() {

    HeapSort test = new HeapSort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test1 = {1, 2, 3, 4, 5};

    HeapSort.heapsort(test1);
    Assertions.assertEquals(test1, correct);
  }

  /** Test number 2. */
  public static void theSecondTest() {

    HeapSort test = new HeapSort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test2 = {5, 4, 3, 2, 1};

    HeapSort.heapsort(test2);
    Assertions.assertEquals(test2, correct);
  }
  /** Test number 3. */
  public static void theThirdTest() {

    HeapSort test = new HeapSort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test3 = {0, 0, 0, 0, 0};

    HeapSort.heapsort(test3);
    Assertions.assertEquals(test3, correct);
  }
  /** Test number 4. */
  public static void theFourthTest() {

    HeapSort test = new HeapSort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test4 = {};

    HeapSort.heapsort(test4);
    Assertions.assertEquals(test4, correct);
  }
  /** Test number 5. */
  public static void theFifthTest() {

    HeapSort test = new HeapSort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test5 = {51, 43, 11, 1, 14, 5};

    HeapSort.heapsort(test5);
    Assertions.assertEquals(test5, correct);
  }
  /** Test number 6. */
  public static void theSixthTest() {

    HeapSort test = new HeapSort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test6 = {3, 4, 5, 6, 1};

    HeapSort.heapsort(test6);
    Assertions.assertEquals(test6, correct);
  }
  /** Test number 7. */
  public static void theSeventhTest() {

    HeapSort test = new HeapSort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test7 = {1, 2, 1, 1, 2};

    HeapSort.heapsort(test7);
    Assertions.assertEquals(test7, correct);
  }
  /** Test number 8. */
  public static void theEighthTest() {

    HeapSort test = new HeapSort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test8 = {1};

    HeapSort.heapsort(test8);
    Assertions.assertEquals(test8, correct);
  }
}