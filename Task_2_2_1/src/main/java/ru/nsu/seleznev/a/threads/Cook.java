package ru.nsu.seleznev.a.threads;

import ru.nsu.seleznev.a.orders.DeliveryQueue;
import ru.nsu.seleznev.a.orders.Order;
import ru.nsu.seleznev.a.orders.ProductQueue;

/**
 * Cook class for Cook thread implementation.
 */
public class Cook implements PizzaThreads {
  private boolean isWorking;
  private final ProductQueue ordersToCook;
  private final DeliveryQueue ordersToDelivery;
  private final int experience;
  private final String name;

  /**
   * Cook constructor.
   *
   * @param name             name of the cook
   * @param experience       experience of the cook
   * @param ordersToCook     orders for cook
   * @param ordersToDelivery prepared orders in the storage
   */
  public Cook(String name, int experience,
              ProductQueue ordersToCook, DeliveryQueue ordersToDelivery) {
    this.name = name;
    this.experience = experience;
    this.ordersToCook = ordersToCook;
    this.ordersToDelivery = ordersToDelivery;
  }

  /**
   * Function that runs the Cook thread.
   */
  @Override
  public void run() {
    isWorking = true;
    int time = 5000;
    int cookingTime = time / experience;
    while (isWorking) {
      Order order = ordersToCook.transferOrder();
      preparingPizzaInfo(order);
      workingTime(cookingTime);
      preparedPizzaInfo(order);
      ordersToDelivery.receiveOrder(order);
      inStoragePizzaInfo(order);
    }
  }

  /**
   * Function that stops the work of the Cook thread.
   */
  @Override
  public void stop() {
    isWorking = false;
    System.out.println(name + " is preparing final order!");
  }

  /**
   * Function that turns thread to sleep for fixed time.
   * It is the working time of the current cook.
   *
   * @param time time need to sleep
   */
  private void workingTime(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new RuntimeException("Exception connected with cooking pizza!");
    }
  }

  /**
   * Function that changes the status of the order to 'Preparing'
   * and prints information about the order.
   *
   * @param order order cook working with
   */
  private void preparingPizzaInfo(Order order) {
    order.setOrderStatus("Preparing");
    System.out.println(name + " is preparing pizza! "
        + " ID: " + order.getOrderId()
        + ". Status: " + order.getOrderStatus());
  }

  /**
   * Function that changes the status of the order to 'Prepared'
   * and prints information about the order.
   *
   * @param order order cook working with
   */
  private void preparedPizzaInfo(Order order) {
    order.setOrderStatus("Prepared");
    System.out.println(name + " prepared such a good pizza! ID: "
        + order.getOrderId()
        + " Status: " + order.getOrderStatus());
  }

  /**
   * Function that changes the status of the order to 'In the storage'
   * and prints information about the order.
   *
   * @param order order cook working with
   */
  private void inStoragePizzaInfo(Order order) {
    order.setOrderStatus("In the storage");
    System.out.println(name + " puts pizza in the storage! ID: "
        + order.getOrderId()
        + " Status: " + order.getOrderStatus());
  }
}
