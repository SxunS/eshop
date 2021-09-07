package com.lee.eshop.comment.service;

import com.lee.eshop.comment.dao.CommentInfoDAO;
import com.lee.eshop.comment.dto.CommentAggregateDTO;
import com.lee.eshop.comment.dto.CommentInfoDTO;

/**
 * 评论统计模块service接口
 * @author s_xun_s@163.com
 */
public interface ICommentAggregateService {

    /**
     * select by primary key
     * @param goodsId primary key
     * @return object by primary key
     */
    CommentAggregateDTO selectByGoodsId(Long goodsId);


    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CommentAggregateDTO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CommentAggregateDTO record);

    /**
     * 更新商品聚合统计信息
     * @param record 评论信息
     * @return 处理结果
     */
    boolean updateCommentAggregate(CommentInfoDTO record);

}
