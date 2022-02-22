package com.lee.eshop.auth.dao.impl;

import com.lee.eshop.auth.dao.AccountPriorityDAO;
import com.lee.eshop.auth.mapper.AccountPriorityMapper;
import com.lee.eshop.auth.po.AuthAccountPriorityRelationshipPO;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 账号权限对应关系 DAO 实现
 * @author s_xun_s@163.com
 */
@Repository
public class AccountPriorityDAOImpl implements AccountPriorityDAO {

    private final AccountPriorityMapper accountPriorityMapper;

    public AccountPriorityDAOImpl(AccountPriorityMapper accountPriorityMapper) {
        this.accountPriorityMapper = accountPriorityMapper;
    }

    @Override
    public List<AuthAccountPriorityRelationshipPO> listAccountPriorityRelationByPriorityId(long priorityId) {
        return accountPriorityMapper.listAccountPriorityRelationByPriorityId(priorityId);
    }

    @Override
    public void deleteAccountPriorityByPriorityId(Long priorityId) {
        accountPriorityMapper.deleteAccountPriorityByPriorityId(priorityId);
    }
}
