package com.lee.eshop.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com-lee-eshop-auth-po-AuthRolePriorityRelationshipPO")
@Data
public class AuthRolePriorityRelationshipDTO implements Serializable {
    /**
     * 主键，自增长
     */
    @ApiModelProperty(value = "主键，自增长")
    private Long id;

    /**
     * 权限的主键
     */
    @ApiModelProperty(value = "权限的主键")
    private Long priorityId;

    /**
     * 角色的主键
     */
    @ApiModelProperty(value = "角色的主键")
    private Long roleId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}
