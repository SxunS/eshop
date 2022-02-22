package com.lee.eshop.comment.vo;

import com.lee.eshop.common.AbstractObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评论聚合汇总表
 * @author s_xun_s@163.com
 */
@ApiModel(value="com-lee-eshop-comment-vo-CommentAggregate")
@Data
@EqualsAndHashCode(callSuper=true)
public class CommentAggregateVO extends AbstractObject {
    /**
    * 商品ID
    */
    @ApiModelProperty(value="商品ID")
    private Long goodsId;

    /**
    * 评论总数量
    */
    @ApiModelProperty(value="评论总数量")
    private Long totalCommentCount;

    /**
    * 好评数量
    */
    @ApiModelProperty(value="好评数量")
    private Long goodCommentCount;

    /**
    * 好评率
    */
    @ApiModelProperty(value="好评率")
    private BigDecimal goodCommentRate;

    /**
    * 晒图评论数量
    */
    @ApiModelProperty(value="晒图评论数量")
    private Long showPicturesCommentCount;

    /**
    * 中评数量
    */
    @ApiModelProperty(value="中评数量")
    private Long mediumCommentCount;

    /**
    * 差评数量
    */
    @ApiModelProperty(value="差评数量")
    private Long badCommentCount;
}