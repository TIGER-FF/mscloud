package com.tigerff.springcloud.order8012.dao;

import com.tigerff.springcloud.commons.entities.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/21 11:01
 */
@Mapper
public interface OrderItemDao {
    List<OrderItem> getOrderItemsByOrderId(@Param("orderId") Long orderId);

    /**
     * 将 orderItem 加入到订单中
     * @param orderItem
     * @return
     */
    Integer insertOrder(OrderItem orderItem);
}
