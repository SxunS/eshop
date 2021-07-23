package com.lee.eshop.common;

import com.lee.eshop.common.util.CopyUtil;

import java.time.LocalDateTime;

/**
 * 基础 POJO
 * @author admin
 */
public abstract class AbstractObject {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 浅克隆
     * @param targetClass 需要被克隆的类型
     * @return 被克隆的对象
     */
    public <T> T clone(Class<T> targetClass){
        T target;
        try {
            target = targetClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        clone(this, target);
        return target;
    }

    /**
     * 浅克隆
     * @param target 需要被克隆的实例
     */
    public <T> void clone(T target){
        clone(this, target);
    }

    protected <T> void clone(AbstractObject sourceObject, T target){
        CopyUtil.copy(sourceObject,target);
    }

}
