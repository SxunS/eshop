package com.lee.eshop.comment.service.impl;

import com.lee.eshop.comment.dao.CommentInfoDAO;
import com.lee.eshop.comment.dto.CommentInfoDTO;
import com.lee.eshop.comment.po.CommentInfoPO;
import com.lee.eshop.comment.service.ICommentAggregateService;
import com.lee.eshop.comment.service.ICommentInfoService;
import com.lee.eshop.common.constant.CommentConstant;
import com.lee.eshop.common.constant.CommentStatus;
import com.lee.eshop.common.constant.CommentType;
import com.lee.eshop.order.dto.OrderDTO;
import com.lee.eshop.order.dto.OrderItemDTO;
import com.lee.eshop.order.service.IOrderFacadeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author s_xun_s@163.com
 */
@Service
public class CommentInfoServiceImpl implements ICommentInfoService {

    private final CommentInfoDAO commentInfoDAO;

    /**
     * 评论统计模块service
     */
    private final ICommentAggregateService commentAggregateService;

    /**
     * 订单中心service组件
     */
    private final IOrderFacadeService orderFacadeService;


    public CommentInfoServiceImpl(CommentInfoDAO commentInfoDAO, ICommentAggregateService commentAggregateService, IOrderFacadeService orderFacadeService) {
        this.commentInfoDAO = commentInfoDAO;
        this.commentAggregateService = commentAggregateService;
        this.orderFacadeService = orderFacadeService;
    }

    /**
     * 新增手动评论信息
     * @param record 评论信息PO对象
     * @return 插入条数
     */
    @Override
    public int saveManualCommentInfo(CommentInfoDTO record) {

        //计算总分数
        int totalScore = Math.round((float) (record.getGoodsScore() + record.getLogisticsScore() + record.getCustomerServiceScore()) / 3L);
        record.setTotalScore(Byte.valueOf(Integer.toString(totalScore)));

        //设置是否为默认评论
        record.setIsDefaultComment(CommentConstant.NOT_DEFAULT_COMMENT);

        //设置评论状态
        record.setCommentStatus(CommentStatus.APPROVING);

        //设置评论类型： 好中差
        Byte commentType;
        if (totalScore >= 4) {
            commentType = CommentType.GOOD;
        }else if (totalScore == 3){
            commentType = CommentType.MEDIUM;
        }else {
            commentType = CommentType.BAD;
        }
        record.setCommentType(commentType);

        record.setGmtCreate(LocalDateTime.now());
        record.setGmtModified(LocalDateTime.now());
        CommentInfoPO clone = record.clone(CommentInfoPO.class);
        record.setId(clone.getId());
        return commentInfoDAO.saveCommentInfo(clone);
    }


    @Override
    public int saveAutoCommentInfo(OrderDTO orderDTO, OrderItemDTO orderItemDTO) {

        CommentInfoDTO record = new CommentInfoDTO();
        record.setOrderId(orderDTO.getId());
        record.setGoodsSkuId(orderItemDTO.getGoodsSkuId());
        record.setGoodsId(orderItemDTO.getGoodsId());
        record.setGoodsSkuSaleProperties(orderItemDTO.getSaleProperties());
        record.setGoodsScore(Byte.valueOf("5"));
        record.setCustomerServiceScore(Byte.valueOf("5"));
        record.setLogisticsScore(Byte.valueOf("5"));
        record.setTotalScore(Byte.valueOf("5"));

        //设置是否为默认评论
        record.setIsDefaultComment(CommentConstant.DEFAULT_COMMENT);
        //设置是否晒图
        record.setIsShowPictures(CommentConstant.NOT_SHOW_PICTURES);

        //设置评论状态
        record.setCommentStatus(CommentStatus.APPROVED);
        //设置评论类型
        record.setCommentType(CommentType.GOOD);

        record.setGmtCreate(LocalDateTime.now());
        record.setGmtModified(LocalDateTime.now());
        CommentInfoPO clone = record.clone(CommentInfoPO.class);
        record.setId(clone.getId());

        //更新评论统计信息
        commentAggregateService.updateCommentAggregate(record);

        //通知订单中心订单已经发表了评论
        orderFacadeService.informPublishCommentEvent(record.getOrderId());

        return commentInfoDAO.saveCommentInfo(clone);
    }

}
