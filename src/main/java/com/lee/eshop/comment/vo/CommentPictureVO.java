package com.lee.eshop.comment.vo;

import com.lee.eshop.common.AbstractObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评论的晒图
 * @author s_xun_s@163.com
 */
@ApiModel(value="com-lee-eshop-comment-vo-CommentPictureVO")
@Data
@EqualsAndHashCode(callSuper=true)
public class CommentPictureVO extends AbstractObject {
    /**
    * 评论ID
    */
    @ApiModelProperty(value="评论ID")
    private Long commentInfoId;

    /**
    * 图片顺序
    */
    @ApiModelProperty(value="图片顺序")
    private Byte sequence;

    /**
    * 晒图图片
    */
    @ApiModelProperty(value="晒图图片")
    private Byte[] commentPicture;
}