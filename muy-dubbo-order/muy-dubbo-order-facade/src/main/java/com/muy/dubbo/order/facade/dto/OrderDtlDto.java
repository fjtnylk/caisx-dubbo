package com.muy.dubbo.order.facade.dto;

import java.io.Serializable;

/**
 * Created by yanglikai on 2017/10/13.
 */
public class OrderDtlDto implements Serializable {
  private String orderCode;

  private OrderDtlDto() {
  }

  public static OrderDtlDto builder() {
    return new OrderDtlDto();
  }

  public OrderDtlDto withOrderCode(String orderCode) {
    this.orderCode = orderCode;
    return this;
  }

  public OrderDtlDto build() {
    return this;
  }

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }
}
