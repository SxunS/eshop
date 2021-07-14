package com.lee.eshop.purchase.dto;

import com.lee.eshop.base.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 采购单DTO
 * @author s_xun_s@163.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseOrderDTO extends BaseDTO {

    /**
     * 供应商id
     */
    private Long supplierId;

    /**
     * 预期到货时间
     */
    private LocalDateTime exceptArrivalTime;

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
     * 采购单备注
     */
    private String purchaseOrderComment;

    /**
     * 采购员
     */
    private String purchaser;

    /**
     * 采购库单状态
     */
    private Integer purchaseOrderStatus;

}
