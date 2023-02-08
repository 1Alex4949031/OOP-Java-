package nsu.seleznev.a;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Complex test used for making own CHART.
 * Can change the list with numbers and the size of the list.
 * See CHART, run BarChart.
 */

public class ComplexTimeTest {
  private final long size = 1000000;
  private final List<Long> numbersOnlyPrime = initPrimeList();
  private final List<Long> numbersOnlyNonPrime = initNonPrimeList();

  /**
   * Initialization for array with prime numbers only.
   *
   * @return initialized array
   */
  private List<Long> initPrimeList() {
    List<Long> result = new ArrayList<>();
    for (long i = 0; i < size; i++) {
      result.add(1000003L);
    }
    return result;
  }

  /**
   * Initialization for array without prime numbers.
   *
   * @return initialized array
   */
  private List<Long> initNonPrimeList() {
    List<Long> result = new ArrayList<>();
    for (long i = 0; i < size; i++) {
      result.add(1000002L);
    }
    return result;
  }

  @Test
  public void sequentialPrimeTest() {
    SequentialFinder test = new SequentialFinder();
    long time = System.currentTimeMillis();
    boolean act = test.Finder(numbersOnlyPrime);
    System.out.println("Sequential test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void sequentialNonPrimeTest() {
    SequentialFinder test = new SequentialFinder();
    long time = System.currentTimeMillis();
    boolean act = test.Finder(numbersOnlyNonPrime);
    System.out.println("Sequential test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread1() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(1, numbersOnlyPrime);
    System.out.println("One thread test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread1() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(1, numbersOnlyNonPrime);
    System.out.println("One thread test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread2() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(2, numbersOnlyPrime);
    System.out.println("Two threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread2() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(2, numbersOnlyNonPrime);
    System.out.println("Two threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread3() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(3, numbersOnlyPrime);
    System.out.println("Three threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread3() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(3, numbersOnlyNonPrime);
    System.out.println("Three threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread4() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(4, numbersOnlyPrime);
    System.out.println("Four threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread4() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(4, numbersOnlyNonPrime);
    System.out.println("Four threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread5() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(5, numbersOnlyPrime);
    System.out.println("Five threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread5() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(5, numbersOnlyNonPrime);
    System.out.println("Five threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread6() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(6, numbersOnlyPrime);
    System.out.println("Six threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread6() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(6, numbersOnlyNonPrime);
    System.out.println("Six threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread7() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(7, numbersOnlyPrime);
    System.out.println("Seven threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread7() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(7, numbersOnlyNonPrime);
    System.out.println("Seven threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread8() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(8, numbersOnlyPrime);
    System.out.println("Eight threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread8() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(8, numbersOnlyNonPrime);
    System.out.println("Eight threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread9() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(9, numbersOnlyPrime);
    System.out.println("Nine threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread9() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(9, numbersOnlyNonPrime);
    System.out.println("Nine threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread10() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(10, numbersOnlyPrime);
    System.out.println("Ten threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread10() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(10, numbersOnlyNonPrime);
    System.out.println("Ten threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread11() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(11, numbersOnlyPrime);
    System.out.println("Eleven threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread11() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(11, numbersOnlyNonPrime);
    System.out.println("Eleven threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread12() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(12, numbersOnlyPrime);
    System.out.println("Twelve threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread12() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(12, numbersOnlyNonPrime);
    System.out.println("Twelve threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread13() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(13, numbersOnlyPrime);
    System.out.println("Thirteen threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread13() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(13, numbersOnlyNonPrime);
    System.out.println("Thirteen threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread14() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(14, numbersOnlyPrime);
    System.out.println("Fourteen threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread14() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(14, numbersOnlyNonPrime);
    System.out.println("Fourteen threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread15() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(15, numbersOnlyPrime);
    System.out.println("Fifteen threads test with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread15() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(15, numbersOnlyNonPrime);
    System.out.println("Fifteen threads test without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelPrimeTestThread16() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(16, numbersOnlyPrime);
    System.out.println("Sixteen threads with prime number: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelNonPrimeTestThread16() {
    MultiThreadFinder test = new MultiThreadFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelFinder(16, numbersOnlyNonPrime);
    System.out.println("Sixteen threads without prime number: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelStreamNonPrimeTest() {
    ParallelsStreamFinder test = new ParallelsStreamFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelStreamApiFinder(numbersOnlyNonPrime);
    System.out.println("Parallel Stream Api without prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void parallelStreamPrimeTest() {
    ParallelsStreamFinder test = new ParallelsStreamFinder();
    long time = System.currentTimeMillis();
    boolean act = test.parallelStreamApiFinder(numbersOnlyPrime);
    System.out.println("Parallel Stream Api with prime numbers: "
        + (System.currentTimeMillis() - time));
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }
}
