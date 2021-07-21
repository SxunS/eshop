package com.lee.eshop.auth.service;

import com.lee.eshop.auth.dto.AuthPriorityDTO;
import com.lee.eshop.auth.po.AuthPriorityPO;

import java.util.List;

/**
 * 权限管理模块 service 接口
 * @author s_xun_s@163.com
 */
public interface IPriorityService {


    /**
     * 查询跟权限列表
     * @return 跟权限列表
     */
    List<AuthPriorityDTO> listRootPriority();

}
