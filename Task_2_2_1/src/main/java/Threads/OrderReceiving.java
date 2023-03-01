package Threads;

import Orders.Order;
import Orders.ProductQueue;

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
      queue.receiveOrder(order);
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
    }
  }
}

