package nsu.seleznev.a;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Tests that checks the correctness if MultiThreadFinder class.
 */
public class ThreadsTest {
  @Test
  public void oneThreadTestTrue() {
    List<Long> list = Arrays.asList(4L, 1L, 11L, 11L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(1, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void oneThreadTestFalse() {
    List<Long> list = Arrays.asList(17L, 7L, 11L, 13L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(1, list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void twoThreadsTestFalse() {
    List<Long> list = Arrays.asList(1L, 11L, 13L, 17L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(2, list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void twoThreadsTestTrue() {
    List<Long> list = Arrays.asList(11L, 4L, 13L, 13L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(2, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void threeThreadsTestFalse() {
    List<Long> list = Arrays.asList(19L, 29L, 17L, 11L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(3, list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void threeThreadsTrue1() {
    List<Long> list = Arrays.asList(1L, 3L, 4L, 17L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(3, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void threeThreadsTrue2() {
    List<Long> list = Arrays.asList(1L, 17L, 4L, 13L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(3, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void threeThreadsTrue3() {
    List<Long> list = Arrays.asList(1L, 5L, 5L, 4L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(3, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void threeThreadsTrue4() {
    List<Long> list = Arrays.asList(4L, 4L, 4L, 17L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(3, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void fourThreadsTestFalse() {
    List<Long> list = Arrays.asList(1L, 1L, 29L, 17L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(4, list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void fourThreadsTestTrue() {
    List<Long> list = Arrays.asList(4L, 4L, 19L, 4L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(4, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void fiveThreadsTestFalse() {
    List<Long> list = Arrays.asList(11L, 11L, 11L, 11L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(5, list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void fiveThreadsTestTrue() {
    List<Long> list = Arrays.asList(17L, 11L, 11L, 4L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(5, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void sixThreadsTestTrue() {
    List<Long> list = Arrays.asList(17L, 11L, 11L, 4L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(6, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void sixThreadsTestFalse() {
    List<Long> list = Arrays.asList(17L, 11L, 11L, 13L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(6, list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void eightThreadsTestTrue() {
    List<Long> list = Arrays.asList(17L, 11L, 11L, 4L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(8, list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void eightThreadsTestFalse() {
    List<Long> list = Arrays.asList(17L, 11L, 11L, 13L, 17L, 11L, 11L, 13L, 17L,
        11L, 11L, 13L, 17L, 11L, 11L, 13L, 13L);
    MultiThreadFinder test = new MultiThreadFinder();
    boolean act = test.parallelFinder(8, list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }
}
