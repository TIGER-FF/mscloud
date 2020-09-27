package com.tigerff.springcloud.goods8011.controller;

import com.tigerff.springcloud.goods8011.entities.Category;
import com.tigerff.springcloud.goods8011.entities.Goods;
import com.tigerff.springcloud.goods8011.entities.Page;
import com.tigerff.springcloud.goods8011.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/27 13:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GoodsControllerTest {
    @MockBean
    GoodsService goodsService;
    @Autowired
    MockMvc mockMvc;


    @Test
    public void getGoodsById() throws Exception {
        Goods goods=new Goods(1l,"w",12d,1l);
        when(goodsService.getGoodsById(1l)).thenReturn(goods);
        mockMvc.perform(get("/goods/{id}", 1l))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }


    @Test
    public void getGoodsPage() throws Exception {
        Page<Goods> page=new Page<>();
        List<Goods> list=new ArrayList<>();
        Goods goods=new Goods(1l,"w",12d,1l);
        list.add(goods);
        page.setTotal(4);
        page.setSize(2);
        page.setRows(list);
        page.setPage(1);
        when(goodsService.getGoodsPage(1,2)).thenReturn(page);
        mockMvc.perform(get("/goods/page")
                .param("page","1")
                .param("size","1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getGoodsCategory() throws Exception {
        List<Category> list=new ArrayList<>();
        Category category=new Category(1l,"phone");
        list.add(category);
        when(goodsService.getGoodsCategory()).thenReturn(list);
        mockMvc.perform(get("/goods/category"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

    }

    @Test
    public void getGoodsHot() throws Exception {
        List<Goods> list=new ArrayList<>();
        Goods goods=new Goods(1l,"w",12d,1l);
        list.add(goods);
        when(goodsService.getGoodsHot()).thenReturn(list);
        mockMvc.perform(get("/goods/goodsHot"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getGoodsSpecial() throws Exception {
        List<Goods> list=new ArrayList<>();
        Goods goods=new Goods(1l,"w",12d,1l);
        list.add(goods);
        when(goodsService.getGoodsSpecial()).thenReturn(list);
        mockMvc.perform(get("/goods/goodsSpecial"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getGoodsBySearchText() throws Exception {
        List<Goods> list=new ArrayList<>();
        Goods goods=new Goods(1l,"w",12d,1l);
        list.add(goods);
        when(goodsService.getGoodsBySearchText("w")).thenReturn(list);
        mockMvc.perform(get("/goods/search")
                .param("searchText","w"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}