package com.lee.eshop.goods.vo;

import com.lee.eshop.common.AbstractObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品属性 PO
 * @author admin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PropertyVO extends AbstractObject {

    /**
     * 属性名称
     */
    private String propertyName;

    /**
     * 属性描述
     */
    private String propertyDesc;

    /**
     * 输入类型
     */
    private Integer inputType;

    /**
     * 输入可选值
     */
    private String inputValue;

}
