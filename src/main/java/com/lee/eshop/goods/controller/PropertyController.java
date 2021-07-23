package com.lee.eshop.goods.controller;

import com.github.pagehelper.PageInfo;
import com.lee.eshop.common.result.CommonResult;
import com.lee.eshop.common.util.CopyUtil;
import com.lee.eshop.goods.dto.PropertyDTO;
import com.lee.eshop.goods.request.PropertyQuery;
import com.lee.eshop.goods.service.PropertyService;
import com.lee.eshop.goods.vo.PropertyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 商品属性管理模块 controller
 * @author admin
 */
@Api(tags = "商品属性管理模块")
@RestController
@RequestMapping("/commodity/property")
public class PropertyController {


    /**
     * 商品管理模块service组件
     */
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

    /**
     * 根据id查询商品属性
     * @param id 属性id
     * @return 商品属性
     */
    @GetMapping("/{id}")
    public CommonResult<PropertyVO> getPropertyById(@PathVariable long id){
        PropertyDTO propertyDTO = propertyService.getPropertyById(id);
        PropertyVO clone = propertyDTO.clone(PropertyVO.class);
        return CommonResult.sucess(clone);
    }

    /**
     * 创建商品属性
     * @param propertyVO 商品属性
     * @return 处理结果
     */
    @PostMapping("/")
    public CommonResult<Object> saveProperty(PropertyVO propertyVO){
        PropertyDTO clone = propertyVO.clone(PropertyDTO.class);
        boolean success = propertyService.saveProperty(clone);
        return success ? CommonResult.sucess(null) :CommonResult.failed(null);
    }


    /**
     * 更新商品属性
     * @param propertyVO 商品属性
     * @return 处理结果
     */
    @PutMapping("/")
    public CommonResult<Object> updateProperty(PropertyVO propertyVO){
        PropertyDTO clone = propertyVO.clone(PropertyDTO.class);
        boolean success = propertyService.updateProperty(clone);
        return success ? CommonResult.sucess(null) :CommonResult.failed(null);
    }



}
