package me.mingshan.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import me.mingshan.demo.sharding.entity.Order;
import me.mingshan.demo.sharding.entity.OrderItem;
import me.mingshan.demo.sharding.service.OrderItemService;
import me.mingshan.demo.sharding.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingSphereDemoApplicationTests {

  @Resource(name = "orderService")
  private OrderService orderService;

  @Resource(name = "orderItemService")
  private OrderItemService orderItemService;
  
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void test() {
	  DefaultKeyGenerator key = new DefaultKeyGenerator();
      int userId = 45;
      Number orderIdKey = key.generateKey();
      Long orderId = orderIdKey.longValue();
      System.out.println("分布式主键orderId:" + orderId);

      Order order = new Order();
      order.setUserId(userId);
      order.setStatus("1");
      order.setOrderId(orderId);

      Long returnOrderId = orderService.insert(order);
      System.out.println("插入成功后的returnOrderId:" + returnOrderId);
      
      OrderItem item = new OrderItem();
      item.setOrderId(orderId);
      item.setUserId(userId);

      Long returnOrderItemId = orderItemService.insert(item);
      System.out.println("插入成功后的returnOrderItemId:" + returnOrderItemId);
	}

}
