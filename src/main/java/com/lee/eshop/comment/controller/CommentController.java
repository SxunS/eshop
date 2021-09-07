package com.lee.eshop.comment.controller;

import com.lee.eshop.comment.dto.CommentInfoDTO;
import com.lee.eshop.comment.service.CommentPictureService;
import com.lee.eshop.comment.service.ICommentAggregateService;
import com.lee.eshop.comment.service.ICommentInfoService;
import com.lee.eshop.comment.vo.CommentInfoVO;
import com.lee.eshop.common.constant.CommentConstant;
import com.lee.eshop.common.result.CommonResult;
import com.lee.eshop.membership.service.IMembershipFacadeService;
import com.lee.eshop.order.service.IOrderFacadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 评论管理模块的Controller组件
 * @author s_xun_s@163.com
 */
@Api(tags = "评论管理模块的Controller组件")
@RequestMapping("/comment")
@RestController
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);


    private final ICommentInfoService commentInfoService;

    /**
     * 评论晒图管理模块组件
     */
    private final CommentPictureService commentPictureService;

    /**
     * 评论统计模块service
     */
    private final ICommentAggregateService commentAggregateService;

    /**
     * 订单中心service组件
     */
    private final IOrderFacadeService orderFacadeService;

    private final IMembershipFacadeService membershipFacadeService;

    public CommentController(ICommentInfoService commentInfoService,
                             CommentPictureService commentPictureService,
                             ICommentAggregateService commentAggregateService,
                             IOrderFacadeService orderFacadeService,
                             IMembershipFacadeService membershipFacadeService) {
        this.commentInfoService = commentInfoService;
        this.commentPictureService = commentPictureService;
        this.commentAggregateService = commentAggregateService;
        this.orderFacadeService = orderFacadeService;
        this.membershipFacadeService = membershipFacadeService;
    }

    /**
     * 手动发表评论
     * @param commentInfoVO 评论信息vo对象
     * @return 处理结果
     */
    @ApiOperation("手动发表评论")
    @PostMapping("/")
    public CommonResult<Boolean> publishComment(CommentInfoVO commentInfoVO, MultipartFile[] files){

        try {

            //为评论设置是否晒图
            byte showPictures = CommentConstant.NOT_SHOW_PICTURES;
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    showPictures = CommentConstant.SHOW_PICTURES;
                    break;
                }
            }
            commentInfoVO.setIsShowPictures(showPictures);

            //保存评论信息
            CommentInfoDTO commentInfoDTO = commentInfoVO.clone(CommentInfoDTO.class);
            commentInfoService.saveManualCommentInfo(commentInfoDTO);

            //上传评论图片
            commentPictureService.saveCommentPictures(commentInfoDTO.getId(),files);

            //更新评论统计信息
            commentAggregateService.updateCommentAggregate(commentInfoDTO);
            //通知订单中心订单已经发表了评论
            orderFacadeService.informPublishCommentEvent(commentInfoDTO.getOrderId());
            //通知会员中心 用户已经发表了评论
            membershipFacadeService.informPublishCommentEvent(commentInfoDTO.getUserAccountId(), CommentConstant.SHOW_PICTURES.equals(commentInfoDTO.getIsShowPictures()));

        } catch (Exception e) {
            logger.error("",e);
            return CommonResult.failed(false);
        }
        return CommonResult.sucess(true);
    }

}
