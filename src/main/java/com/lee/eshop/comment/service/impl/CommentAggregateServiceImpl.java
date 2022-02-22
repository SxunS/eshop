package com.lee.eshop.comment.service.impl;

import com.lee.eshop.comment.dao.CommentInfoDAO;
import com.lee.eshop.comment.dao.ICommentAggregateDAO;
import com.lee.eshop.comment.dto.CommentAggregateDTO;
import com.lee.eshop.comment.dto.CommentInfoDTO;
import com.lee.eshop.comment.po.CommentAggregatePO;
import com.lee.eshop.comment.service.ICommentAggregateService;
import com.lee.eshop.common.constant.CommentConstant;
import com.lee.eshop.common.constant.CommentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

/**
 * 评论统计模块service实现
 * @author s_xun_s@163.com
 */
@Service
public class CommentAggregateServiceImpl implements ICommentAggregateService {

    private static final Logger logger = LoggerFactory.getLogger(CommentAggregateServiceImpl.class);

    private final ICommentAggregateDAO commentAggregateDAO;

    public CommentAggregateServiceImpl(ICommentAggregateDAO commentAggregateDAO) {
        this.commentAggregateDAO = commentAggregateDAO;
    }

    @Override
    public CommentAggregateDTO selectByGoodsId(Long goodsId) {
        return commentAggregateDAO.selectByGoodsId(goodsId).clone(CommentAggregateDTO.class);
    }

    @Override
    public int insertSelective(CommentAggregateDTO record) {
        return commentAggregateDAO.insertSelective(record.clone(CommentAggregatePO.class));
    }

    @Override
    public int updateByPrimaryKey(CommentAggregateDTO record) {
        return commentAggregateDAO.updateByPrimaryKey(record.clone(CommentAggregatePO.class));
    }

    @Override
    public boolean updateCommentAggregate(CommentInfoDTO record) {

        try {
            CommentAggregatePO commentAggregatePO = commentAggregateDAO.selectByGoodsId(record.getGoodsId());
            if (commentAggregatePO == null) {
                commentAggregatePO = new CommentAggregatePO();
                commentAggregatePO.setGoodsId(record.getGoodsId());
                commentAggregatePO.setTotalCommentCount(1L);
                if (CommentType.GOOD.equals(record.getCommentType())) {
                    commentAggregatePO.setGoodCommentCount(1L);
                }else if (CommentType.MEDIUM.equals(record.getCommentType())){
                    commentAggregatePO.setMediumCommentCount(1L);
                }else if (CommentType.BAD.equals(record.getCommentType())){
                    commentAggregatePO.setBadCommentCount(1L);
                }

                BigDecimal goodsCommentRate = BigDecimal.valueOf(commentAggregatePO.getGoodCommentCount()).divide(BigDecimal.valueOf(commentAggregatePO.getTotalCommentCount()),2);
                commentAggregatePO.setGoodCommentRate(goodsCommentRate);

                if (CommentConstant.SHOW_PICTURES.equals(record.getIsShowPictures())) {
                    commentAggregatePO.setShowPicturesCommentCount(1L);
                }
                commentAggregatePO.setGmtCreate(LocalDateTime.now());
                commentAggregatePO.setGmtModified(LocalDateTime.now());

                commentAggregateDAO.insertSelective(commentAggregatePO);

            }else {

                commentAggregatePO.setTotalCommentCount(commentAggregatePO.getTotalCommentCount() + 1);
                if (CommentType.GOOD.equals(record.getCommentType())) {
                    commentAggregatePO.setGoodCommentCount(commentAggregatePO.getGoodCommentCount() + 1);
                }else if (CommentType.MEDIUM.equals(record.getCommentType())){
                    commentAggregatePO.setMediumCommentCount(commentAggregatePO.getMediumCommentCount() + 1);
                }else if (CommentType.BAD.equals(record.getCommentType())){
                    commentAggregatePO.setBadCommentCount(commentAggregatePO.getBadCommentCount() + 1);
                }

                BigDecimal goodsCommentRate = BigDecimal.valueOf(commentAggregatePO.getGoodCommentCount()).divide(BigDecimal.valueOf(commentAggregatePO.getTotalCommentCount()),2);
                commentAggregatePO.setGoodCommentRate(goodsCommentRate);

                if (CommentConstant.SHOW_PICTURES.equals(record.getIsShowPictures())) {
                    commentAggregatePO.setShowPicturesCommentCount(commentAggregatePO.getShowPicturesCommentCount() + 1);
                }
                commentAggregatePO.setGmtCreate(LocalDateTime.now());
                commentAggregatePO.setGmtModified(LocalDateTime.now());

                commentAggregateDAO.updateByPrimaryKey(commentAggregatePO);
            }
        } catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }


}
