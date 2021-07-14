package com.lee.eshop.promotion.dto;

import com.lee.eshop.base.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 促销活动 DTO
 * @author s_xun_s@163.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PromotionActivityDTO extends BaseDTO {

    /**
     * 促销活动名称
     */
    private String promotionActivityName;

    /**
     * 促销活动开始时间
     */
    private LocalDateTime promotionActivityStartTime;

    /**
     * 促销活动结束时间
     */
    private LocalDateTime promotionActivityEndTime;

    /**
     * 促销活动备注
     */
    private String promotionActivityComment;

    /**
     * 促销活动状态
     */
    private Integer promotionActivityStatus;

    /**
     * 促销活动规则
     */
    private String promotionActivityRule;

}
