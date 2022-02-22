package com.lee.eshop.order.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.lee.eshop.base.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author s_xun_s@163.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderItemDTO extends BaseDTO {

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 商品spu ID
     */
    private Long goodsId;

    /**
     * 商品sku ID
     */
    private Long goodsSkuId;

    /**
     * 商品sku编号
     */
    private String goodsSkuCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 销售属性，机身颜色:白色,内存容量:256G
     */
    private String saleProperties;

    /**
     * 商品毛重
     */
    private BigDecimal goodsGrossWeight;

    /**
     * 购买数量
     */
    private Long purchaseQuantity;

    /**
     * 商品购买价格
     */
    private BigDecimal purchasePrice;

    /**
     * 促销活动ID
     */
    private Long promotionActivityId;

    /**
     * 商品长度
     */
    private BigDecimal goodsLength;

    /**
     * 商品宽度
     */
    private BigDecimal goodsWidth;

    /**
     * 商品高度
     */
    private BigDecimal goodsHeight;

}

