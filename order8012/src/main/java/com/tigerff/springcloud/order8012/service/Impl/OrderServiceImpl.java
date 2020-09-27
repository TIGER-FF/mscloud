package com.tigerff.springcloud.order8012.service.Impl;


import com.tigerff.springcloud.commons.entities.CartItem;
import com.tigerff.springcloud.commons.entities.Order;
import com.tigerff.springcloud.commons.entities.OrderItem;
import com.tigerff.springcloud.commons.entities.Page;
import com.tigerff.springcloud.order8012.dao.OrderDao;
import com.tigerff.springcloud.order8012.dao.OrderItemDao;
import com.tigerff.springcloud.order8012.service.OrderService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderItemDao orderItemDao;

    @Override
    public Page<Order> getOrderPage(Integer page, Integer size, Long userId) {
        Page<Order> list=new Page<>();
        Map<String,Object> map=new HashMap<>();
        map.put("page",(page-1)*size);
        map.put("size",size);
        map.put("userId",userId);
        list.setRows(orderDao.getOrderPage(map));
        list.setTotal(orderDao.getOrderCount(userId));
        list.setSize(size);
        list.setPage(page);
        return list;
    }



    @Override
    public List<OrderItem> getOrderALL(Long orderId) {
        return null;
    }

    @Override
    public OrderItem addOrder(Long orderId, String goodsName, Integer orderItemNum) {
        return null;
    }

    /**
     * 这个就是你在点击直接购买时候会自动创建一个订单，返回订单的号，将商品加入这个订单。
     * @param order
     * @return
     */
    @Override
    public Long createOrder(Order order) {
        orderDao.createOrder(order);
        return order.getOrderId();
    }

    /**
     * 根据订单的号去删除一个订单
     * @param orderId
     * @return
     */
    @Override
    public Integer deleteOrderById(Long orderId) {
        return orderDao.deleteOrderById(orderId);
    }



}
