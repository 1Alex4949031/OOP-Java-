package ru.nsu.a.seleznev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class with Tests examples for heapsort.
 */
public class Tests {
  /**
   * Test number 1 for sorted array.
   */
  @Test
  public void theFirstTest() {

    int[] correct = {1, 2, 3, 4, 5};
    int[] test1 = {1, 2, 3, 4, 5};

    Assertions.assertArrayEquals(HeapSort.heapsort(test1), correct);
  }

  /**
   * Test number 2 for inverse array.
   */
  @Test
  public void theSecondOne() {

    int[] correct = {1, 2, 3, 4, 5};
    int[] test2 = {5, 4, 3, 2, 1};

    Assertions.assertArrayEquals(HeapSort.heapsort(test2), correct);
  }

  /**
   * Test number 3 for fully equal arrays.
   */
  @Test
  public void theThirdTest() {

    int[] correct = {0, 0, 0, 0, 0};
    int[] test3 = {0, 0, 0, 0, 0};

    Assertions.assertArrayEquals(HeapSort.heapsort(test3), correct);
  }

  /**
   * Test number 4 for empty arrays.
   */
  @Test
  public void theFourthTest() {

    int[] correct = {};
    int[] test4 = {};

    Assertions.assertArrayEquals(HeapSort.heapsort(test4), correct);
  }

  /**
   * Test number 5 for random array 1.
   */
  @Test
  public void theFifthTest() {

    int[] correct = {1, 5, 11, 14, 43, 51};
    int[] test5 = {51, 43, 11, 1, 14, 5};

    Assertions.assertArrayEquals(HeapSort.heapsort(test5), correct);
  }

  /**
   * Test number 6 for random array 2.
   */
  @Test
  public void theSixthTest() {

    int[] correct = {1, 2, 3, 4, 5};
    int[] test6 = {3, 4, 5, 2, 1};

    Assertions.assertArrayEquals(HeapSort.heapsort(test6), correct);
  }

  /**
   * Test number 7 fot array with equal elements.
   */
  @Test
  public void theSeventhTest() {

    int[] correct = {1, 1, 1, 2, 2};
    int[] test7 = {1, 2, 1, 1, 2};

    Assertions.assertArrayEquals(HeapSort.heapsort(test7), correct);
  }

  /**
   * Test number 8 for random array 3.
   */
  @Test
  public void theEighthTest() {

    int[] correct = {1, 1, 2, 2, 3};
    int[] test8 = {1, 3, 2, 1, 2};

    Assertions.assertArrayEquals(HeapSort.heapsort(test8), correct);
  }
}
