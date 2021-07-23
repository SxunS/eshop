package com.lee.eshop.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "com-lee-eshop-auth-po-AuthPriorityPO")
public class AuthPriorityVO implements Serializable {
    /**
     * 主键，自增长
     */
    @ApiModelProperty(value = "主键，自增长")
    private Long id;

    /**
     * 权限编号
     */
    @ApiModelProperty(value = "权限编号")
    private String code;

    /**
     * 权限对应的请求URL
     */
    @ApiModelProperty(value = "权限对应的请求URL")
    private String url;

    /**
     * 权限的说明备注
     */
    @ApiModelProperty(value = "权限的说明备注")
    private String priorityComment;

    /**
     * 权限类型，1：菜单，2：其他
     */
    @ApiModelProperty(value = "权限类型，1：菜单，2：其他")
    private Byte priorityType;

    /**
     * 父权限的主键
     */
    @ApiModelProperty(value = "父权限的主键")
    private Long parentId;

    /**
     * 权限的创建时间
     */
    @ApiModelProperty(value = "权限的创建时间")
    private LocalDateTime gmtCreate;

    /**
     * 权限的修改时间
     */
    @ApiModelProperty(value = "权限的修改时间")
    private LocalDateTime gmtModified;

    private static final long serialVersionUID = 1L;

}
