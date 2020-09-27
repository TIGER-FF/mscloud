package com.tigerff.springcloud.security8013.service;

import com.tigerff.springcloud.security8013.entities.CommonResult;
import com.tigerff.springcloud.security8013.entities.Order;
import com.tigerff.springcloud.security8013.entities.OrderItem;
import com.tigerff.springcloud.security8013.service.fallback.OrderFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 22:34
 */
@FeignClient(value = "cloud-order-service",fallback = OrderFallbackService.class)
public interface OrderFeignService {
    /**
     * 这个就是你在点击直接购买时候会自动创建一个订单，返回订单的号，将商品加入这个订单。
     * @param order
     * @return
     */
    @PostMapping(value = "/order")
    CommonResult creatOrder(@RequestBody Order order);

    /**
     * 将买的东西加入到订单中
     * @param orderItem
     * @return
     */
    @PostMapping(value = "/order/orderItem")
    CommonResult insertOrder(@RequestBody OrderItem orderItem);
}
