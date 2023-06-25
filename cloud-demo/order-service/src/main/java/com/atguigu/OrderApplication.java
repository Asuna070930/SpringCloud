package com.atguigu;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 16:10
 */
@SpringBootApplication
@MapperScan("com.atguigu.order.dao")
@EnableDiscoveryClient
@EnableCircuitBreaker //开启熔断器
@EnableFeignClients(basePackages = "com.atguigu.order.feign") //开启feign客户端
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建一个对象
     * 是一个远程调用的客户端,在查询订单的时候,需要把用户查询出来,所以需要实现远程调用
     */
    //轮询
    @Bean
    @LoadBalanced //表示负载均衡 默认使用的是轮询
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    //随机
    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }
}
