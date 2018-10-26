package me.mingshan.demo.sharding.entity;

import java.io.Serializable;

public class Order implements Serializable {
  private static final long serialVersionUID = 1349717839271282280L;

  private long orderId;
  private int userId;
  private String status;

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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Order [orderId=" + orderId + ", userId=" + userId + ", status=" + status + "]";
  }

}
