package nsu.seleznev.a;

import java.util.List;

/**
 * Parallel Stream Api Finder class used for finding not prime number
 * in the list of numbers using parallelStream().
 * ------------------------------------------------------------------------
 * Parallel Stream Api solution
 * ------------------------------------------------------------------------
 */
public class ParallelsStreamFinder {
  /**
   * Function that finds not prime number
   * in the list of numbers.
   *
   * @param numbers numbers need to check
   * @return true if list includes not prime number,
   *         false otherwise
   */
  public boolean parallelStreamApiFinder(List<Long> numbers) {
    return numbers.parallelStream().anyMatch(NotPrimeNumber::isNotPrimeNumber);
  }
}
