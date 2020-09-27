package com.tigerff.springcloud.security8013.controller;

import com.alibaba.fastjson.JSONObject;
import com.tigerff.springcloud.security8013.entities.*;
import com.tigerff.springcloud.security8013.service.CartFeignService;
import com.tigerff.springcloud.security8013.service.UserService;
import com.tigerff.springcloud.security8013.service.GoodsFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 14:26
 */
@Controller
@Slf4j
public class CartController {
    private final String PREFIX_LOG = "log/";
    @Autowired
    CartFeignService cartFeignService;
    @Autowired
    UserService userService;
    @Autowired
    GoodsFeignService goodsFeignService;


    /**
     * 添加到购物车
     * @param cartItem
     * @return
     */
    @PostMapping("/log/cart")
    public String insertCartItem(@RequestBody CartItem cartItem, HttpServletResponse response) throws IOException {
        //获取用户的id
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUser myUser = userService.getUserByName(user.getUsername());
        cartItem.setUserId(myUser.getUserId());
        //计算出每一个购物项的总价格
        Goods goods = JSONObject.parseObject(JSONObject.toJSONString(goodsFeignService.getGoodsById(cartItem.getGoodsId()).getData()), Goods.class);
        cartItem.setGoodsName(goods.getGoodsName());
        cartItem.setGoodsPrice(goods.getGoodsPrice());
        cartItem.setCartItemPrice(cartItem.getGoodsNum()*goods.getGoodsPrice());

        log.info("*****"+cartItem.toString());
        //获取是否成功--1--成功  0--失败
        Object status=cartFeignService.insertCartItem(cartItem).getData();
        //转为json数据串
        String jsonString = JSONObject.toJSONString(status);
        Integer integer = JSONObject.parseObject(jsonString, Integer.class);
        String data="{\"data\":\"insert success\"}";
        log.info("******"+data);
        if(integer==1)
            response.getWriter().write(data);
        return null;
    }


    /**
     * 加载购物车中的所有东西
     * @return
     */
    @GetMapping("/log/cart")
    public String cart(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "size",defaultValue = "2") Integer size, Map<String,Object> map) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUser myUser = userService.getUserByName(user.getUsername());
        Long userId=myUser.getUserId();
        Object list=cartFeignService.getCartItemPageByUserId(userId,page,size).getData();
        Page page1 = JSONObject.parseObject(JSONObject.toJSONString(list), Page.class);
        log.info("******"+list.toString());
        map.put("list",page1.getRows());
        map.put("page",page1);
        map.put("userId",userId);
        //到这一块还需要商品的信息
        List goodsList=new ArrayList<>();
        return PREFIX_LOG+"cart";
    }
    /**
     * 根据id删除cartItem
     * @param cartItemId
     * @return
     */
    @DeleteMapping("/log/cart/{id}")
    public String getCartItemPageByUserId(@PathVariable("id") Long cartItemId,HttpServletResponse response) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUser myUser = userService.getUserByName(user.getUsername());
        Long userId=myUser.getUserId();
        CommonResult commonResult = cartFeignService.deleteCartItemById(cartItemId, userId);
        log.info("*******"+commonResult);
        String data="{\"data\":\"delete success\"}";
        response.getWriter().write(data);
        return null;
    }
}
