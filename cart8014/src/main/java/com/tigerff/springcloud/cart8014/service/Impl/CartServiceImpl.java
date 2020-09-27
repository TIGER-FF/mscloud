package com.tigerff.springcloud.cart8014.service.Impl;

import com.tigerff.springcloud.cart8014.dao.CartDao;
import com.tigerff.springcloud.cart8014.service.CartService;
import com.tigerff.springcloud.commons.entities.CartItem;
import com.tigerff.springcloud.commons.entities.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 9:04
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    /**
     * 添加到购物车--插入cartItem
     *
     * @param cartItem
     * @return
     */
    @Override
    public Integer insertCartItem(CartItem cartItem) {

        return cartDao.insertCartItem(cartItem);
    }

    /**
     * 根据用户的id去查询用户的购物车进行分页
     *
     * @param userId
     * @return
     */
    @Override
    public Page<CartItem> getCartItemPageByUserId(Long userId,Integer page,Integer size) {
        Page<CartItem> list=new Page<>();
        list.setPage(page);
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("page",(page-1)*size);
        map.put("size",size);
        list.setRows(cartDao.getCartItemPageByUserId(map));
        list.setSize(size);
        list.setTotal(cartDao.getCartItemCount());
        return list;
    }

    /**
     * 根据购物车得号去删除一个cartItem
     *
     * @param userId
     * @param cartItemId
     * @return
     */
    @Override
    public Integer deleteCartItemById(Long userId, Long cartItemId) {
        return cartDao.deleteCartItemById(userId,cartItemId);
    }
}
