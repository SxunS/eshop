package com.lee.eshop.auth.dao.impl;

import com.lee.eshop.auth.dao.IPriorityDAO;
import com.lee.eshop.auth.mapper.PriorityMapper;
import com.lee.eshop.auth.po.AuthPriorityPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *  权限管理模块的DAO组件
 * @author s_xun_s@163.com
 */
@Repository
public class PriorityDAOImpl implements IPriorityDAO {

    private final PriorityMapper priorityMapper;

    public PriorityDAOImpl(PriorityMapper priorityMapper) {
        this.priorityMapper = priorityMapper;
    }

    /**
     * 查询跟权限
     * @return 跟权限集合
     */
    @Override
    public List<AuthPriorityPO> listRootPriority() {
        return priorityMapper.listRootPriority();
    }

    @Override
    public List<AuthPriorityPO> listChildPriorities(long parentId) {
        return priorityMapper.listChildPriorities(parentId);
    }

    @Override
    public AuthPriorityPO getPriorityById(long id) {
        return priorityMapper.getPriorityById(id);
    }

    @Override
    public List<AuthPriorityPO> listAuthorizationByAccountId(long accountId) {
        List<AuthPriorityPO> AccountAuthPriorityPOList = priorityMapper.listAccountAuthorizationByAccountId(accountId);
        List<AuthPriorityPO> RoleAuthPriorityPOList = priorityMapper.listRoleAuthorizationByAccountId(accountId);
        ArrayList<AuthPriorityPO> result = new ArrayList<>();
        result.addAll(AccountAuthPriorityPOList);
        result.addAll(RoleAuthPriorityPOList);
        return result;
    }
}
