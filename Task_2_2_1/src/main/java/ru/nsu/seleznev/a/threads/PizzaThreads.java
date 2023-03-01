package ru.nsu.seleznev.a.threads;

/**
 * PizzaThreads interface for cooks and couriers and order receiving.
 */
public interface PizzaThreads extends Runnable {
  /**
   * Run function for cooks and couriers.
   */
  void run();

  /**
   * Stop function for cooks and couriers.
   */
  void stop();
}
