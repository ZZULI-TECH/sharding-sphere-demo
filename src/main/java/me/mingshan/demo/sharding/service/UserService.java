package me.mingshan.demo.sharding.service;

import me.mingshan.demo.sharding.entity.User;

public interface UserService {
    long insert(User user);

    User findById(Long id);

}
