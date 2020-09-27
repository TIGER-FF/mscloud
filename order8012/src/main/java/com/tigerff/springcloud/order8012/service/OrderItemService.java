package com.tigerff.springcloud.order8012.service;

import com.tigerff.springcloud.order8012.entities.OrderItem;

import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/21 15:58
 */
public interface OrderItemService {
    /**
     * 这个是获取订单的详情--列出来订单里的orderItem
     * @param orderId
     * @return
     */
    List<OrderItem> getOrderItemsByOrderId(Long orderId);


    /**
     * 将 orderItem 加入到订单中
     * @param orderItem
     * @return
     */
    Integer insertOrder(OrderItem orderItem);
}
