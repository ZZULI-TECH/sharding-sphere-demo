package me.mingshan.demo.sharding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.mingshan.demo.sharding.entity.Order;
import me.mingshan.demo.sharding.entity.OrderItem;

@Mapper
public interface OrderItemRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(OrderItem model);

    void delete(Long orderItemId);

    void dropTable();

    List<Order> selectAll();
}
