package com.lee.eshop.goods.po;

import com.lee.eshop.common.AbstractObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品类目VO
 * @author admin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryPO extends AbstractObject {

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目描述
     */
    private String categoryDesc;

    /**
     * 是否为叶子类目：
     *      1： 是
     *      0： 不是
     */
    private Boolean isLeaf;

    /**
     * 父类目id
     */
    private Long parentId;

}
