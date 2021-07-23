package com.lee.eshop.goods.request;

import lombok.Data;

/**
 * 商品属性查询条件
 * @author admin
 */
@Data
public class PropertyQuery {


    /**
     * 查询页码
     */
    private Integer pageNo;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 属性名称
     */
    private String propertyName;

}
