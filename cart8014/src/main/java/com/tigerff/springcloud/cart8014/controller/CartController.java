package com.tigerff.springcloud.cart8014.controller;

import com.tigerff.springcloud.cart8014.service.CartService;
import com.tigerff.springcloud.commons.entities.CartItem;
import com.tigerff.springcloud.commons.entities.CommonResult;
import com.tigerff.springcloud.commons.entities.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 9:01
 */
@RestController
@Slf4j
public class CartController {

    @Autowired
    CartService cartService;

    /**
     * 添加到购物车
     * @param cartItem
     * @return
     */
    @PostMapping("/cart")
    public CommonResult insertCartItem(@RequestBody CartItem cartItem)
    {
        Integer status=cartService.insertCartItem(cartItem);
        if(status==1)
        {
            log.info("查询成功"+status);
            return new CommonResult(200,"查询成功了",status);
        }
        else
            return new CommonResult(500,"没有找到",null);
    }

    /**
     * 根据用户的id去查询用户的购物车进行分页
     * @param userId
     * @return
     */
    @GetMapping("/cart")
    public CommonResult getCartItemPageByUserId(@RequestParam("userId") Long userId, @RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "size",defaultValue = "2") Integer size)
    {
        Page<CartItem> list=cartService.getCartItemPageByUserId(userId,page,size);
        if(list!=null)
        {
            log.info("查询成功"+list);
            return new CommonResult(200,"查询成功了",list);
        }
        else
            return new CommonResult(500,"没有找到",null);
    }

    /**
     * 根据id删除cartItem
     * @param cartItemId
     * @param userId
     * @return
     */
    @DeleteMapping("/cart/{id}")
    public CommonResult deleteCartItemById(@PathVariable("id") Long cartItemId,@RequestParam("userId") Long userId)
    {
        Integer status=cartService.deleteCartItemById(userId,cartItemId);
        if(status==1)
        {
            log.info("删除成功"+status);
            return new CommonResult(200,"删除成功了",status);
        }
        else
            return new CommonResult(500,"删除失败",null);
    }
}
