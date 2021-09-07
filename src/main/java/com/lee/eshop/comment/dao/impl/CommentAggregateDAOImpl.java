package com.lee.eshop.comment.dao.impl;

import com.lee.eshop.comment.dao.ICommentAggregateDAO;
import com.lee.eshop.comment.mapper.CommentAggregateMapper;
import com.lee.eshop.comment.po.CommentAggregatePO;
import com.lee.eshop.comment.vo.CommentAggregateVO;
import org.springframework.stereotype.Repository;

/**
 * 评论统计模块DAO实现
 * @author s_xun_s@163.com
 */
@Repository
public class CommentAggregateDAOImpl implements ICommentAggregateDAO {

    private final CommentAggregateMapper commentAggregateMapper;

    public CommentAggregateDAOImpl(CommentAggregateMapper commentAggregateMapper) {
        this.commentAggregateMapper = commentAggregateMapper;
    }

    @Override
    public CommentAggregatePO selectByGoodsId(Long goodsId) {
        return commentAggregateMapper.selectByGoodsId(goodsId);
    }

    @Override
    public int insertSelective(CommentAggregatePO record) {
        return commentAggregateMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(CommentAggregatePO record) {
        return commentAggregateMapper.updateByPrimaryKey(record);
    }
}
