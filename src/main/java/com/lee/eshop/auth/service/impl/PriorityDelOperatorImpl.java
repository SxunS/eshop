package com.lee.eshop.auth.service.impl;

import com.lee.eshop.auth.dao.AccountPriorityDAO;
import com.lee.eshop.auth.dao.IPriorityDAO;
import com.lee.eshop.auth.dao.RolePriorityDAO;
import com.lee.eshop.auth.service.PriorityOperator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * 删除权限的观察者
 * 用于处理 删除逻辑
 * @author s_xun_s@163.com
 */
@Repository
@Scope("prototype")
public class PriorityDelOperatorImpl implements PriorityOperator {


    private final IPriorityDAO priorityDAO;

    private final AccountPriorityDAO accountPriorityDAO;

    private final RolePriorityDAO rolePriorityDAO;

    public PriorityDelOperatorImpl(IPriorityDAO priorityDAO, AccountPriorityDAO accountPriorityDAO, RolePriorityDAO rolePriorityDAO) {
        this.priorityDAO = priorityDAO;
        this.accountPriorityDAO = accountPriorityDAO;
        this.rolePriorityDAO = rolePriorityDAO;
    }


    @Override
    public void execute(AuthPriority authPriority) {

        Long priorityId = authPriority.getId();

        accountPriorityDAO.deleteAccountPriorityByPriorityId(priorityId);

        rolePriorityDAO.deleteRolePriorityByPriorityId(priorityId);

        priorityDAO.deletePriorityById(priorityId);

    }
}
