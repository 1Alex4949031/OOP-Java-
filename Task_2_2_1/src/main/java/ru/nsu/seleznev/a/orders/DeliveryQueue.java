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
  public List<Order> transferAvailableOrders(int availableCount) {
    synchronized (queue) {
      List<Order> orders = new ArrayList<>();
      while (queue.isEmpty()) {
        try {
          queue.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException("Exception connected with empty queue!");
        }
      }
      for (int i = 0; i < queue.size() && i < availableCount; i++) {
        Order order = queue.poll();
        orders.add(order);
      }
      queue.notifyAll();
      return orders;
    }
  }
}
