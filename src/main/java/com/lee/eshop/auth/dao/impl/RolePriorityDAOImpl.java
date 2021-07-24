package com.lee.eshop.auth.dao.impl;

import com.lee.eshop.auth.dao.RolePriorityDAO;
import com.lee.eshop.auth.mapper.RolePriorityMapper;
import com.lee.eshop.auth.po.AuthRolePriorityRelationshipPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色权限对应关系 DAO 实现
 * @author s_xun_s@163.com
 */
@Repository
public class RolePriorityDAOImpl implements RolePriorityDAO {

    private final RolePriorityMapper rolePriorityMapper;

    public RolePriorityDAOImpl(RolePriorityMapper rolePriorityMapper) {
        this.rolePriorityMapper = rolePriorityMapper;
    }

    @Override
    public List<AuthRolePriorityRelationshipPO> listRolePriorityRelationByPriorityId(long priorityId) {
        return rolePriorityMapper.listRolePriorityRelationByPriorityId(priorityId);
    }

    @Override
    public void deleteRolePriorityByPriorityId(long priorityId) {
        rolePriorityMapper.deleteRolePriorityByPriorityId(priorityId);
    }
}
