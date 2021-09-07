package com.lee.eshop.comment.mapper;

import com.lee.eshop.comment.po.CommentAggregatePO;
import com.lee.eshop.comment.vo.CommentAggregateVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论管理模块mapper组件
 * @author s_xun_s@163.com
 */
@Mapper
public interface CommentAggregateMapper {


    /**
     * select by Goods id
     * @param goodsId Goods id
     * @return object by Goods id
     */
    CommentAggregatePO selectByGoodsId(Long goodsId);

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(CommentAggregatePO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CommentAggregatePO record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CommentAggregatePO selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CommentAggregatePO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CommentAggregatePO record);
}