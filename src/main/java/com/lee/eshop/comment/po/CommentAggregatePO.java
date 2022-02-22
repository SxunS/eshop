package com.lee.eshop.comment.po;

import com.lee.eshop.common.AbstractObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 评论聚合汇总表
 * @author s_xun_s@163.com
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class CommentAggregatePO extends AbstractObject {
    /**
    * 商品ID
    */
    private Long goodsId;

    /**
    * 评论总数量
    */
    private Long totalCommentCount;

    /**
    * 好评数量
    */
    private Long goodCommentCount;

    /**
    * 好评率
    */
    private BigDecimal goodCommentRate;

    /**
    * 晒图评论数量
    */
    private Long showPicturesCommentCount;

    /**
    * 中评数量
    */
    private Long mediumCommentCount;

    /**
    * 差评数量
    */
    private Long badCommentCount;
}