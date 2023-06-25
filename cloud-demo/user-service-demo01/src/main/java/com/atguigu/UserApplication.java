package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 14:37
 */
@SpringBootApplication
@MapperScan("com.atguigu.user.dao")
@EnableDiscoveryClient //标记当前应用程序是一个客户端
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
