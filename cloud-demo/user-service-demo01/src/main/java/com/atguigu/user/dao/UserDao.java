package com.atguigu.user.dao;

import com.atguigu.user.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 15:23
 */
public interface UserDao {
    @Select("select * from tb_user where id=#{id}")
    User queryById(Long id);
}
