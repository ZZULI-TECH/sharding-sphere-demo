package me.mingshan.demo.sharding.service.impl;

import me.mingshan.demo.sharding.dao.UserRepository;
import me.mingshan.demo.sharding.entity.User;
import me.mingshan.demo.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public long insert(User user) {
        userRepository.insert(user);
        return 0;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
