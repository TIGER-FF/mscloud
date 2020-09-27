package com.tigerff.springcloud.cart8014.controller;

import com.alibaba.fastjson.JSONObject;
import com.tigerff.springcloud.cart8014.service.CartService;
import com.tigerff.springcloud.cart8014.entities.CartItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/27 19:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {
    @MockBean
    CartService cartService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void insertCartItem() throws Exception {
        CartItem cartItem=new CartItem(1l,1l,"w",12,123d,12312d,1l);
        when(cartService.insertCartItem(cartItem)).thenReturn(1);
        mockMvc.perform(post("/cart")
                .content(JSONObject.toJSONString(cartItem))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getCartItemPageByUserId() throws Exception {
        CartItem cartItem=new CartItem(1l,1l,"w",12,123d,12312d,1l);
        when(cartService.insertCartItem(cartItem)).thenReturn(1);
        mockMvc.perform(get("/cart")
                .param("userId","1")
                .param("page","1")
                .param("size","2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

    }

    @Test
    public void deleteCartItemById() throws Exception {
        when(cartService.deleteCartItemById(1l,1l)).thenReturn(1);
        mockMvc.perform(delete("/cart/{id}",1l)
                .param("userId","1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}