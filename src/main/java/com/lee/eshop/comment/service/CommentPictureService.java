package com.lee.eshop.comment.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 评论晒图管理模块评service组件接口
 * @author s_xun_s@163.com
 */
public interface CommentPictureService {




    /**
     * 保存评论晒图
     * @param commentInfoId 评论信息id
     * @param files 评论晒图
     * @return 处理结果
     */
    boolean saveCommentPictures(Long commentInfoId, MultipartFile[] files);


}
