package me.mingshan.demo.sharding.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import me.mingshan.demo.sharding.dao.OrderItemRepository;
import me.mingshan.demo.sharding.entity.OrderItem;
import me.mingshan.demo.sharding.service.OrderItemService;

@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {

    @Resource
    private OrderItemRepository itemRepository;

    @Override
    public long insert(OrderItem orderItem) {
      itemRepository.insert(orderItem);
      return orderItem.getOrderItemId();
    }

}
