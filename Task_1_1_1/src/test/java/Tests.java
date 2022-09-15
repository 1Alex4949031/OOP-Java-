import java.util.Arrays;

/**
 * Class with Tests examples.
 */
public class Tests {
  /**
   * Using Heapsort class for checking
   * the correctness of realization.
   *
   * @param args string arguments
   */

  public static void main(String[] args) {

    HeapSort test = new HeapSort();

    final int[] correct = {1, 2, 3, 4, 5};

    int[] test1 = {1, 2, 3, 4, 5};
    int[] test2 = {5, 4, 3, 2, 1};
    int[] test3 = {0, 0, 0, 0, 0};
    int[] test4 = {};
    int[] test5 = {51, 43, 11, 1, 14, 5};
    int[] test6 = {3, 4, 5, 6, 1};
    int[] test7 = {1, 2, 1, 1, 2};
    int[] test8 = {1};

    HeapSort.heapsort(test1);
    HeapSort.heapsort(test2);
    HeapSort.heapsort(test3);
    HeapSort.heapsort(test4);
    HeapSort.heapsort(test5);
    HeapSort.heapsort(test6);
    HeapSort.heapsort(test7);
    HeapSort.heapsort(test8);

    assert (Arrays.equals(test1, correct));
    assert (Arrays.equals(test2, correct));
    assert (Arrays.equals(test3, correct));
    assert (Arrays.equals(test4, correct));
    assert (Arrays.equals(test5, correct));
    assert (Arrays.equals(test6, correct));
    assert (Arrays.equals(test7, correct));
    assert (Arrays.equals(test8, correct));

  }
}