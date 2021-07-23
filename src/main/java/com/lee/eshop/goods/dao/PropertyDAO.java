package com.lee.eshop.goods.dao;

import com.github.pagehelper.PageInfo;
import com.lee.eshop.goods.po.PropertyPO;
import com.lee.eshop.goods.request.PropertyQuery;

/**
 * 商品属性 DAO
 * @author admin
 */
public interface PropertyDAO {


    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 当前页商品属性
     */
    PageInfo<PropertyPO> listPropertiesByPage(PropertyQuery propertyQuery);

}
