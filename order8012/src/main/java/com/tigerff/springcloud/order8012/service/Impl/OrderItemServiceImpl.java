package com.tigerff.springcloud.order8012.service.Impl;

import com.tigerff.springcloud.commons.entities.OrderItem;
import com.tigerff.springcloud.order8012.dao.OrderItemDao;
import com.tigerff.springcloud.order8012.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/21 15:59
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemDao orderItemDao;
    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return  orderItemDao.getOrderItemsByOrderId(orderId);
    }

    /**
     * 将 orderItem 加入到订单中
     *
     * @param orderItem
     * @return
     */
    @Override
    public Integer insertOrder(OrderItem orderItem) {
        return orderItemDao.insertOrder(orderItem);
    }
}
