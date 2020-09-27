package com.tigerff.springcloud.order8012.controller;

import com.tigerff.springcloud.commons.entities.CommonResult;
import com.tigerff.springcloud.commons.entities.OrderItem;
import com.tigerff.springcloud.order8012.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/21 16:00
 */
@RestController
@Slf4j
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;
    /**
     * 这个是获取订单的详情--列出来订单里的orderItem
     * @param orderId
     * @return
     */
    @GetMapping(value = "/order/{id}")
    public List<OrderItem> getOrder(@PathVariable("id") Long orderId)
    {
        return orderItemService.getOrderItemsByOrderId(orderId);
    }

    /**
     * 将买的东西加入到订单中
     * @param orderItem
     * @return
     */
    @PostMapping(value = "/order/orderItem")
    public CommonResult insertOrder(@RequestBody OrderItem orderItem)
    {
        Integer status = orderItemService.insertOrder(orderItem);
        if(status==1)
        {
            log.info("查询成功"+status);
            return new CommonResult(200,"创建成功了",status);
        }
        else
            return new CommonResult(500,"创建失败",null);
    }

}
