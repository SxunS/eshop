package com.lee.eshop.auth.mapper;

import com.lee.eshop.auth.po.AuthPriorityPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限管理组件 mapper 组件
 * @author s_xun_s@163.com
 */
@Mapper
public interface PriorityMapper {

    /**
     * 查询跟权限列表
     * @return 跟权限列表
     */
    @Select("select id, code, url, priority_comment, priority_type, parent_id, gmt_create, gmt_modified from auth_priority where parent_id is null ")
    List<AuthPriorityPO> listRootPriority();


    /**
     * 根据父权限id 查询 权限
     * @param parentId 父权限id
     * @return 子权限
     */
    @Select("select id, code, url, priority_comment, priority_type, parent_id, gmt_create, gmt_modified from auth_priority where parent_id = #{parentId}")
    List<AuthPriorityPO> listChildPriorities(long parentId);


    /**
     * 根据id 查询权限
     * @param id 权限id
     * @return 权限
     */
    @Select("select id, code, url, priority_comment, priority_type, parent_id, gmt_create, gmt_modified from auth_priority where id = #{id}")
    AuthPriorityPO getPriorityById(long id);

    /**
     * 查询用户本身所有权限
     * @param accountId 用户id
     * @return 权限列表
     */
    List<AuthPriorityPO> listAccountAuthorizationByAccountId(long accountId);

    /**
     * 查询用户 所拥有角色的权限集列表
     * @param accountId 用户id
     * @return 权限列表
     */
    List<AuthPriorityPO> listRoleAuthorizationByAccountId(long accountId);

}
