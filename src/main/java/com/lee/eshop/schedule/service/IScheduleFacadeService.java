package com.lee.eshop.schedule.service;

import com.lee.eshop.membership.dto.ReturnGoodsWorksheetDTO;
import com.lee.eshop.purchase.dto.PurchaseOrderDTO;
import com.lee.eshop.wms.dto.OrderDTO;
import com.lee.eshop.wms.dto.PurchaseInputOrderDTO;
import com.lee.eshop.wms.dto.ReturnGoodsInputOrderDTO;

/**
 * 调度中心对外接口
 * @author s_xun_s@163.com
 */
public interface IScheduleFacadeService {


    /**
     * 通知库存中心 采购入库完成 事件
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    boolean informPurchaseInputFinishedEvent(PurchaseInputOrderDTO purchaseInputOrderDTO);


    /**
     * 通知库存中心 提交订单 事件
     * @param orderDTO 订单 DTO
     * @return 处理结果
     */
    boolean informSubmitOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心 支付订单 事件
     * @param orderDTO 订单 DTO
     * @return 处理结果
     */
    boolean informPayOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心 取消订单 事件
     * @param orderDTO 订单 DTO
     * @return 处理结果
     */
    boolean informCancelOrderEvent(OrderDTO orderDTO);


    /**
     * 完成退货入库 事件
     * @param returnGoodsInputOrderDTO 退货入库单 DTO
     * @return 处理结果
     */
    boolean informReturnGoodsInputFinishedEvent(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

    /**
     * 调度采购入库
     * @param purchaseOrderDTO 采购单DTO
     * @return 处理结果
     */
    boolean schedulePurchaseInput(PurchaseOrderDTO purchaseOrderDTO);

    /**
     * 调度销售出库
     * @param orderDTO 订单DTO
     * @return
     */
    boolean scheduleSaleDelivery(OrderDTO orderDTO);


    /**
     * 调度退货入库
     * @param returnGoodsWorksheetDTO 退货单DTO
     * @return 处理结果
     */
    boolean scheduleReturnGoodsInput(ReturnGoodsWorksheetDTO returnGoodsWorksheetDTO);

}
