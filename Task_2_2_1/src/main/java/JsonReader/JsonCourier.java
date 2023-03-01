package JsonReader;

import java.util.Objects;

/**
 * JsonCourier class for correct parsing of Couriers from Json.
 */
public class JsonCourier {
  public final String name;
  public final int deliveryExperience;
  public final int deliverySize;

  /**
   * JsonCourier constructor for Courier.
   *
   * @param name               name of the Courier
   * @param deliveryExperience delivering experience of the Courier
   * @param deliverySize       size of the trunk of the Courier
   */
  public JsonCourier(String name, int deliveryExperience, int deliverySize) {
    this.name = name;
    this.deliveryExperience = deliveryExperience;
    this.deliverySize = deliverySize;
  }

  /**
   * Function that returns the name of the Courier.
   *
   * @return name of the Courier
   */
  public String getName() {
    return name;
  }

  /**
   * Function that returns the delivery time of the Courier.
   *
   * @return delivery time of the Courier
   */
  public int getDeliveryExperience() {
    return deliveryExperience;
  }

  /**
   * Function that returns the trunk size of the Courier.
   *
   * @return trunk size of the Courier
   */
  public int getDeliverySize() {
    return deliverySize;
  }

  /**
   * Equals function that compares JsonCouriers objects.
   *
   * @param o object need to compare with
   * @return true if equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JsonCourier that = (JsonCourier) o;
    return deliveryExperience == that.deliveryExperience
        && deliverySize == that.deliverySize
        && Objects.equals(name, that.name);
  }

  /**
   * Function that counts hash of the object.
   *
   * @return hash of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, deliveryExperience, deliverySize);
  }
}
