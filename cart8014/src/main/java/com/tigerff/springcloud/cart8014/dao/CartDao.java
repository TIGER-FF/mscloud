package com.tigerff.springcloud.cart8014.dao;

import com.tigerff.springcloud.cart8014.entities.CartItem;
import com.tigerff.springcloud.cart8014.entities.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 10:44
 */
@Mapper
public interface CartDao {
    /**
     * 添加到购物车--插入cartItem
     * @param cartItem
     * @return
     */
    Integer insertCartItem(CartItem cartItem);
    /**
     * 根据用户的id去查询用户的购物车进行分页
     * @return
     */
    List<CartItem> getCartItemPageByUserId(Map<String,Object> map);

    /**
     * 获取CartItem的总数量
     * @return
     */
    Long getCartItemCount();

    /**
     * 根据购物车得号去删除一个cartItem
     * @param userId
     * @param cartItemId
     * @return
     */
    Integer deleteCartItemById(@Param("userId") Long userId,@Param("cartItemId") Long cartItemId);
}
