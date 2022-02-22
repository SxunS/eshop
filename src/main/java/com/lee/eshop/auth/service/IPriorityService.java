package com.lee.eshop.auth.service;

import com.lee.eshop.auth.dto.AuthPriorityDTO;
import com.lee.eshop.auth.po.AuthPriorityPO;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 根据父权限id 查询 权限
     * @param parentId 父权限id
     * @return 子权限
     */
    List<AuthPriorityDTO> listChildPriorities(long parentId);


    /**
     * 根据id 查询权限
     * @param id 权限id
     * @return 权限
     */
    AuthPriorityDTO getPriorityById(long id);

    /**
     * 查询用户 所拥有角色的权限集列表以及用户本身所有权限并集
     * @param accountId 用户id
     * @return 权限列表
     */
    List<AuthPriorityDTO> listAuthorizationByAccountId(long accountId);


    /**
     * 添加权限
     * @param authPriorityDTO 权限DTO
     * @return 处理结果
     */
    void savePriority(AuthPriorityDTO authPriorityDTO);


    /**
     * 更新权限
     * @param authPriorityDTO 权限DTO
     * @return 处理结果
     */
    void updatePriority(AuthPriorityDTO authPriorityDTO);
}
