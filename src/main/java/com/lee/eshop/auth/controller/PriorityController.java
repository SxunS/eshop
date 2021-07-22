package com.lee.eshop.auth.controller;

import com.lee.eshop.auth.dto.AuthPriorityDTO;
import com.lee.eshop.auth.po.AuthAccountPO;
import com.lee.eshop.auth.po.AuthPriorityPO;
import com.lee.eshop.auth.service.IPriorityService;
import com.lee.eshop.auth.vo.AuthPriorityVO;
import com.lee.eshop.common.util.CopyUtil;
import javafx.scene.Parent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return changeDTOToVO(authPriorityDTOList);
    }

    /**
     *  查询子权限列表
     * @return 子权限列表
     */
    @GetMapping("/priority/{parentId}/child")
    public List<AuthPriorityVO> listChildPriorities(@PathVariable long parentId){
        List<AuthPriorityDTO> authPriorityDTOList = priorityService.listChildPriorities(parentId);
        return changeDTOToVO(authPriorityDTOList);
    }

    /**
     * 根据id 查询当前权限
     * @param id 权限id
     * @return 权限
     */
    @GetMapping("/priority/{id}")
    public AuthPriorityVO getPriorityById(@PathVariable long id){
        AuthPriorityDTO priorityByIdDTO = priorityService.getPriorityById(id);
        return CopyUtil.copy(priorityByIdDTO,AuthPriorityVO.class);
    }


    /**
     * 查询账号被授权的权限树
     * @param accountId 账号id
     * @return 权限树
     */
    @GetMapping("/authorized/tree/{accountId}")
    public List<AuthPriorityVO> listAuthPriorityByAccountId(@PathVariable long accountId){
        List<AuthPriorityDTO> authPriorityDTOList = priorityService.listAuthorizationByAccountId(accountId);
        return changeDTOToVO(authPriorityDTOList);
    }

    private List<AuthPriorityVO> changeDTOToVO(List<AuthPriorityDTO> authPriorityDTOList) {
        List<AuthPriorityVO> authPriorityVOList = new ArrayList<>();
        for (AuthPriorityDTO authPriorityDTO : authPriorityDTOList) {
            AuthPriorityVO priorityVO = CopyUtil.copy(authPriorityDTO, AuthPriorityVO.class);
            authPriorityVOList.add(priorityVO);
        }
        return authPriorityVOList;
    }




}
