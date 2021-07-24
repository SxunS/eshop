package com.lee.eshop.auth.dao;

import com.lee.eshop.auth.po.AuthAccountPriorityRelationshipPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 账号 权限对应关系 DAO
 * @author s_xun_s@163.com
 */
@Mapper
public interface AccountPriorityDAO {

    /**
     * 根据权限id 查询账号权限对应关系
     * @param priorityId 权限id
     * @return 账号权限对应关系
     */
    List<AuthAccountPriorityRelationshipPO> listAccountPriorityRelationByPriorityId(long priorityId);

    /**
     * 根据权限id 删除账号权限对应关系
     * @param priorityId 权限id
     */
    void deleteAccountPriorityByPriorityId(Long priorityId);
}
