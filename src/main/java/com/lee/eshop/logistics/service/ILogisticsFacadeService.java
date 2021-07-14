package com.lee.eshop.logistics.service;

import com.lee.eshop.goods.dto.GoodsSkuDTO;

import java.math.BigDecimal;

/**
 * 物流中心对外提供接口
 * @author s_xun_s@163.com
 */
public interface ILogisticsFacadeService {

    /**
     * 计算运费
     * @param goodsSkuDTO 商品 skuDTO
     * @return
     */
    BigDecimal calculateFreight(GoodsSkuDTO goodsSkuDTO);

}
