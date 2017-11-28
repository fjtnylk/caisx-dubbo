package com.muy.dubbo.order.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.dubbo.order.entity.OrderDo;

/**
 * Created by yanglikai on 2017/10/13.
 */
public interface IOrderRepository<T> extends IService<T> {

  OrderDo query(String orderCode);
}
