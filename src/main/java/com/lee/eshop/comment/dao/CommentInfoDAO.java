package com.lee.eshop.comment.dao;

import com.lee.eshop.comment.po.CommentInfoPO;

/**
 * 评论管理模块DAO组件接口
 * @author s_xun_s@163.com
 */
public interface CommentInfoDAO {


    /**
     * 新增评论信息
     * @param commentInfoPO 评论信息PO对象
     * @return 插入条数
     */
    int saveCommentInfo(CommentInfoPO commentInfoPO);


}
