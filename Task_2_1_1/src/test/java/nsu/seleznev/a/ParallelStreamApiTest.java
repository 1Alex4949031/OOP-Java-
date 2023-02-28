package nsu.seleznev.a;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class that checks the correctness of the parallelStream().
 */
public class ParallelStreamApiTest {
  @Test
  public void simpleTrueTest1() {
    List<Long> list = Arrays.asList(1L, 16L, 12L, 14L);
    boolean act = ParallelsStreamFinder.parallelStreamApiFinder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTrueTest2() {
    List<Long> list = Arrays.asList(14L, 1L, 12L, 14L);
    boolean act = ParallelsStreamFinder.parallelStreamApiFinder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTrueTest3() {
    List<Long> list = Arrays.asList(14L, 12L, 13L, 14L);
    boolean act = ParallelsStreamFinder.parallelStreamApiFinder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTrueTest4() {
    List<Long> list = Arrays.asList(14L, 12L, 15L, 17L);
    boolean act = ParallelsStreamFinder.parallelStreamApiFinder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleTrueTest5() {
    List<Long> list = Arrays.asList(12L, 12L, 12L, 12L);
    boolean act = ParallelsStreamFinder.parallelStreamApiFinder(list);
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleFalseTest1() {
    List<Long> list = Arrays.asList(1L, 1L, 1L, 1L);
    boolean act = ParallelsStreamFinder.parallelStreamApiFinder(list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void simpleFalseTest2() {
    List<Long> list = Arrays.asList(13L, 13L, 13L, 13L);
    boolean act = ParallelsStreamFinder.parallelStreamApiFinder(list);
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }
}
