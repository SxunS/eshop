package com.lee.eshop.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author s_xun_s@163.com
 */
@ApiModel(value = "com-lee-eshop-auth-po-AuthAccountPO")
@Data
public class AuthAccountVO implements Serializable {
    /**
     * 主键，自增长
     */
    @ApiModelProperty(value = "主键，自增长")
    private Long id;

    /**
     * 用户名，英文
     */
    @ApiModelProperty(value = "用户名，英文")
    private String username;

    /**
     * 账号的密码
     */
    @ApiModelProperty(value = "账号的密码")
    private Byte password;

    /**
     * 姓名，中文
     */
    @ApiModelProperty(value = "姓名，中文")
    private String employeeName;

    /**
     * 账号的说明备注
     */
    @ApiModelProperty(value = "账号的说明备注")
    private String accountComment;

    /**
     * 账号是否启用，1：启用，0：未启用
     */
    @ApiModelProperty(value = "账号是否启用，1：启用，0：未启用")
    private Byte isEnabled;

    /**
     * 账号的创建时间
     */
    @ApiModelProperty(value = "账号的创建时间")
    private LocalDateTime gmtCreate;

    /**
     * 账号的更新时间
     */
    @ApiModelProperty(value = "账号的更新时间")
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}
