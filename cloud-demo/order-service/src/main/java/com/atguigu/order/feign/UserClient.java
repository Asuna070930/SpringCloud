package com.atguigu.order.feign;

import com.atguigu.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/14 16:26
 */

/**
 * feign的客户端只能是接口
 *
 * @FeignClient : 表示远程调用客户端
 * 根据微服务的名称可以找到对应的微服务
 */
@FeignClient(value = "userservice")
public interface UserClient {
    @RequestMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
