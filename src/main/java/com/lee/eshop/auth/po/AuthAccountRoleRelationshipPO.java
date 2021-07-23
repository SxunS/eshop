package com.lee.eshop.auth.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com-lee-eshop-auth-po-AuthAccountRoleRelationshipPO")
@Data
public class AuthAccountRoleRelationshipPO implements Serializable {
    /**
     * 主键，自增长
     */
    @ApiModelProperty(value = "主键，自增长")
    private Long id;

    /**
     * 账号的主键
     */
    @ApiModelProperty(value = "账号的主键")
    private Long accountId;

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
