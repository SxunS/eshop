package com.lee.eshop.goods.mapper;

import com.lee.eshop.goods.po.PropertyPO;
import com.lee.eshop.goods.request.PropertyQuery;
import org.apache.ibatis.annotations.Mapper;

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

}
