package com.lee.eshop.comment.mapper;

import com.lee.eshop.comment.po.CommentPicturePO;
import com.lee.eshop.comment.vo.CommentPictureVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentPictureMapper {
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
    int insert(CommentPicturePO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CommentPicturePO record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CommentPicturePO selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CommentPicturePO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CommentPicturePO record);
}