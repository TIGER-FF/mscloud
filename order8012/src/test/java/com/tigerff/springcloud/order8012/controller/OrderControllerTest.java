package com.tigerff.springcloud.order8012.controller;

import com.alibaba.fastjson.JSONObject;
import com.tigerff.springcloud.commons.entities.Goods;
import com.tigerff.springcloud.commons.entities.Order;
import com.tigerff.springcloud.commons.entities.Page;
import com.tigerff.springcloud.order8012.service.OrderService;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/27 18:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @MockBean
    OrderService orderService;
    @Autowired
    MockMvc mockMvc;
    @Test
    public void getOrderPage() throws Exception {
        Page<Order> page=new Page<>();
        List<Order> list=new ArrayList<>();
        Order order=new Order(1l,12d,1l);
        list.add(order);
        page.setTotal(4);
        page.setSize(2);
        page.setRows(list);
        page.setPage(1);
        when(orderService.getOrderPage(1,2,1l)).thenReturn(page);
        mockMvc.perform(get("/order/page")
                .param("page","1")
                .param("size","1")
                .param("userId","1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void creatOrder() throws Exception {
        Order order=new Order(1l,12d,1l);
        when(orderService.createOrder(order)).thenReturn(1l);
        mockMvc.perform(post("/order")
                .content(JSONObject.toJSONString(order))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void deleteOrderById() {

    }
}