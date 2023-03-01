package Threads;

import Orders.DeliveryQueue;
import Orders.Order;
import Orders.ProductQueue;

import java.util.List;

/**
 * Courier class for Courier thread implementation.
 */
public class Courier implements PizzaThreads {
  private boolean isWorking;
  private final DeliveryQueue ordersToDelivery;
  private final int deliveryExperience;
  private final int deliverySize;
  private final String name;

  /**
   * Courier constructor.
   *
   * @param name               name of the courier
   * @param deliveryExperience delivery experience of the courier
   * @param deliverySize       delivery size of the Threads.Courier's trunk
   * @param ordersToDelivery   prepared orders ready to deliver
   */
  public Courier(String name, int deliveryExperience, int deliverySize,
                 DeliveryQueue ordersToDelivery) {
    this.deliveryExperience = deliveryExperience;
    this.name = name;
    this.ordersToDelivery = ordersToDelivery;
    this.deliverySize = deliverySize;
  }

  /**
   * Function that runs the Courier thread.
   */
  @Override
  public void run() {
    isWorking = true;
    int TIME = 20000;
    int deliveryTime = TIME / deliveryExperience;
    List<Order> orders;
    while (isWorking) {
      orders = ordersToDelivery.transferAvailableOrders(deliverySize);
      deliveringPizzaInfo(orders);
      workingTime(deliveryTime);
      deliveredPizzaInfo(orders);
    }
  }

  /**
   * Function that stops the work of the Courier thread.
   */
  @Override
  public void stop() {
    isWorking = false;
    System.out.println(name + " is delivering final order!");
  }

  /**
   * Function that turns thread to sleep for fixed time.
   * It is the working time of the current courier.
   *
   * @param time time need to sleep
   */
  private void workingTime(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new RuntimeException("Exception connected with delivering pizza!");
    }
  }

  /**
   * Function that changes the status of each order
   * in the list of order to 'Delivering' and prints information about the order.
   *
   * @param orders orders courier working with
   */
  private void deliveringPizzaInfo(List<Order> orders) {
    orders.forEach(i -> i.setOrderStatus("Delivering"));
    System.out.println(name + " is delivering pizza! "
        + orders);
  }

  /**
   * Function that changes the status of each order
   * in the list of order to 'Delivered' and prints information about the order.
   *
   * @param orders orders courier working with
   */
  private void deliveredPizzaInfo(List<Order> orders) {
    orders.forEach(i -> i.setOrderStatus("Delivered"));
    System.out.println(name + " delivered pizza! "
        + orders);
  }
}
