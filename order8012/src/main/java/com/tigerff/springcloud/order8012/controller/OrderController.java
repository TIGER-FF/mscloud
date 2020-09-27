package com.tigerff.springcloud.order8012.controller;


import com.tigerff.springcloud.order8012.entities.*;
import com.tigerff.springcloud.order8012.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 这个是订单的分页的获取
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/order/page")
    public CommonResult getOrderPage(Long userId,Integer page, Integer size)
    {
        Page<Order> list= orderService.getOrderPage(page, size, userId);
        if(list!=null)
        {
            log.info("查询成功"+list);
            return new CommonResult(200,"查询成功了",list);
        }
        else
            return new CommonResult(500,"没有找到",null);
    }

    /**
     * 这个就是你在点击直接购买时候会自动创建一个订单，返回订单的号，将商品加入这个订单。
     * @return
     */
    @PostMapping(value = "/order")
    public CommonResult creatOrder(@RequestBody Order order)
    {
        Long orderId = orderService.createOrder(order);
        if(orderId!=null)
        {
            log.info("查询成功"+orderId);
            return new CommonResult(200,"创建成功了",orderId);
        }
        else
            return new CommonResult(500,"创建失败",null);
    }

    /**
     * 根据订单的号去删除一个订单
     * @param orderId
     * @return
     */
    @DeleteMapping(value = "/order/{id}")
    public CommonResult deleteOrderById(@PathVariable("id") Long orderId)
    {
        Integer status = orderService.deleteOrderById(orderId);
        if(status!=null)
        {
            log.info("查询成功"+status);
            return new CommonResult(200,"删除成功了",status);
        }
        else
            return new CommonResult(500,"删除失败",null);
    }



}
