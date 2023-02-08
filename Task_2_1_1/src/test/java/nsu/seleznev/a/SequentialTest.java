package nsu.seleznev.a;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests that checks the correctness of SequentialFinder class.
 */
public class SequentialTest {
  @Test
  public void simpleTest() {
    List<Long> list = Arrays.asList(4L, 4L, 4L, 4L);
    SequentialFinder test = new SequentialFinder();
    boolean act = test.Finder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTestTrue1() {
    List<Long> list = Arrays.asList(4L, 17L, 1L, 1L);
    SequentialFinder test = new SequentialFinder();
    boolean act = test.Finder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTestTrue2() {
    List<Long> list = Arrays.asList(1L, 4L, 19L, 3L);
    SequentialFinder test = new SequentialFinder();
    boolean act = test.Finder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTestTrue3() {
    List<Long> list = Arrays.asList(3L, 11L, 4L, 29L);
    SequentialFinder test = new SequentialFinder();
    boolean act = test.Finder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTestTrue4() {
    List<Long> list = Arrays.asList(11L, 3L, 3L, 4L);
    SequentialFinder test = new SequentialFinder();
    boolean act = test.Finder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTestFalse() {
    List<Long> list = Arrays.asList(17L, 17L, 17L, 17L);
    SequentialFinder test = new SequentialFinder();
    boolean act = test.Finder(list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTestFalse2() {
    List<Long> list = Arrays.asList(11L, 11L, 1L, 11L);
    SequentialFinder test = new SequentialFinder();
    boolean act = test.Finder(list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }
}
