package com.lee.eshop.goods.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.eshop.goods.dao.PropertyDAO;
import com.lee.eshop.goods.mapper.PropertyMapper;
import com.lee.eshop.goods.po.PropertyPO;
import com.lee.eshop.goods.request.PropertyQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品属性DAO实现
 * @author admin
 */
@Repository
public class PropertyDAOImpl implements PropertyDAO {

    private static final Logger logger = LoggerFactory.getLogger(PropertyDAOImpl.class);

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

    @Override
    public PropertyPO getPropertyById(long id) {
        return propertyMapper.getPropertyById(id);
    }

    @Override
    public boolean saveProperty(PropertyPO propertyPO) {
        try {
            propertyMapper.saveProperty(propertyPO);
        } catch (Exception e) {
            logger.error("Failed to save property:[{}]",propertyPO,e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateProperty(PropertyPO propertyPO) {
        try {
            propertyMapper.updateProperty(propertyPO);
        } catch (Exception e) {
            logger.error("Failed to update property [{}]",propertyPO,e);
            return false;
        }
        return true;
    }

    @Override
    public void deleteProperty(long id) {
        propertyMapper.deleteProperty(id, LocalDateTime.now());
    }
}
