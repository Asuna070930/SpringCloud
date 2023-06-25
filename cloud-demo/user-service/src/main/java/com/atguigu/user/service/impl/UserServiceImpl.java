package com.atguigu.user.service.impl;

import com.atguigu.user.dao.UserDao;
import com.atguigu.user.pojo.User;
import com.atguigu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 15:18
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User queryById(Long id, HttpServletRequest request) {
        //获取服务器端口 18081
        int serverPort = request.getServerPort();
        User user = userDao.queryById(id);
        //获取到端口号之后,设置到名字黎曼
        user.setUsername(serverPort + user.getUsername());
        return user;
    }
}
