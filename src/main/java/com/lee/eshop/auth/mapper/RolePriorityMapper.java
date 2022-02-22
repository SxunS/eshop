package com.lee.eshop.auth.mapper;

import com.lee.eshop.auth.po.AuthRolePriorityRelationshipPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色 权限 映射关系 mapper
 * @author s_xun_s@163.com
 */
@Mapper
public interface RolePriorityMapper {

    /**
     * 根据权限id 查询角色权限关系
     * @param priorityId 权限id
     * @return 角色权限对应关系集合
     */
    List<AuthRolePriorityRelationshipPO> listRolePriorityRelationByPriorityId(long priorityId);


    /**
     * 根据权限id 删除角色权限关系
     * @param priorityId 权限id
     */
    void deleteRolePriorityByPriorityId(long priorityId);
}
