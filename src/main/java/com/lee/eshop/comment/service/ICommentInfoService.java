package com.lee.eshop.comment.service;

import com.lee.eshop.comment.dto.CommentInfoDTO;
import com.lee.eshop.comment.po.CommentInfoPO;
import com.lee.eshop.order.dto.OrderDTO;
import com.lee.eshop.order.dto.OrderItemDTO;
import org.springframework.stereotype.Service;

/**
 * 评论管理模块的service接口
 * @author s_xun_s@163.com
 */
public interface ICommentInfoService {

    /**
     * 新增手动评论信息
     * @param record 评论信息PO对象
     * @return 插入条数
     */
    int saveManualCommentInfo(CommentInfoDTO record);

    /**
     * 新增自动评论信息
     * @param orderDTO 订单DTO
     * @param orderItemDTO 订单项DTO
     * @return 插入条数
     */
    int saveAutoCommentInfo(OrderDTO orderDTO, OrderItemDTO orderItemDTO);

}
