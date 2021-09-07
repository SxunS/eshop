package com.lee.eshop.comment.mapper;

import com.lee.eshop.comment.po.CommentInfoPO;
import com.lee.eshop.comment.vo.CommentInfoVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author s_xun_s@163.com
 */
@Mapper
public interface CommentInfoVOMapper {
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
    int insert(CommentInfoPO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CommentInfoVO record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CommentInfoVO selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CommentInfoVO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CommentInfoVO record);
}