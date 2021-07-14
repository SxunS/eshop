package com.lee.eshop.wms.dto;

import com.lee.eshop.base.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 销售出库单
 * @author s_xun_s@163.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SaleDeliveryOrderDTO extends BaseDTO {

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 用户账号id
     */
    private Long userAccountId;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货地址
     */
    private String deliveryAddress;

    /**
     * 收货人联系电话
     */
    private String consigneeCellPhoneNumber;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 支付方式
     */
    private Byte payType;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;

    /**
     * 红包金额
     */
    private BigDecimal couponAmount;

    /**
     * 实际支付金额
     */
    private BigDecimal payableAmount;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     *  纳税人识别号
     */
    private String taxpayerId;

    /**
     * 订单备注
     */
    private String orderComment;

    /**
     * 销售出库单状态
     */
    private Integer saleDeliveryOrderStatus;

    /**
     * 销售时间
     */
    private LocalDateTime deliveryTime;



















}
