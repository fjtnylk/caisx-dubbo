package com.muy.consumer.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.muy.consumer.IndexService;
import com.muy.dubbo.order.facade.OrderService;
import com.muy.dubbo.order.facade.dto.OrderDtlDto;
import com.muy.dubbo.order.facade.dto.OrderSubmitDto;
import com.muy.dubbo.order.facade.query.OrderSubmitQuery;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2017/10/12.
 */
@Service
public class IndexServiceImpl implements IndexService {
  @Reference(version = "1.0.0")
  private OrderService orderService;

  @Override
  public String toMessage() {
    OrderSubmitDto dto = orderService.submit(
        OrderSubmitQuery
            .builder()
            .withOrderCode("")
            .build());
    return dto.getOrderCode();
  }

  @Override
  public String toDtl() {
    OrderDtlDto dto = orderService.loadDtl("10002");
    return dto.getOrderCode();
  }
}
