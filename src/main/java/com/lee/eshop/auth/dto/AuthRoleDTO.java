package com.lee.eshop.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com-lee-eshop-auth-po-AuthRolePO")
@Data
public class AuthRoleDTO implements Serializable {
    /**
     * 主键，自增长
     */
    @ApiModelProperty(value = "主键，自增长")
    private Long id;

    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色编号")
    private String code;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 角色的说明备注
     */
    @ApiModelProperty(value = "角色的说明备注")
    private String roleComment;

    /**
     * 角色是否启用，1：启用，0：未启用
     */
    @ApiModelProperty(value = "角色是否启用，1：启用，0：未启用")
    private Byte isEnabled;

    /**
     * 角色的创建时间
     */
    @ApiModelProperty(value = "角色的创建时间")
    private Date gmtCreate;

    /**
     * 角色的修改时间
     */
    @ApiModelProperty(value = "角色的修改时间")
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}
