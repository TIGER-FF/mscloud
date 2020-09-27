package com.togerff.springcloud.security8013.controller;

import com.alibaba.fastjson.JSONObject;
import com.tigerff.springcloud.commons.entities.*;
import com.togerff.springcloud.security8013.service.OrderFeignService;
import com.togerff.springcloud.security8013.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 22:34
 */
@Controller
@Slf4j
public class OrderController {
    @Autowired
    OrderFeignService orderFeignService;
    @Autowired
    UserService userService;
    @PostMapping("/log/order/goods")
    public String addGoodsToOrder(@RequestBody  OrderItem orderItem, HttpServletResponse response) throws IOException {
        log.info("*********"+orderItem);
        //求出价格
        Double price=orderItem.getGoodsPrice()*orderItem.getGoodsNum();
        //这是创建了一个新的订单
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUser myUser = userService.getUserByName(user.getUsername());
        Order order=new Order();
        order.setUserId(myUser.getUserId());
        order.setOrderPrice(price);
        Long orderId = JSONObject.parseObject(JSONObject.toJSONString(orderFeignService.creatOrder(order).getData()), Long.class);
        orderItem.setOrderId(orderId);
        orderItem.setOrderItemPrice(price);
        //将商品加入到新的订单中
        CommonResult commonResult = orderFeignService.insertOrder(orderItem);
        String data="{\"data\":\"order success\"}";
        response.getWriter().write(data);
        return null;
    }
}
