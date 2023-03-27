package ru.nsu.seleznev.a.orders;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ProductQueue class that implements the Queue of the orders.
 * We use it in both cases:
 * 1) Orders to prepare Queue
 * 2) Prepared orders to delivery Queue.
 */
public class ProductQueue {
  private final int maxQueueSize;
  private final Queue<Order> queue = new ArrayDeque<>();

  /**
   * ProductQueue constructor.
   *
   * @param queueSize size of the queue
   */
  public ProductQueue(int queueSize) {
    this.maxQueueSize = queueSize;
  }

  /**
   * Function that returns the queue.
   *
   * @return current queue
   */
  public Queue<Order> getQueue() {
    return queue;
  }

  /**
   * Function that receives order in the queue.
   *
   * @param order order need to receive
   */
  public void receiveOrder(Order order) {
    synchronized (queue) {
      while (queue.size() == maxQueueSize) {
        try {
          queue.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
          throw new RuntimeException("Thread is interrupted while waiting!");
        }
      }
      queue.add(order);
      queue.notifyAll();
    }
  }

  /**
   * Function that takes the order from the queue.
   *
   * @return order need to take
   */
  public Order transferOrder() {
    synchronized (queue) {
      while (queue.isEmpty()) {
        try {
          queue.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
          throw new RuntimeException("Thread is interrupted while waiting!");
        }
      }
      Order order = queue.poll();
      queue.notifyAll();
      return order;
    }
  }
}
