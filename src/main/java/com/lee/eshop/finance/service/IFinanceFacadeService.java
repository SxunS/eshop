package com.lee.eshop.finance.service;

import com.lee.eshop.wms.dto.PurchaseInputOrderDTO;
import com.lee.eshop.wms.dto.ReturnGoodsInputOrderDTO;
import com.lee.eshop.wms.dto.SaleDeliveryOrderDTO;

/**
 * 财务中心对外提供接口
 * @author s_xun_s@163.com
 */
public interface IFinanceFacadeService {


    /**
     * 创建采购结算单
     * @param purchaseInputOrderDTO 采购入库单 DTO
     * @return 处理结果
     */
    boolean createPurchaseSettlementOrder(PurchaseInputOrderDTO purchaseInputOrderDTO);


    /**
     * 跟物流公司打款
     * @param saleDeliveryOrderDTO 销售出库单
     * @return 处理结果
     */
    boolean payForLogisticsCompany(SaleDeliveryOrderDTO saleDeliveryOrderDTO);


    /**
     * 执行退货退款操作
     * @param returnGoodsInputOrderDTO 退货入库单DTO
     * @return 处理结果
     */
    boolean executeReturnGoodsRefund(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

}
