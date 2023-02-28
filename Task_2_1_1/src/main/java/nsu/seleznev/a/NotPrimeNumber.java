package nsu.seleznev.a;

import static java.lang.Math.sqrt;

/**
 * ------------------------------------------------------------------------
 * NotPrimeNumber class used for finding not prime number.
 * ------------------------------------------------------------------------
 */
public class NotPrimeNumber {
  /**
   * Function that checks the number is not the prime number.
   *
   * @param number number need to check
   * @return true if the number is not prime, false otherwise
   */
  public static boolean isNotPrimeNumber(long number) {
    for (int i = 2; i <= sqrt(number); i++) {
      if (number % i == 0) {
        return true;
      }
    }
    return false;
  }
}
