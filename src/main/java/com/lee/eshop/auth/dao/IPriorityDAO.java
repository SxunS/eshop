package com.lee.eshop.auth.dao;

import com.lee.eshop.auth.po.AuthPriorityPO;

import java.util.List;

/**
 * 权限管理模块DAO
 * @author s_xun_s@163.com
 */
public interface IPriorityDAO {


    /**
     * 查询跟权限列表
     * @return 跟权限列表
     */
    List<AuthPriorityPO> listRootPriority();

}
