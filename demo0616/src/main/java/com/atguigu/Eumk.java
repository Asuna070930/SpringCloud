package com.atguigu;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/16 20:43
 */


import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * ①举值定义
 * ②构造
 * ③遍历
 *
 * 举值-构造-遍历
 */
public enum Eumk {
    //1.举值
    SPRING("chun", "春"),
    SUMMER("xia", "夏"),
    AUTUMN("qiu", "秋"),
    WINTER("dong", "冬");

    //2.构造
    @Getter
    String key;
    @Getter
    String message;

    Eumk(String t1, String t2) {
        this.key = t1;
        this.message = t2;
    }

    //3.1遍历
    public static Eumk getEnum(String code) {
        Eumk[] values = Eumk.values();
        for (Eumk element : values) {
            if (element.getKey().equalsIgnoreCase(code)) {
                return element;
            }
        }
        return null;
    }

    //3.2遍历



    public static void main(String[] args) {
        Eumk session = getEnum("xia");
        System.out.println(session.getKey());
        System.out.println(session.getMessage());
    }
}
