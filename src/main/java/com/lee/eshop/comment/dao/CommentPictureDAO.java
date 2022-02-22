package com.lee.eshop.comment.dao;

import com.lee.eshop.comment.po.CommentPicturePO;
import com.lee.eshop.comment.vo.CommentPictureVO;

/**
 * 评论晒图管理模块DAO组件接口
 * @author s_xun_s@163.com
 */
public interface CommentPictureDAO {


    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(CommentPicturePO record);



}
