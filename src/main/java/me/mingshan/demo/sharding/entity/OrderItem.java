package me.mingshan.demo.sharding.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
  private static final long serialVersionUID = -5852039343125155711L;

  private long orderItemId;
  private long orderId;
  private int userId;

  public long getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(long orderItemId) {
    this.orderItemId = orderItemId;
  }

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", userId=" + userId
        + "]";
  }

}
