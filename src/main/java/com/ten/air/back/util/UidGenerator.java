package com.ten.air.back.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 基于UUID 生成分布式全局唯一ID
 */
@Component
public class UidGenerator {

    /**
     * 生成唯一字符串ID
     */
    public String generateUid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
