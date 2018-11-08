package me.mingshan.demo.sharding.controller;

import javax.annotation.Resource;

import me.mingshan.demo.sharding.entity.User;
import me.mingshan.demo.sharding.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import me.mingshan.demo.sharding.entity.Order;
import me.mingshan.demo.sharding.service.OrderItemService;
import me.mingshan.demo.sharding.service.OrderService;

@RestController
@RequestMapping(value = "/demo")
public class ShardingDemoController {

    private static final Logger logger = LoggerFactory.getLogger(ShardingDemoController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void demo(@RequestParam("userId") Integer userId) {
        DefaultKeyGenerator key = new DefaultKeyGenerator();
        Number orderIdKey = key.generateKey();
        Long orderId = orderIdKey.longValue();
        logger.info("分布式主键orderId:" + orderId);

        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setStatus("1");

        orderService.insert(order);
        logger.info("插入成功后的returnOrderId:" + order.getOrderId());
        
//        OrderItem item = new OrderItem();
//        item.setOrderId(orderId);
//        item.setUserId(userId);
//        Long returnOrderItemId = orderItemService.insert(item);
//        logger.info("插入成功后的returnOrderItemId:" + returnOrderItemId);
    }


    /**
     * 测试
     */
    @RequestMapping("/user")
    public void user() {
        DefaultKeyGenerator key = new DefaultKeyGenerator();
        Number userIdKey = key.generateKey();
        Long userId = userIdKey.longValue();
        logger.info("分布式主键userId:" + userId);
        User user = new User();
        user.setId(userId);
        user.setName("AAAA");
        userService.insert(user);
    }


    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }


}
