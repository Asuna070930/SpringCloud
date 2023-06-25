package com.atguigu.order.pojo;


import java.io.Serializable;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/12 16:14
 */
public class Order implements Serializable {
    private Long id;
    private double price;
    private String name;
    private String num;
    private String userId;
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", userId='" + userId + '\'' +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
