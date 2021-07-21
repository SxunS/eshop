package com.lee.eshop.auth.controller;

import com.lee.eshop.auth.dto.AuthPriorityDTO;
import com.lee.eshop.auth.po.AuthAccountPO;
import com.lee.eshop.auth.po.AuthPriorityPO;
import com.lee.eshop.auth.service.IPriorityService;
import com.lee.eshop.auth.vo.AuthPriorityVO;
import com.lee.eshop.common.util.CopyUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理模块的controller 组件
 * @author s_xun_s@163.com
 */
@RestController
@RequestMapping("/auth")
public class PriorityController {


    private final IPriorityService priorityService;

    public PriorityController(IPriorityService priorityService) {
        this.priorityService = priorityService;
    }

    /**
     * 查询跟权限列表
     * @return 跟权限列表
     */
    @GetMapping("/priority/root")
    public List<AuthPriorityVO> listRootPriorities(){
        List<AuthPriorityDTO> authPriorityDTOList = priorityService.listRootPriority();
        List<AuthPriorityVO> authPriorityVOList = new ArrayList<>();
        for (AuthPriorityDTO authPriorityDTO : authPriorityDTOList) {
            AuthPriorityVO priorityVO = CopyUtil.copy(authPriorityDTO, AuthPriorityVO.class);
            authPriorityVOList.add(priorityVO);
        }
        return authPriorityVOList;
    }




}
