package com.lee.eshop.promotion.service;

import com.lee.eshop.promotion.dto.PromotionActivityDTO;

import java.util.List;

/**
 * 促销中心 对外暴露接口
 * @author s_xun_s@163.com
 */
public interface IPromotionFacadeService {


    /**
     * 根据商品id查询促销活动
     * @param goodsId 商品id
     * @return 促销活动
     */
    List<PromotionActivityDTO> listPromotionActivitiesByGoodsId(long goodsId);

}
