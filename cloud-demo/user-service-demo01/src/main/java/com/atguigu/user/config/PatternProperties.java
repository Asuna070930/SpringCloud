package com.atguigu.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/14 14:44
 */
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties implements Serializable {
    // 这个配置属于是独有的，个性的，只能让
    private String dateformat;
    // 这个属性是共享的，所有的环境都可以读取，开发环境，测试环境，上线环境
    private String envSharedValue;

    @Override
    public String toString() {
        return "PatternProperties{" +
                "dateformat='" + dateformat + '\'' +
                ", envSharedValue='" + envSharedValue + '\'' +
                '}';
    }

    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }

    public String getEnvSharedValue() {
        return envSharedValue;
    }

    public void setEnvSharedValue(String envSharedValue) {
        this.envSharedValue = envSharedValue;
    }
}
