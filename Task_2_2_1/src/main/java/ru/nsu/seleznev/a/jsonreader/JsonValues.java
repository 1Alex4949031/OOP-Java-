package ru.nsu.seleznev.a.jsonreader;

import java.util.List;
import java.util.Objects;

/**
 * JsonValues class for correct parsing values for Pizzeria from Json.
 */
public class JsonValues {
  private final List<JsonCook> cooks;
  private final List<JsonCourier> couriers;
  private final int storageSize;
  private final int queueSize;

  /**
   * JsonValues constructor for values of the Pizzeria.
   *
   * @param cooks       cooks
   * @param couriers    couriers
   * @param storageSize storage size
   * @param queueSize   queue size
   */
  public JsonValues(List<JsonCook> cooks, List<JsonCourier> couriers,
                    int storageSize, int queueSize) {
    this.cooks = cooks;
    this.couriers = couriers;
    this.storageSize = storageSize;
    this.queueSize = queueSize;
  }

  /**
   * Functions that returns the storage size.
   *
   * @return storage size
   */
  public int getStorageSize() {
    return storageSize;
  }

  /**
   * Function that returns the queue size.
   *
   * @return queue size
   */
  public int getQueueSize() {
    return queueSize;
  }


  /**
   * Function that returns the list of the cooks.
   *
   * @return list of the cooks
   */
  public List<JsonCook> getCooks() {
    return cooks;
  }

  /**
   * Function that returns the list of the couriers.
   *
   * @return list of the couriers
   */
  public List<JsonCourier> getCouriers() {
    return couriers;
  }

  /**
   * Equals function that compares JsonValues objects.
   *
   * @param o object need to compare with
   * @return true if equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonValues that = (JsonValues) o;
    return storageSize == that.storageSize
        && queueSize == that.queueSize
        && Objects.equals(cooks, that.cooks)
        && Objects.equals(couriers, that.couriers);
  }

  /**
   * Function that counts hash of the object.
   *
   * @return hash of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(cooks, couriers, storageSize, queueSize);
  }
}
