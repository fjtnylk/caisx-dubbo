package com.muy.dubbo.order.facade;

import com.muy.dubbo.order.facade.dto.OrderDtlDto;
import com.muy.dubbo.order.facade.dto.OrderSubmitDto;
import com.muy.dubbo.order.facade.query.OrderSubmitQuery;

/**
 * Created by yanglikai on 2017/10/12.
 */
public interface OrderService {

  OrderSubmitDto submit(OrderSubmitQuery query);

  OrderDtlDto loadDtl(String orderCode);
}
