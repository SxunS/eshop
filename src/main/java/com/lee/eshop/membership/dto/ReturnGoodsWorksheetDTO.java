package com.lee.eshop.membership.dto;

import com.lee.eshop.base.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 退货工单DTO
 * @author s_xun_s@163.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReturnGoodsWorksheetDTO extends BaseDTO {

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 退货工单状态
     */
    private Integer returnGoodsWorksheetStatus;

    /**
     * 退货原因
     */
    private String returnGoodsReason;

    /**
     * 退货备注
     */
    private String returnGoodsComment;

    /**
     * 退货物流单号
     */
    private String returnGoodsCourierNumber;

}
