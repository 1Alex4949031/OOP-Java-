package ru.nsu.seleznev.a.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * DeliveryQueue class extends ProductQueue.
 * Implements ProductQueue methods and
 * one local method transferAvailableOrders.
 */
public class DeliveryQueue extends ProductQueue {

  /**
   * ProductQueue constructor.
   *
   * @param queueSize size of the queue
   */
  public DeliveryQueue(int queueSize) {
    super(queueSize);
  }

  /**
   * Function that takes (1..availableCount..size of the Queue)
   * orders.
   *
   * @param availableCount max count of orders can be taken
   * @return list of orders that were taken
   */
  public List<Order> transferAvailableOrders(int availableCount) throws InterruptedException {
    synchronized (getQueue()) {
      List<Order> orders = new ArrayList<>();
      while (getQueue().isEmpty()) {
        getQueue().wait();
      }
      for (int i = 0; i < getQueue().size() && i < availableCount; i++) {
        Order order = getQueue().poll();
        orders.add(order);
      }
      getQueue().notifyAll();
      return orders;
    }
  }
}
