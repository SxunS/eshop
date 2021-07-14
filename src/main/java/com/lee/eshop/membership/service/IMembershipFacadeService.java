package com.lee.eshop.membership.service;

import java.math.BigDecimal;

/**
 * 会员中心对外接口
 * @author s_xun_s@163.com
 */
public interface IMembershipFacadeService {

    /**
     * 通知会员中心 用户第一次登陆 事件
     * @param userAccountId 用户id
     * @return 处理结果
     */
    Boolean informFirstLoginDailyEvent(Long userAccountId);


    /**
     * 通知会员中心 支付订单 事件发生了
     * @param userAccountId 用户账号id
     * @param totalOrderAmount 订单总金额
     * @return 处理结果
     */
    Boolean informPayOrderEvent(Long userAccountId, BigDecimal totalOrderAmount);

    /**
     * 通知会员中心 完成退货 事件
     * @param userAccountId 用户账号id
     * @param totalOrderAmount 订单总金额
     * @return
     */
    Boolean informFinishReturnGoodsEvent(long userAccountId, BigDecimal totalOrderAmount);


    /**
     * 通知会员中心 发表评论事件
     * @param userAccountId 用户账号id
     * @param showPictures 是否晒图
     * @return 处理结果
     */
    boolean informPublishCommentEvent(long userAccountId, boolean showPictures);

    /**
     * 通知会员中心 删除评论 事件
     * @param userAccountId 用户账号id
     * @param showPictures 是否晒单
     * @return 处理结果
     */
    boolean informRemoveCommentEvent(long userAccountId, boolean showPictures);


}
