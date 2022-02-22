package com.lee.eshop.comment.dao.impl;

import com.lee.eshop.comment.dao.CommentInfoDAO;
import com.lee.eshop.comment.mapper.CommentInfoVOMapper;
import com.lee.eshop.comment.po.CommentInfoPO;
import org.springframework.stereotype.Repository;

/**
 * 评论管理模块dao组件
 * @author s_xun_s@163.com
 */
@Repository
public class CommentInfoDAOImpl implements CommentInfoDAO {

    private final CommentInfoVOMapper mapper;

    public CommentInfoDAOImpl(CommentInfoVOMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int saveCommentInfo(CommentInfoPO commentInfoPO) {
        return mapper.insert(commentInfoPO);
    }
}
