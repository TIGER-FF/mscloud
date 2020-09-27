package com.tigerff.springcloud.order8012.dao;


import com.tigerff.springcloud.order8012.entities.Order;
import com.tigerff.springcloud.order8012.entities.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {

    List<Order> getOrderPage(Map<String,Object> map);
    Long getOrderCount(@Param("userId") Long userId);
    void createOrder(Order order);
    Integer deleteOrderById(@Param("orderId") Long orderId);


}
