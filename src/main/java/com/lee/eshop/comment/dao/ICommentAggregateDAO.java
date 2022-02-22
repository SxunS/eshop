package com.lee.eshop.comment.dao;

import com.lee.eshop.comment.po.CommentAggregatePO;

/**
 * 评论统计模块DAO组件
 * @author s_xun_s@163.com
 */
public interface ICommentAggregateDAO {

    /**
     * select by primary key
     * @param goodsId primary key
     * @return object by primary key
     */
    CommentAggregatePO selectByGoodsId(Long goodsId);


    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CommentAggregatePO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CommentAggregatePO record);

}
