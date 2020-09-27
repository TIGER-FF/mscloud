package com.tigerff.springcloud.order8012.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.tigerff.springcloud.commons.entities.OrderItem;
import com.tigerff.springcloud.order8012.service.OrderItemService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.util.MultiValueMap.*;
/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/27 18:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderItemControllerTest {
    @MockBean
    OrderItemService orderItemService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void insertOrder() throws Exception {
        OrderItem orderItem=new OrderItem(1l,1l,"w",7,13d,34d,1l);
        when(orderItemService.insertOrder(orderItem)).thenReturn(1);

        mockMvc.perform(post("/order/orderItem")
                .content(JSONObject.toJSONString(orderItem))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}