import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class with Tests examples for heapsort.
 */
public class Tests {
  /** Test number 1.*/
  @Test
  public void theFirstTest() {

    int[] correct = {1, 2, 3, 4, 5};
    int[] test1 = {1, 2, 3, 4, 5};

    Assertions.assertArrayEquals(HeapSort.heapsort(test1), correct);
  }

  public static void main(String[] args) {
    new Tests().theFirstTest();
  }
}
