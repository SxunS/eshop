package com.lee.eshop.auth.service.impl;

import com.lee.eshop.auth.dao.AccountPriorityDAO;
import com.lee.eshop.auth.dao.IPriorityDAO;
import com.lee.eshop.auth.dao.RolePriorityDAO;
import com.lee.eshop.auth.dto.AuthPriorityDTO;
import com.lee.eshop.auth.po.AuthAccountPriorityRelationshipPO;
import com.lee.eshop.auth.po.AuthPriorityPO;
import com.lee.eshop.auth.po.AuthRolePriorityRelationshipPO;
import com.lee.eshop.auth.service.PriorityOperator;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 检查权限是否可删除的 观察者
 * @author s_xun_s@163.com
 */
@Repository
public class PriorityDelCheckOperatorImpl implements PriorityOperator {

    /**
     * 权限操作DAO
     */
    private final IPriorityDAO priorityDAO;

    private final AccountPriorityDAO accountPriorityDAO;

    private final RolePriorityDAO rolePriorityDAO;

    private boolean canDel = true;

    public PriorityDelCheckOperatorImpl(IPriorityDAO priorityDAO, AccountPriorityDAO accountPriorityDAO, RolePriorityDAO rolePriorityDAO) {
        this.priorityDAO = priorityDAO;
        this.accountPriorityDAO = accountPriorityDAO;
        this.rolePriorityDAO = rolePriorityDAO;
    }


    @Override
    public void execute(AuthPriority authPriority) {

        //检查当前权限是否可删除  当前节点不可删除，直接返回
        boolean currentCanDel = canDelCheck(authPriority);
        if (!currentCanDel) {
            canDel = false;
            return;
        }

        //获取所有子权限 查看子权限是否可删除
        List<AuthPriorityPO> authPriorityPOs = priorityDAO.listChildPriorities(authPriority.getId());

        for (AuthPriorityPO authPriorityPO : authPriorityPOs) {
            AuthPriority clone = authPriorityPO.clone(AuthPriority.class);
            clone.accept(this);
            if (!canDel) {
                break;
            }
        }

    }

    private boolean canDelCheck(AuthPriority authPriority) {

        List<AuthAccountPriorityRelationshipPO> authAccountPriorityRelationshipPOs = accountPriorityDAO.listAccountPriorityRelationByPriorityId(authPriority.getId());
        if (null == authAccountPriorityRelationshipPOs || authAccountPriorityRelationshipPOs.size() == 0) {
            return false;
        }

        List<AuthRolePriorityRelationshipPO> authRolePriorityRelationshipPOs = rolePriorityDAO.listRolePriorityRelationByPriorityId(authPriority.getId());
        if (null == authRolePriorityRelationshipPOs || authRolePriorityRelationshipPOs.size() == 0){
            return false;
        }

        return true;

    }

    public boolean canDel() {
        return canDel;
    }
}
