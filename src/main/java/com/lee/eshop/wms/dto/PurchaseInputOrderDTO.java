package com.lee.eshop.wms.dto;

import com.lee.eshop.base.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 *  采购入库单
 * @author s_xun_s@163.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseInputOrderDTO extends BaseDTO {


    /**
     * 供应商id
     */
    private Long supplierId;

    /**
     * 预期到达时间
     */
    private LocalDateTime expectArrivalTime;

    /**
     * 实际到达时间
     */
    private LocalDateTime arrivalTime;

    /**
     * 采购联系人
     */
    private String purchaseContactor;

    /**
     * 采购联系人电话
     */
    private String purchaseContactorPhoneNumber;

    /**
     * 采购联系人邮箱
     */
    private String purchaseContactorEmail;


    /**
     * 采购入库单备注
     */
    private String purchaseInputOrderComment;

    /**
     * 采购员
     */
    private String purchaser;

    /**
     * 采购入库单状态
     */
    private Integer purchaseInputOrderStatus;

}
