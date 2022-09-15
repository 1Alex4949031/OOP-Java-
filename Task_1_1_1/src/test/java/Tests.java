import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class with Tests examples for heapsort.
 */
public class Tests {
  /** Test number 1.*/
  @Test
  public static void theFirstTest() {

    HeapSort heapSort = new HeapSort();
    int[] correct = {1, 2, 3, 4, 5};
    int[] test1 = {1, 2, 3, 4, 5};

    heapSort.heapsort(test1);
    Assertions.assertEquals(test1, correct);
  }
}
