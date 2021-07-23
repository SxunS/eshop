package com.lee.eshop.goods.service.impl;

import com.github.pagehelper.PageInfo;
import com.lee.eshop.common.util.CopyUtil;
import com.lee.eshop.goods.dao.PropertyDAO;
import com.lee.eshop.goods.dto.PropertyDTO;
import com.lee.eshop.goods.po.PropertyPO;
import com.lee.eshop.goods.request.PropertyQuery;
import com.lee.eshop.goods.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 商品属性管理模块 service
 * @author admin
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyDAO propertyDAO;

    public PropertyServiceImpl(PropertyDAO propertyDAO) {
        this.propertyDAO = propertyDAO;
    }

    @Override
    public PageInfo<PropertyDTO> listPropertiesByPage(PropertyQuery propertyQuery) {
        PageInfo<PropertyPO> propertyPOPageInfo = propertyDAO.listPropertiesByPage(propertyQuery);
        return CopyUtil.pageInfoCopy(propertyPOPageInfo,PropertyDTO.class);
    }
}