package ru.nsu.seleznev.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.nsu.seleznev.a.jsonreader.JsonCook;
import ru.nsu.seleznev.a.jsonreader.JsonCourier;
import ru.nsu.seleznev.a.jsonreader.JsonValues;
import ru.nsu.seleznev.a.orders.DeliveryQueue;
import ru.nsu.seleznev.a.orders.ProductQueue;
import ru.nsu.seleznev.a.threads.Cook;
import ru.nsu.seleznev.a.threads.Courier;
import ru.nsu.seleznev.a.threads.OrderReceiving;

/**
 * Main Pizzeria class.
 * Should be setup at first.
 */
public class Pizzeria {
  private final List<Cook> cooks;
  private final List<Courier> couriers;
  private final ProductQueue orderQueue;
  private final DeliveryQueue storageQueue;

  /**
   * Pizzeria constructor for setup.
   *
   * @param values values took from Json file
   */
  public Pizzeria(JsonValues values) {
    orderQueue = new ProductQueue(values.getQueueSize());
    storageQueue = new DeliveryQueue(values.getStorageSize());
    cooks = setupCooks(values.getCooks());
    couriers = setupCouriers(values.getCouriers());
  }

  /**
   * Function that prepares all cooks.
   *
   * @param cooks cooks in the cook
   * @return list of prepared cooks
   */
  private List<Cook> setupCooks(List<JsonCook> cooks) {
    List<Cook> values = new ArrayList<>();
    cooks.forEach(i -> values.add(new Cook(i.getName(),
        i.getExperience(), orderQueue, storageQueue)));
    return values;
  }

  /**
   * Function that prepares all couriers.
   *
   * @param couriers couriers in the delivery
   * @return list of prepared couriers
   */
  private List<Courier> setupCouriers(List<JsonCourier> couriers) {
    List<Courier> values = new ArrayList<>();
    couriers.forEach(i -> values.add(new Courier(i.getName(),
        i.getDeliveryExperience(), i.getDeliverySize(), storageQueue)));
    return values;
  }

  /**
   * Function that runs the pizzeria for fixed time.
   *
   * @param time time pizzeria running
   */
  public void running(int time) {
    OrderReceiving orders = new OrderReceiving(orderQueue);
    Thread ordersToReceive = new Thread(orders, "Order");
    ordersToReceive.start();

    // Cooks start their work!
    Thread[] cooksThreads = new Thread[cooks.size()];
    for (int i = 0; i < cooks.size(); i++) {
      cooksThreads[i] = new Thread(cooks.get(i), "Cook " + i);
      cooksThreads[i].start();
    }

    // Couriers start their work!
    Thread[] couriersThreads = new Thread[couriers.size()];
    for (int i = 0; i < couriers.size(); i++) {
      couriersThreads[i] = new Thread(couriers.get(i), "Courier " + i);
      couriersThreads[i].start();
    }

    // Stopping Pizzeria
    stoppingPizzeria(time, orders, cooksThreads, couriersThreads);
  }

  /**
   * Function that closing Pizzeria.
   *
   * @param time            time needed for closing Pizzeria
   *                        (equals to time pizzeria running)
   * @param orders          receiving orders
   * @param cooksThreads    cooks threads
   * @param couriersThreads couriers threads
   */
  private void stoppingPizzeria(int time, OrderReceiving orders,
                                Thread[] cooksThreads, Thread[] couriersThreads) {
    try {
      Thread.sleep(time);
      cooks.forEach(Cook::stop);
      couriers.forEach(Courier::stop);
      Thread.sleep(time / 2);
      orders.stop();
      Thread.sleep(time / 2);
      Arrays.stream(cooksThreads).forEach(Thread::interrupt);
      Arrays.stream(couriersThreads).forEach(Thread::interrupt);
    } catch (InterruptedException e) {
      System.out.println("Кто-то находился в wait() -> Interrupted Exception");
    }
  }
}
