package com.lee.eshop.goods.mapper;

import com.lee.eshop.goods.po.PropertyPO;
import com.lee.eshop.goods.request.PropertyQuery;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品属性管理 的mapper 组件
 * @author admin
 */
@Mapper
public interface PropertyMapper {

    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 当前页商品属性
     */
    List<PropertyPO> listPropertiesByPage(PropertyQuery propertyQuery);

    /**
     * 根据id查询商品属性
     * @param id 属性id
     * @return 商品属性
     */
    PropertyPO getPropertyById(long id);

    /**
     * 新建商品属性
     * @param propertyPO 商品属性
     */
    void saveProperty(PropertyPO propertyPO);

    /**
     * 更新商品属性
     * @param propertyPO 商品属性
     */
    void updateProperty(PropertyPO propertyPO);

    /**
     * 删除商品属性
     * @param id 商品属性id
     * @param deleteTime 删除时间
     */
    void deleteProperty(long id, LocalDateTime deleteTime);
}
