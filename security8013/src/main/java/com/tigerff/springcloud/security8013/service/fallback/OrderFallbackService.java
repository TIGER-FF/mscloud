package com.tigerff.springcloud.security8013.service.fallback;

import com.tigerff.springcloud.security8013.entities.CommonResult;
import com.tigerff.springcloud.security8013.entities.Order;
import com.tigerff.springcloud.security8013.entities.OrderItem;
import com.tigerff.springcloud.security8013.service.OrderFeignService;
import org.springframework.stereotype.Component;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/27 11:41
 */
@Component
public class OrderFallbackService implements OrderFeignService {
    /**
     * 这个就是你在点击直接购买时候会自动创建一个订单，返回订单的号，将商品加入这个订单。
     *
     * @param order
     * @return
     */
    @Override
    public CommonResult creatOrder(Order order) {
        return new CommonResult(500,"error",null);
    }

    /**
     * 将买的东西加入到订单中
     *
     * @param orderItem
     * @return
     */
    @Override
    public CommonResult insertOrder(OrderItem orderItem) {
        return new CommonResult(500,"error",null);
    }
}
