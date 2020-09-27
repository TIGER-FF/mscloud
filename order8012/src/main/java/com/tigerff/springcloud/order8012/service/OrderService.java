package com.tigerff.springcloud.order8012.service;


import com.tigerff.springcloud.order8012.entities.CartItem;
import com.tigerff.springcloud.order8012.entities.Order;
import com.tigerff.springcloud.order8012.entities.OrderItem;
import com.tigerff.springcloud.order8012.entities.Page;

import java.util.List;

public interface OrderService {
    /**
     * 这个是订单的分页的获取
     * @param page
     * @param size
     * @param userId
     * @return
     */
    Page<Order> getOrderPage(Integer page, Integer size, Long userId);

    List<OrderItem> getOrderALL(Long orderId);

    OrderItem addOrder(Long orderId,String goodsName,Integer orderItemNum);

    /**
     * 这个就是你在点击直接购买时候会自动创建一个订单，返回订单的号，将商品加入这个订单。
     * @param order
     * @return
     */
    Long createOrder(Order order);

    /**
     * 根据订单的号去删除一个订单
     * @param orderId
     * @return
     */
    Integer deleteOrderById(Long orderId);


}
