package com.lee.eshop.base.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 通用基础字段
 * @author s_xun_s@163.com
 */
@Data
public abstract class BaseDTO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
