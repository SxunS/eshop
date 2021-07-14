package com.lee.eshop.customer.service;

/**
 * 客服中心对外提供接口
 * @author s_xun_s@163.com
 */
public interface ICustomerFacadeService {

    /**
     * 创建退货工单
     * @param orderId 订单id
     * @param orderNo 订单编号
     * @param returnGoodsReason 退货原因
     * @param returnGoodsComment 退货备注
     * @return 处理结果
     */
    boolean createReturnGoodsWorksheet(long orderId, String orderNo, String returnGoodsReason, String returnGoodsComment);


    /**
     * 同步物流单号
     * @param orderId 订单id
     * @param returnGoodsCourierNumber 物流单号
     * @return 处理结果
     */
    boolean syncReturnGoodsCourierNumber(long orderId, String returnGoodsCourierNumber);


    /**
     * 通知客服中心 完成退货入库 事件
     * @param returnGoodsWorksheetId 退货工单id
     * @return 处理结果
     */
    boolean informReturnGoodsInputFinishedEvent(long returnGoodsWorksheetId);

    /**
     * 通知客服中心 完成退货打款 事件
     * @param returnGoodsWorksheetId 退货工单id
     * @return 处理结果
     */
    boolean informRefundFinishedEvent(long returnGoodsWorksheetId);

}
