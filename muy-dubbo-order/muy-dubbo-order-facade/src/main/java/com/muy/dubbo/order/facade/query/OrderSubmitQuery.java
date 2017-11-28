package com.muy.dubbo.order.facade.query;

import java.io.Serializable;

/**
 * Created by yanglikai on 2017/10/12.
 */
public class OrderSubmitQuery implements Serializable {
  private String orderCode;

  private OrderSubmitQuery() {
  }

  public static OrderSubmitQuery builder() {
    return new OrderSubmitQuery();
  }

  public OrderSubmitQuery withOrderCode(String orderCode) {
    this.orderCode = orderCode;
    return this;
  }

  public OrderSubmitQuery build() {
    return this;
  }

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }
}
