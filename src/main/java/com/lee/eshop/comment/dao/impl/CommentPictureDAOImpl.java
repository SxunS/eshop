package com.lee.eshop.comment.dao.impl;

import com.lee.eshop.comment.dao.CommentPictureDAO;
import com.lee.eshop.comment.mapper.CommentPictureMapper;
import com.lee.eshop.comment.po.CommentPicturePO;
import com.lee.eshop.comment.vo.CommentPictureVO;
import org.springframework.stereotype.Repository;

/**
 * 评论晒图模块的DAO组件
 * @author s_xun_s@163.com
 */
@Repository
public class CommentPictureDAOImpl implements CommentPictureDAO {

    private final CommentPictureMapper commentPictureMapper;

    public CommentPictureDAOImpl(CommentPictureMapper commentPictureMapper) {
        this.commentPictureMapper = commentPictureMapper;
    }

    @Override
    public int insert(CommentPicturePO record) {
        return commentPictureMapper.insert(record);
    }
}
