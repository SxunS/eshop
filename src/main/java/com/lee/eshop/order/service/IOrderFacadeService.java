package com.lee.eshop.order.service;

/**
 * 订单中心对外提供接口
 * @author s_xun_s@163.com
 */
public interface IOrderFacadeService {


    /**
     * 通知订单中心 商品完成发货 事件
     * @param orderId
     * @return
     */
    boolean informGoodsDeliveryFinishedEvent(long orderId);

    /**
     * 通知订单中心 退货工单审核本拒 事件
     * @param orderId
     * @return
     */
    boolean informReturnGoodsWorksheetRejectedEvent(long orderId);


    /**
     *  通知订单中心 通过退货工单 事件
     * @param orderId
     * @return
     */
    boolean informReturnGoodsWorksheetApprovedEvent(long orderId);


    /**
     * 通知订单中心 确认收到退货商品 事件
     * @param orderId
     * @return
     */
    boolean informReturnGoodsReceivedEvent(long orderId);


    /**
     * 通知订单中心 退货入库单审核通过
     * @param orderId
     * @return
     */
    boolean informReturnGoodsInputOrderApprovedEvent(long orderId);


    /**
     * 通知订单中心 完成退款 事件
     * @param orderId
     * @return
     */
    boolean informRefundFinishedEvent(long orderId);

}
