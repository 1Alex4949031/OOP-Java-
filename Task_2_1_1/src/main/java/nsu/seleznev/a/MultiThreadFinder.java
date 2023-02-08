package nsu.seleznev.a;

import java.util.Arrays;
import java.util.List;

/**
 * MultiThreadFinder class used for finding not prime number
 * in the list of numbers with different count of threads.
 * List of numbers is divided into some parts equals to the count of threads.
 * Each thread tries to find not prime number in the own part.
 * ------------------------------------------------------------------------
 * Parallel solution with different number of threads.
 * ------------------------------------------------------------------------
 */
public class MultiThreadFinder {
  private boolean simpleNum = false;

  /**
   * FinderThread class for creating thread.
   */
  public class FinderThread extends Thread {
    private final List<Long> numbers;

    /**
     * FinderThread constructor.
     *
     * @param numbers numbers need to check
     */
    public FinderThread(List<Long> numbers) {
      this.numbers = numbers;
    }

    /**
     * Override Run method for thread.
     */
    @Override
    public void run() {
      for (Long i : numbers) {
        if (NotPrimeNumber.isNotPrimeNumber(i)) {
          simpleNum = true;
          break;
        }
      }
    }
  }

  /**
   * Main function that tries to find not prime
   * number in the list of numbers.
   *
   * @param countThreads total count of threads
   * @param numbers      list of numbers
   * @return true if list includes not prime number
   * false otherwise
   */
  public boolean parallelFinder(int countThreads, List<Long> numbers) {
    int maxCountThreads = Runtime.getRuntime().availableProcessors();
    if (countThreads <= 0) {
      throw new IllegalArgumentException("Number of threads is incorrect!");
    }
    if (countThreads > maxCountThreads) {
      countThreads = maxCountThreads;
    }
    int len = numbers.size(), part;
    if (numbers.size() >= countThreads) {
      part = len / countThreads;
    } else {
      part = 1;
      countThreads = len;
    }
    FinderThread[] threads = new FinderThread[countThreads];
    for (int i = 0; i < countThreads; i++) {
      int fromIndex = part * i;
      int toIndex = part * (i + 1);
      if (i == countThreads - 1) {
        toIndex = len;
      }
      threads[i] = new FinderThread(numbers.subList(fromIndex, toIndex));
      threads[i].start();
    }
    checkThreads(threads);
    return simpleNum;
  }

  /**
   * Function checks that all threads created are finished.
   *
   * @param threads created threads
   */
  public void checkThreads(FinderThread[] threads) {
    Arrays.stream(threads).forEach(finderThread -> {
      try {
        finderThread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
  }
}
