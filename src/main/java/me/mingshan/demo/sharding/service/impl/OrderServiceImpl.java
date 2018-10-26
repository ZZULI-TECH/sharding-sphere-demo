package me.mingshan.demo.sharding.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import me.mingshan.demo.sharding.dao.OrderRepository;
import me.mingshan.demo.sharding.entity.Order;
import me.mingshan.demo.sharding.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Override
    public long insert(Order order) {
      orderRepository.insert(order);
      return order.getOrderId();
    }

}
