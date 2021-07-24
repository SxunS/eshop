package com.lee.eshop.auth.service;

import com.lee.eshop.auth.service.impl.AuthPriority;

/**
 * 权限接口的 `访问者` 接口
 * @author s_xun_s@163.com
 */
public interface PriorityOperator {

    /**
     * 主要执行逻辑
     * 由不同的实现类执行
     * @param authPriority 用来操作的数据对象
     */
    void execute(AuthPriority authPriority);

}
