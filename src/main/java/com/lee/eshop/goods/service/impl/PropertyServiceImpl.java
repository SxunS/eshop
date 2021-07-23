package com.lee.eshop.goods.service.impl;

import com.github.pagehelper.PageInfo;
import com.lee.eshop.common.util.CopyUtil;
import com.lee.eshop.goods.dao.PropertyDAO;
import com.lee.eshop.goods.dto.PropertyDTO;
import com.lee.eshop.goods.po.PropertyPO;
import com.lee.eshop.goods.request.PropertyQuery;
import com.lee.eshop.goods.service.PropertyService;
import com.lee.eshop.goods.vo.PropertyVO;
import org.springframework.stereotype.Service;

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

    @Override
    public PropertyDTO getPropertyById(long id) {
        PropertyPO propertyPO = propertyDAO.getPropertyById(id);
        return propertyPO.clone(PropertyDTO.class);
    }

    @Override
    public boolean saveProperty(PropertyDTO propertyDTO) {
        PropertyPO propertyPO = propertyDTO.clone(PropertyPO.class);
        return propertyDAO.saveProperty(propertyPO);
    }

    @Override
    public boolean updateProperty(PropertyDTO propertyDTO) {
        PropertyPO propertyPO = propertyDTO.clone(PropertyPO.class);
        return propertyDAO.updateProperty(propertyPO);
    }
}
