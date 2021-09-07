package com.lee.eshop.comment.dto;

import com.lee.eshop.common.AbstractObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评论的晒图
 * @author s_xun_s@163.com
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class CommentPictureDTO extends AbstractObject {
    /**
    * 评论ID
    */
    private Long commentInfoId;

    /**
    * 图片顺序
    */
    private Byte sequence;

    /**
    * 晒图图片
    */
    private Byte[] commentPicture;
}