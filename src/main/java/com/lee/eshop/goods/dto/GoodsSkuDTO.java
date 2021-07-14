package com.lee.eshop.goods.dto;

import com.lee.eshop.base.dto.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品sku DTO
 * @author s_xun_s@163.com
 */
@Data
public class GoodsSkuDTO extends BaseDTO {

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品sku编号
     */
    private String goodsSkuCode;


    /**
     * 采购价格
     */
    private BigDecimal purchasePrice;

    /**
     * 销售价格
     */
    private BigDecimal salePrice;

    /**
     * 折扣价格
     */
    private BigDecimal discountPrice;



}
