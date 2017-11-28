package com.muy.dubbo.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.muy.dubbo.order.entity.OrderDo;
import com.muy.dubbo.order.facade.OrderService;
import com.muy.dubbo.order.facade.dto.OrderDtlDto;
import com.muy.dubbo.order.facade.dto.OrderSubmitDto;
import com.muy.dubbo.order.facade.query.OrderSubmitQuery;
import com.muy.dubbo.order.repository.IOrderRepository;
import javax.annotation.Resource;

/**
 * Created by yanglikai on 2017/10/13.
 */
@Service(version = "1.0.0")
public class OrderServiceImpl implements OrderService {
  @Resource
  private IOrderRepository orderRepository;

  @Override
  public OrderSubmitDto submit(OrderSubmitQuery query) {
    OrderDo orderDo = orderRepository.query("1001");

    return OrderSubmitDto
        .builder()
        .withOrderCode("100001")
        .build();
  }

  @Override
  public OrderDtlDto loadDtl(String orderCode) {
    return OrderDtlDto
        .builder()
        .withOrderCode("10002")
        .build();
  }
}
