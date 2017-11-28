package com.muy.dubbo.order.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.dubbo.order.entity.OrderDo;
import com.muy.dubbo.order.mapper.OrderMapper;
import com.muy.dubbo.order.repository.IOrderRepository;
import com.muy.system.datasource.annotation.DbMsEnum;
import com.muy.system.datasource.annotation.SwitchDs;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/10/13.
 */
@Repository
public class OrderRepository
    extends ServiceImpl<OrderMapper, OrderDo> implements IOrderRepository<OrderDo> {
  @Resource
  private OrderMapper orderMapper;

  @SwitchDs(ms = DbMsEnum.SLAVE)
  @Override
  public OrderDo query(String orderCode) {
    Wrapper<OrderDo> wrapper = new EntityWrapper<>();
    wrapper.where("order_id={0}", orderCode);
    return super.selectOne(wrapper);
  }
}
