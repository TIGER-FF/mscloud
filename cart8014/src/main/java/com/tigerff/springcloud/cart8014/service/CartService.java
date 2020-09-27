package com.tigerff.springcloud.cart8014.service;

import com.tigerff.springcloud.commons.entities.CartItem;
import com.tigerff.springcloud.commons.entities.Page;

import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 9:03
 */
public interface CartService {
    /**
     * 添加到购物车--插入cartItem
     * @param cartItem
     * @return
     */
    Integer insertCartItem(CartItem cartItem);

    /**
     * 根据用户的id去查询用户的购物车进行分页
     * @param userId
     * @return
     */
    Page<CartItem> getCartItemPageByUserId(Long userId,Integer page,Integer size);

    /**
     * 根据购物车得号去删除一个cartItem
     * @param userId
     * @param cartItemId
     * @return
     */
    Integer deleteCartItemById(Long userId, Long cartItemId);
}
