package com.muy.dubbo.order.facade.dto;

import java.io.Serializable;

/**
 * Created by yanglikai on 2017/10/12.
 */
public class OrderSubmitDto implements Serializable {
  private String orderCode;

  private OrderSubmitDto() {
  }

  public static OrderSubmitDto builder() {
    return new OrderSubmitDto();
  }

  public OrderSubmitDto withOrderCode(String orderCode) {
    this.orderCode = orderCode;
    return this;
  }

  public OrderSubmitDto build() {
    return this;
  }

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }
}
