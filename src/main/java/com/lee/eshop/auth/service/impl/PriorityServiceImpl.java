package com.lee.eshop.auth.service.impl;

import com.lee.eshop.auth.dao.IPriorityDAO;
import com.lee.eshop.auth.dto.AuthPriorityDTO;
import com.lee.eshop.auth.po.AuthPriorityPO;
import com.lee.eshop.auth.service.IPriorityService;
import com.lee.eshop.common.util.CopyUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理模块 service 组件实现
 * @author s_xun_s@163.com
 */
@Service
public class PriorityServiceImpl implements IPriorityService {


    /**
     * 权限管理模块的 DAO 组件
     */
    private final IPriorityDAO priorityDAO;

    public PriorityServiceImpl(IPriorityDAO priorityDAO) {
        this.priorityDAO = priorityDAO;
    }

    @Override
    public List<AuthPriorityDTO> listRootPriority() {
        List<AuthPriorityPO> authPriorityPOList = priorityDAO.listRootPriority();
        List<AuthPriorityDTO> authPriorityDTOList = new ArrayList<>();
        for (AuthPriorityPO authPriorityPO : authPriorityPOList) {
            AuthPriorityDTO authPriorityDTO = CopyUtil.copy(authPriorityPO, AuthPriorityDTO.class);
            authPriorityDTOList.add(authPriorityDTO);
        }
        return authPriorityDTOList;
    }
}
