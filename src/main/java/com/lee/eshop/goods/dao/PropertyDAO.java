package com.lee.eshop.goods.dao;

import com.github.pagehelper.PageInfo;
import com.lee.eshop.goods.dto.PropertyDTO;
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

    /**
     * 根据id查询商品属性
     * @param id 属性id
     * @return 商品属性
     */
    PropertyPO getPropertyById(long id);

    /**
     * 创建商品属性
     * @param propertyPO 商品属性
     * @return 处理结果
     */
    boolean saveProperty(PropertyPO propertyPO);


    /**
     * 更新商品属性
     * @param propertyPO 商品属性
     * @return 处理结果
     */
    boolean updateProperty(PropertyPO propertyPO);
}
