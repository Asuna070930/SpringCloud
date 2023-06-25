package com.atguigu.order.service.impl;


import com.atguigu.order.dao.OrderDao;
import com.atguigu.order.feign.UserClient;
import com.atguigu.order.pojo.Order;
import com.atguigu.order.pojo.User;
import com.atguigu.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 16:21
 */

@Service
@DefaultProperties(defaultFallback = "fallBack") //全局熔断器,一个回调函数对应整个service中的所有方法
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;


    /**
     * 表示回调方法,
     * fallback: 方法的名字,必须和回调是方法名字保持一致
     * 方法的参数: 必须和回调方法的参数保持一致
     * 返回值必须一直
     * <p>
     * 注意:
     * ① 全局熔断器不需要配置参数
     * ② 全局熔断器,方法身上只需要添加 @HystrixCommand 注解,不需要添加回调函数,因为回调函数写道了默认里面
     *
     * @return
     */
    public Order fallback() {
        Order order = new Order();
        order.setName("一方通行");
        return order;
    }

    @Override
    @HystrixCommand //熔断器注解 回调方法
    public Order queryOrderById(Long orderId) {
        //查询本地数据库
        Order order = orderDao.queryOrderById(orderId);
//        String url = "http://localhost:18081/user/" + order.getUserId();
        //在注册中心中,USERSERVICE可以直接映射到18081 18082
//        String url = "http://userservice/user/" + order.getUserId();
        User user = userClient.findById(Long.valueOf(order.getUserId()));
        //通过远程调用获取user对象
        //第一个参数: 表示远程调用的URL
        //第二个参数: 表示返回值的类型
//        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }
}
