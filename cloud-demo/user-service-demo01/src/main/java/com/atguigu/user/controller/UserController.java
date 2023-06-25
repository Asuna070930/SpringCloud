package com.atguigu.user.controller;

import com.atguigu.UserApplication;
import com.atguigu.user.config.PatternProperties;
import com.atguigu.user.pojo.User;
import com.atguigu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 15:15
 */
@RestController
@RequestMapping("/user")
@RefreshScope //实时更新注解
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PatternProperties patternProperties;

    /**
     * 打印共享数据
     * @return
     */
    @RequestMapping("/prop")
    public PatternProperties prop() {
        return patternProperties;
    }

//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @GetMapping("now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }

    /**
     * 根据id进行查询
     */
    @RequestMapping("/{id}")
    public User queryById(@PathVariable("id") Long id, HttpServletRequest request) {
        //故意报错,假设服务器已经宕机
//        int a = 2 / 0;
        return userService.queryById(id, request);
    }
}
