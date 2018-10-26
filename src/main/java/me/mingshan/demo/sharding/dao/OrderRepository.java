package me.mingshan.demo.sharding.dao;

import org.apache.ibatis.annotations.Mapper;

import me.mingshan.demo.sharding.entity.Order;

@Mapper
public interface OrderRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(Order model);

    void delete(Long orderId);

    void dropTable();
}
