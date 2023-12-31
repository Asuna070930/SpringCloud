package com.atguigu.service;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/13 14:16
 */
@Service
public class PaymentService{
    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id)
    {
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "+id+"\t"+"O(∩_∩)O哈哈~";
    }


    public String paymentInfo_TimeOut(Integer id)
    {
        //int age = 10/0;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  "+Thread.currentThread().getName()+" id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): ";
    }
}
