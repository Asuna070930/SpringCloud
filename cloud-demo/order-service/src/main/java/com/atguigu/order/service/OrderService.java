package com.atguigu.order.service;

import com.atguigu.order.pojo.Order;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 16:20
 */
public interface OrderService {
    Order queryOrderById(Long orderId);
}
