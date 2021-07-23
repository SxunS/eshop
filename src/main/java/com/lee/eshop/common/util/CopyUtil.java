package com.lee.eshop.common.util;

import com.github.pagehelper.PageInfo;
import com.lee.eshop.common.AbstractObject;
import net.sf.cglib.beans.BeanCopier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
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

    /**
     * 浅拷贝
     * @param source 拷贝源
     * @param targetType 拷贝结果类型
     * @return 拷贝结果
     */
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

    /**
     * 浅拷贝
     * @param source 拷贝源
     * @param target 拷贝结果
     */
    public static void copy(Object source, Object target){
        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());
        beanCopier.copy(source,target,null);
    }


    /**
     * 浅拷贝  copy pageInfo
     * @param source  拷贝源
     * @param targetClass 拷贝结果
     * @return
     */
    public static <T> PageInfo<T> pageInfoCopy(PageInfo<? extends AbstractObject> source, Class<T> targetClass){
        PageInfo<T> tPageInfo = new PageInfo<>();
        //copy 分页信息
        copy(source,tPageInfo);
        //copy 数据信息并转换数据对象
        ArrayList<T> cloneList = new ArrayList<>();
        for (AbstractObject sourceObject : source.getList()) {
            T clone = sourceObject.clone(targetClass);
            cloneList.add(clone);
        }
        tPageInfo.setList(cloneList);
        return tPageInfo;
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
