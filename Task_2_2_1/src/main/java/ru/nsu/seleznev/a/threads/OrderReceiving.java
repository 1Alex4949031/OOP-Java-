package ru.nsu.seleznev.a.threads;

import ru.nsu.seleznev.a.orders.Order;
import ru.nsu.seleznev.a.orders.ProductQueue;

/**
 * OrderReceiving class used for receiving orders in the Queue of preparing.
 */
public class OrderReceiving implements PizzaThreads {

  private boolean isWorking;
  private final ProductQueue queue;

  /**
   * OrderThread constructor.
   *
   * @param queue Queue of preparing
   */
  public OrderReceiving(ProductQueue queue) {
    this.queue = queue;
  }

  /**
   * Function that runs OrderReceiving thread.
   */
  @Override
  public void run() {
    isWorking = true;
    int time = 5000;
    int count = 1;
    while (isWorking) {
      Order order = new Order(count);
      try {
        queue.receiveOrder(order);
      } catch (InterruptedException e) {
        throw new RuntimeException("Exception connected with Order Receiving thread!");
      }
      System.out.println(order.getOrderStatus());
      waitingTime(time);
      count++;
    }
  }

  /**
   * Function that stops the OrderReceiving thread.
   */
  @Override
  public void stop() {
    isWorking = false;
    System.out.println("Last orders are transferring!");
  }

  /**
   * Function that turns thread to sleep for fixed time.
   *
   * @param time time
   */
  private void waitingTime(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException("Something goes wrong with receiving!");
    }
  }
}

