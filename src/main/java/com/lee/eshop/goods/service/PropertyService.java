package com.lee.eshop.goods.service;

import com.github.pagehelper.PageInfo;
import com.lee.eshop.goods.dto.PropertyDTO;
import com.lee.eshop.goods.request.PropertyQuery;

/**
 * 商品属性管理模块 service接口
 * @author admin
 */
public interface PropertyService {


    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 当前页商品属性
     */
    PageInfo<PropertyDTO> listPropertiesByPage(PropertyQuery propertyQuery);


}
