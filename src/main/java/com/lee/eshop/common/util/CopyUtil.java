package com.lee.eshop.common.util;

import net.sf.cglib.beans.BeanCopier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 添加一个 基于 cglib 动态代理的 bean copy 工具类
 *  使用享元模式 减少 对象创建
 * @author s_xun_s@163.com
 */
public class CopyUtil {

    private static final Logger logger = LoggerFactory.getLogger(CopyUtil.class);

    private CopyUtil() {
    }


    private static final Map<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap<>();

    public static <T> T copy(Object source, Class<T> targetType){
        T targetInstance;
        try {
            targetInstance = targetType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("不能得到{}的反射实例",targetType.getName(),e);
            throw new RuntimeException(e);
        }
        copy(source,targetInstance);
        return targetInstance;
    }

    public static void copy(Object source, Object target){
        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());
        beanCopier.copy(source,target,null);
    }


    @SuppressWarnings("rawtypes")
    private static BeanCopier getBeanCopier(Class source, Class target){

        String beanCopierCacheKey = source.getName() + target.getName();
        BeanCopier beanCopier;
        if (!BEAN_COPIER_CACHE.containsKey(beanCopierCacheKey)) {
            beanCopier = BeanCopier.create(source, target, false);
            BEAN_COPIER_CACHE.put(beanCopierCacheKey,beanCopier);
        }else {
            beanCopier = BEAN_COPIER_CACHE.get(beanCopierCacheKey);
        }
        return beanCopier;
    }


}
