package com.lee.eshop.goods.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.eshop.goods.dao.PropertyDAO;
import com.lee.eshop.goods.mapper.PropertyMapper;
import com.lee.eshop.goods.po.PropertyPO;
import com.lee.eshop.goods.request.PropertyQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品属性DAO实现
 * @author admin
 */
@Repository
public class PropertyDAOImpl implements PropertyDAO {

    private final PropertyMapper propertyMapper;

    public PropertyDAOImpl(PropertyMapper propertyMapper) {
        this.propertyMapper = propertyMapper;
    }

    @Override
    public PageInfo<PropertyPO> listPropertiesByPage(PropertyQuery propertyQuery) {
        PageHelper.startPage(propertyQuery.getPageNo(),propertyQuery.getPageSize());
        List<PropertyPO> propertyPOList = propertyMapper.listPropertiesByPage(propertyQuery);
        return new PageInfo<>(propertyPOList);
    }
}
