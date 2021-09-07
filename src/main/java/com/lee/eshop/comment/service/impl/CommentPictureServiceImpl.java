package com.lee.eshop.comment.service.impl;

import com.lee.eshop.comment.dao.CommentPictureDAO;
import com.lee.eshop.comment.po.CommentPicturePO;
import com.lee.eshop.common.constant.CommentPictureUploadType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lee.eshop.comment.service.CommentPictureService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 评论晒图管理模块service组件
 */
@Service
public class CommentPictureServiceImpl implements CommentPictureService {

    private static final Logger logger = LoggerFactory.getLogger(CommentPictureServiceImpl.class);

    @Resource
    private CommentPictureDAO commentPictureDAO;

    /**
     * 上传类型
     *  1. absolute
     *  2. relative
     *  3. remote
     */
    @Value("${comment.picture.upload.type:relative}")
    private String uploadType;

    /**
     * 上传地址
     */
    @Value("${comment.picture.upload.dir:/}")
    private String uploadDirPath;

    /**
     * 保存评论晒图
     * @param commentInfoId 评论信息id
     * @param files 评论晒图
     * @return 处理结果
     */
    @Override
    public boolean saveCommentPictures(Long commentInfoId, MultipartFile[] files) {

        String realUploadPath = "";
        if (CommentPictureUploadType.RELATIVE.equals(uploadType)) {
            realUploadPath = System.getProperty("user.dir") + System.lineSeparator() + uploadDirPath;
        }else if (CommentPictureUploadType.ABSOLUTE.equals(uploadType)){
            realUploadPath = uploadDirPath;
        }else if (CommentPictureUploadType.REMOTE.equals(uploadType)){
            //todo
        }else {
            throw new RuntimeException(String.format("unsupported upload type[%s]",uploadType));
        }

        if (!CommentPictureUploadType.REMOTE.equals(uploadType)){

            try {
                File uploadDir = new File(realUploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                for (MultipartFile file : files) {
                    if (!file.isEmpty()) {
                        String targetFilePath = realUploadPath + file.getOriginalFilename();
                        File targetFile = new File(targetFilePath);
                        if (targetFile.exists()) {
                            targetFile.delete();
                        }
                        file.transferTo(targetFile);
                        //将晒图信息保存到数据库
                        CommentPicturePO commentPicturePO = new CommentPicturePO();
                        commentPicturePO.setCommentInfoId(commentInfoId);
                        commentPicturePO.setCommentPicturePath(targetFilePath);
                        commentPicturePO.setGmtCreate(LocalDateTime.now());
                        commentPicturePO.setGmtModified(LocalDateTime.now());
                        commentPictureDAO.insert(commentPicturePO);
                    }
                }

            } catch (IOException e) {
                logger.error("保存晒图信息失败", e);
            }

        }


        return false;
    }

}
