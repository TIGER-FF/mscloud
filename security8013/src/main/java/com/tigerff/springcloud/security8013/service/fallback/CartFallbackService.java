package com.tigerff.springcloud.security8013.service.fallback;

import com.tigerff.springcloud.security8013.entities.CartItem;
import com.tigerff.springcloud.security8013.entities.CommonResult;
import com.tigerff.springcloud.security8013.service.CartFeignService;
import org.springframework.stereotype.Component;

/**
 * 降级处理
 * @author tigerff
 * @version 1.0
 * @date 2020/9/27 11:38
 */
@Component
public class CartFallbackService implements CartFeignService {
    /**
     * 添加到购物车
     *
     * @param cartItem
     * @return
     */
    @Override
    public CommonResult insertCartItem(CartItem cartItem) {
        return new CommonResult(500,"error",null);
    }

    /**
     * 根据用户的id去查询用户的购物车进行分页
     *
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @Override
    public CommonResult getCartItemPageByUserId(Long userId, Integer page, Integer size) {
        return new CommonResult(500,"error",null);
    }

    /**
     * 根据id删除cartItem
     *
     * @param cartItemId
     * @param userId
     * @return
     */
    @Override
    public CommonResult deleteCartItemById(Long cartItemId, Long userId) {
        return new CommonResult(500,"error",null);
    }
}
