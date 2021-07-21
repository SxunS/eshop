package com.lee.eshop.auth.mapper;

import com.lee.eshop.auth.po.AuthPriorityPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限管理组件 mapper 组件
 * @author s_xun_s@163.com
 */
@Mapper
public interface PriorityMapper {

    /**
     * 查询跟权限列表
     * @return 跟权限列表
     */
    @Select("select id, code, url, priority_comment, priority_type, parent_id, gmt_create, gmt_modified from auth_priority where parent_id is null ")
    List<AuthPriorityPO> listRootPriority();

}
