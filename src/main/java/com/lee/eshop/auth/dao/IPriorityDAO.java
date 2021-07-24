package com.lee.eshop.auth.dao;

import com.lee.eshop.auth.po.AuthPriorityPO;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 根据父权限id 查询 权限
     * @param parentId 父权限id
     * @return 子权限
     */
    List<AuthPriorityPO> listChildPriorities(long parentId);


    /**
     * 根据id 查询权限
     * @param id 权限id
     * @return 权限
     */
    AuthPriorityPO getPriorityById(long id);

    /**
     * 查询用户 所拥有角色的权限集列表以及用户本身所有权限并集
     * @param accountId 用户id
     * @return 权限列表
     */
    List<AuthPriorityPO> listAuthorizationByAccountId(long accountId);


    /**
     * 新建权限
     * @param authPriorityPO 权限PO
     */
    void savePriority(AuthPriorityPO authPriorityPO);


    /**
     * 更新权限
     * @param authPriorityPO 权限PO
     *
     */
    void updatePriority(AuthPriorityPO authPriorityPO);

    /**
     * 根据id 删除权限
     * @param id 权限id
     */
    void deletePriorityById(Long id);
}
