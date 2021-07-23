package com.lee.eshop.goods.controller;

import com.github.pagehelper.PageInfo;
import com.lee.eshop.common.util.CopyUtil;
import com.lee.eshop.goods.dto.PropertyDTO;
import com.lee.eshop.goods.request.PropertyQuery;
import com.lee.eshop.goods.service.PropertyService;
import com.lee.eshop.goods.vo.PropertyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品属性管理模块 controller
 * @author admin
 */
@Api(tags = "商品属性管理模块")
@RestController
@RequestMapping("/commodity/property")
public class PropertyController {


    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    /**
     * 分页查询商品属性
     * @param propertyQuery 商品属性查询条件
     * @return 商品属性
     */
    @ApiOperation("分页查询商品属性")
    @GetMapping("/")
    public PageInfo<PropertyVO> listPropertiesByPage(PropertyQuery propertyQuery){
        PageInfo<PropertyDTO> propertyDTOPageInfo = propertyService.listPropertiesByPage(propertyQuery);
        return CopyUtil.pageInfoCopy(propertyDTOPageInfo,PropertyVO.class);
    }
}
