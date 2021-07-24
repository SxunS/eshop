package com.lee.eshop.auth.controller;

import com.lee.eshop.auth.dto.AuthPriorityDTO;
import com.lee.eshop.auth.service.IPriorityService;
import com.lee.eshop.auth.service.impl.AuthPriority;
import com.lee.eshop.auth.service.impl.PriorityDelCheckOperatorImpl;
import com.lee.eshop.auth.service.impl.PriorityDelOperatorImpl;
import com.lee.eshop.auth.vo.AuthPriorityVO;
import com.lee.eshop.common.result.CommonResult;
import com.lee.eshop.common.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理模块的controller 组件
 * @author s_xun_s@163.com
 */
@RestController
@RequestMapping("/auth")
public class PriorityController {

    private static final Logger logger = LoggerFactory.getLogger(PriorityController.class);


    private final IPriorityService priorityService;

    private final ApplicationContext applicationContext;

    public PriorityController(IPriorityService priorityService, ApplicationContext applicationContext) {
        this.priorityService = priorityService;
        this.applicationContext = applicationContext;
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
     * 添加权限
     * @param authPriorityVO 权限vo
     * @return 处理结果
     */
    @PostMapping("/priority/")
    public CommonResult<Object> savePriority(AuthPriorityVO authPriorityVO){
        try {
            AuthPriorityDTO authPriorityDTO = authPriorityVO.clone(AuthPriorityDTO.class);
            priorityService.savePriority(authPriorityDTO);
            return CommonResult.sucess(null);
        } catch (Exception e) {
            logger.error("Failed to save Priority: [{}]", authPriorityVO, e);
            return CommonResult.failed(null);
        }
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
     * 更新权限
     * @param authPriorityVO 权限vo
     * @return 处理结果
     */
    @PutMapping("/priority/")
    public CommonResult<Object> updatePriority(AuthPriorityVO authPriorityVO){
        try {
            AuthPriorityDTO authPriorityDTO = authPriorityVO.clone(AuthPriorityDTO.class);
            priorityService.updatePriority(authPriorityDTO);
            return CommonResult.sucess(null);
        } catch (Exception e) {
            logger.error("Failed to update Priority: [{}]", authPriorityVO, e);
            return CommonResult.failed(null);
        }
    }


    /**
     * 删除权限
     * @param authPriorityVO 权限vo
     * @return 处理结果
     */
    @DeleteMapping("/priority/")
    public CommonResult<Object> deletePriority(AuthPriorityVO authPriorityVO){

        try {
            //校验是否可删除
            AuthPriority authPriority = authPriorityVO.clone(AuthPriority.class);
            PriorityDelCheckOperatorImpl delCheckOperator = applicationContext.getBean(PriorityDelCheckOperatorImpl.class);
            authPriority.accept(delCheckOperator);

            //执行删除操作
            if (delCheckOperator.canDel()) {
                PriorityDelOperatorImpl delOperator = applicationContext.getBean(PriorityDelOperatorImpl.class);
                authPriority.accept(delOperator);
            }

            return CommonResult.sucess(null);
        } catch (BeansException e) {
            logger.error("Failed to delete Priority [{}]",authPriorityVO, e);
            return CommonResult.failed(e.getMessage());
        }

    }


    /**
     *
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
