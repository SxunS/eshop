package com.lee.eshop.inventory.service;

import com.lee.eshop.wms.dto.OrderDTO;
import com.lee.eshop.wms.dto.PurchaseInputOrderDTO;
import com.lee.eshop.wms.dto.ReturnGoodsInputOrderDTO;

/**
 * 库存中心对外提供接口
 * @author s_xun_s@163.com
 */
public interface IInventoryFacadeService {

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
     * 查询商品库存
     * @param goodsSkuId 商品skuId
     * @return 库存数量
     */
    long getSaleStockQuantity(long goodsSkuId);

}
