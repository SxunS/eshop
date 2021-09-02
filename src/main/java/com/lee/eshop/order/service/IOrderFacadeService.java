package com.lee.eshop.order.service;

import com.lee.eshop.order.dto.OrderDTO;

import java.util.List;

/**
 * 订单中心对外提供接口
 * @author s_xun_s@163.com
 */
public interface IOrderFacadeService {


    /**
     * 通知订单中心 商品完成发货 事件
     * @param orderId 订单id
     * @return 处理结果
     */
    boolean informGoodsDeliveryFinishedEvent(long orderId);

    /**
     * 通知订单中心 退货工单审核本拒 事件
     * @param orderId 订单id
     * @return 处理结果
     */
    boolean informReturnGoodsWorksheetRejectedEvent(long orderId);


    /**
     *  通知订单中心 通过退货工单 事件
     * @param orderId 订单id
     * @return 处理结果
     */
    boolean informReturnGoodsWorksheetApprovedEvent(long orderId);


    /**
     * 通知订单中心 确认收到退货商品 事件
     * @param orderId 订单id
     * @return 处理结果
     */
    boolean informReturnGoodsReceivedEvent(long orderId);


    /**
     * 通知订单中心 退货入库单审核通过
     * @param orderId 订单id
     * @return 处理结果
     */
    boolean informReturnGoodsInputOrderApprovedEvent(long orderId);


    /**
     * 通知订单中心 完成退款 事件
     * @param orderId 订单id
     * @return 处理结果
     */
    boolean informRefundFinishedEvent(long orderId);

    /**
     * 通知订单中心 订单发表评论 事件发生
     * @param orderId 订单id
     * @return 处理结果
     */
    boolean informPublishCommentEvent(long orderId);

    /**
     * 从订单中心获取，去人收货超过了7天，且没有发表评论的订单
     * @return 订单信息dto集合
     */
    List<OrderDTO> listNotPublishedCommentOrders();

}
