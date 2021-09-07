package com.lee.eshop.comment.schedule;

import com.lee.eshop.comment.service.ICommentAggregateService;
import com.lee.eshop.comment.service.ICommentInfoService;
import com.lee.eshop.order.dto.OrderDTO;
import com.lee.eshop.order.dto.OrderItemDTO;
import com.lee.eshop.order.service.IOrderFacadeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自动发表评论的调度任务
 * @author s_xun_s@163.com
 */
@Component
public class AutoPublishCommentTask {

    private final IOrderFacadeService orderFacadeService;

    private final ICommentInfoService commentInfoService;



    public AutoPublishCommentTask(IOrderFacadeService orderFacadeService, ICommentInfoService commentInfoService) {
        this.orderFacadeService = orderFacadeService;
        this.commentInfoService = commentInfoService;
    }

    /**
     * 每隔10分钟检查一次
     */
    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void execute(){
        List<OrderDTO> orderDTOs = orderFacadeService.listNotPublishedCommentOrders();
        if (orderDTOs == null || orderDTOs.size() == 0) {
            return;
        }

        for (OrderDTO orderDTO : orderDTOs) {
            if (orderDTO == null || orderDTO.getOrderItemDTOS().size() == 0) {
                continue;
            }

            for (OrderItemDTO orderItemDTO : orderDTO.getOrderItemDTOS()) {

                commentInfoService.saveAutoCommentInfo(orderDTO, orderItemDTO);


            }

        }
    }

}
