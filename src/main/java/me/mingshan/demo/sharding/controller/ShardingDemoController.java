package me.mingshan.demo.sharding.controller;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import me.mingshan.demo.sharding.entity.Order;
import me.mingshan.demo.sharding.entity.OrderItem;
import me.mingshan.demo.sharding.service.OrderItemService;
import me.mingshan.demo.sharding.service.OrderService;

@RestController
@RequestMapping(value = "/demo")
public class ShardingDemoController {

	private static Logger logger = LogManager.getLogger();

	@Resource(name = "orderService")
	private OrderService orderService;

	@Resource(name = "orderItemService")
	private OrderItemService orderItemService;

	//注意这块没有事务控制，如果有报错，是没控制事务的
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void demo() {
//		DefaultKeyGenerator key = new DefaultKeyGenerator();
//		int userId = 45;
//		Number orderIdKey = key.generateKey();
//		Long orderId = orderIdKey.longValue();
//		logger.info("分布式主键orderId:" + orderId);
//		
		Order order = new Order();
		order.setUserId(1);
		order.setStatus("1");

		Long returnOrderId = orderService.insert(order);
		logger.info("插入成功后的returnOrderId:" + returnOrderId);
		
//		OrderItem item = new OrderItem();
//		item.setOrderId(orderId);
//		item.setUserId(userId);
//		Long returnOrderItemId = orderItemService.insert(item);
//		logger.info("插入成功后的returnOrderItemId:" + returnOrderItemId);
		
	}

}
