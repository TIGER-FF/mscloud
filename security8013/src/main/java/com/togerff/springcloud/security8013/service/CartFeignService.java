package com.togerff.springcloud.security8013.service;

import com.tigerff.springcloud.commons.entities.CartItem;
import com.tigerff.springcloud.commons.entities.CommonResult;
import com.togerff.springcloud.security8013.service.fallback.CartFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 14:25
 */
@Service
//这一块写在eureka注册的id就可以自动的实现负载均衡---其实还是ribbon的负载均衡
@FeignClient(value = "cloud-cart-service",fallback = CartFallbackService.class)
public interface CartFeignService {
    /**
     * 添加到购物车
     * @param cartItem
     * @return
     */
    @PostMapping("/cart")
    CommonResult insertCartItem(@RequestBody CartItem cartItem);
    /**
     * 根据用户的id去查询用户的购物车进行分页
     * @param userId
     * @return
     */
    @GetMapping("/cart")
    CommonResult getCartItemPageByUserId(@RequestParam("userId") Long userId, @RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "size",defaultValue = "2") Integer size);
    /**
     * 根据id删除cartItem
     * @param cartItemId
     * @param userId
     * @return
     */
    @DeleteMapping("/cart/{id}")
    CommonResult deleteCartItemById(@PathVariable("id") Long cartItemId, @RequestParam("userId") Long userId);
}
