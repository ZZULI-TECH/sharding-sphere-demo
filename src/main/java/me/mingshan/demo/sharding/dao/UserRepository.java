package me.mingshan.demo.sharding.dao;

import me.mingshan.demo.sharding.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(User model);

    void delete(Long orderId);

    void dropTable();

    User findById(Long id);
}
