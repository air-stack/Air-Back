package com.ten.air.back.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class TimeGenerator {

    /**
     * 获取当前日期时间的字符串形式
     */
    public String currentTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp);
    }

}
