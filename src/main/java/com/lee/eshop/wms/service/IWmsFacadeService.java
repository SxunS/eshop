package com.lee.eshop.wms.service;

import com.lee.eshop.wms.dto.OrderDTO;
import com.lee.eshop.wms.dto.ReturnGoodsInputOrderDTO;
import com.lee.eshop.wms.dto.SaleDeliveryOrderDTO;
import com.lee.eshop.wms.dto.PurchaseInputOrderDTO;

/**
 * @author s_xun_s@163.com
 */
public interface IWmsFacadeService {

    /**
     * 创建采购入库单
     * @param purchaseInputOrderDTO 采购入库单 DTO
     * @return 处理结果
     */
    Boolean createPurchaseInputOrder(PurchaseInputOrderDTO purchaseInputOrderDTO);


    /**
     * 创建销售出库单
     * @param saleDeliveryOrderDTO 销售出库单 DTO
     * @return 处理结果
     */
    Boolean createSaleDeliveryOrder(SaleDeliveryOrderDTO saleDeliveryOrderDTO);


    /**
     * 创建退货入库单
     * @param returnGoodsInputOrderDTO 退货入库单 DTO
     * @return 处理结果
     */
    Boolean createReturnGoodsInputOrder(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);


    /**
     * 通知 提交订单 事件
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderDTO orderDTO);


    /**
     * 通知 WMS 支付订单 事件
     * @param orderDTO
     * @return
     */
    Boolean informPayOrderEvent(OrderDTO orderDTO);

    /**
     * 通知 WMS 取消订单 事件
     * @param orderDTO
     * @return
     */
    Boolean informCancelOrderEvent(OrderDTO orderDTO);


}
