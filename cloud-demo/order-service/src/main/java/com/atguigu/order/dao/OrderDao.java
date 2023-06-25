package com.atguigu.order.dao;

import com.atguigu.order.pojo.Order;
import org.apache.ibatis.annotations.Select;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 16:26
 */
public interface OrderDao {
    @Select("select * from tb_order where id=#{id}")
    Order queryOrderById(Long orderId);
}
