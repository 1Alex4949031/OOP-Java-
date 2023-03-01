package Orders;

/**
 * Order class that implements the order.
 * Order is consist of status and id.
 */
public class Order{
  private String orderStatus;
  private final int orderId;

  /**
   * Order constructor.
   *
   * @param orderId id of the order
   */
  public Order(int orderId) {
    this.orderStatus = "Order " + orderId + " is received!";
    this.orderId = orderId;
  }

  /**
   * Function that returns the status of the order.
   *
   * @return status of the order
   */
  public String getOrderStatus() {
    return orderStatus;
  }

  /**
   * Functions that changes the status of the order.
   *
   * @param orderStatus status to set
   */
  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  /**
   * Function that returns the id of the order.
   *
   * @return id of the order
   */
  public int getOrderId() {
    return orderId;
  }


  /**
   * Override toString for order.
   *
   * @return orders with all values
   */
  @Override
  public String toString() {
    return "Order { " +
        "orderStatus = '" + orderStatus + '\'' +
        ", orderId = " + orderId +
        " }";
  }
}