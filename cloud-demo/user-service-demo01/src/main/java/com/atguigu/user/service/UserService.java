package com.atguigu.user.service;

import com.atguigu.user.pojo.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 15:18
 */
public interface UserService {
    User queryById(Long id, HttpServletRequest request);
}
