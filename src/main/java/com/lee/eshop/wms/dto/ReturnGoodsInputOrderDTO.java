package com.lee.eshop.wms.dto;

import com.lee.eshop.base.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 退货入库单
 * @author s_xun_s@163.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReturnGoodsInputOrderDTO extends BaseDTO {


    /**
     * 用户账号id
     */
    private Long userAccountId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 退货入库单状态
     */
    private Integer returnGoodsInputOrderStatus;

    /**
     * 退货原因
     */
    private String returnGoodsReason;

    /**
     * 退货备注
     */
    private String returnGoodsComment;

    /**
     * 退货实际到货时间
     */
    private LocalDateTime arrivalTime;

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


}
