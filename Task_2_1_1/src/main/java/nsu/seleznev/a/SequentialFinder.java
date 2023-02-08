package nsu.seleznev.a;

import java.util.List;

/**
 * Sequential finder used for finding not prime number
 * in the list of numbers.
 * ------------------------------------------------------------------------
 * Sequential solution.
 * ------------------------------------------------------------------------
 */
public class SequentialFinder {
  /**
   * Function that finds not prime number.
   *
   * @param numbers list of number need to check
   * @return true if list includes not prime number, false otherwise
   */
  public boolean Finder(List<Long> numbers) {
    for (Long i : numbers) {
      if (NotPrimeNumber.isNotPrimeNumber(i)) {
        return true;
      }
    }
    return  false;
  }
}