package com.tigerff.springcloud.goods8011.controller;


import com.tigerff.springcloud.commons.entities.Category;
import com.tigerff.springcloud.commons.entities.CommonResult;
import com.tigerff.springcloud.commons.entities.Goods;
import com.tigerff.springcloud.commons.entities.Page;
import com.tigerff.springcloud.goods8011.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class GoodsController {
    @Autowired
    GoodsService goodsService;


    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 根据id去获取到那个货物的信息
     * @param goodsId
     * @return
     */
    @GetMapping("/goods/{id}")
    public CommonResult<Goods> getGoodsById(@PathVariable("id") Long goodsId)
    {
        Goods goods = goodsService.getGoodsById(goodsId);

        if(goods!=null)
        {
            log.info("查询成功"+goods);
            return new CommonResult<Goods>(200,"查询成功了",goods);
        }
        else
            return new CommonResult<Goods>(500,"没有找到",null);
    }

    /**
     * 获取货物的分页
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/goods/page")
    public CommonResult<Page> getGoodsPage(Integer page,Integer size)
    {
        Page<Goods> list = goodsService.getGoodsPage(page,size);

        if(list!=null)
        {
            log.info("查询成功"+list);
            return new CommonResult<Page>(200,"查询成功了",list);
        }
        else
            return new CommonResult<Page>(500,"没有找到",null);
    }

    /**
     * 获取货物的种类列表
     * @return
     */
    @GetMapping("/goods/category")
    public CommonResult<List<Category>> getGoodsCategory()
    {
        List<Category> list=goodsService.getGoodsCategory();

        if(list!=null)
        {
            log.info("查询成功"+list);
            return new CommonResult<List<Category>>(200,"查询成功了",list);
        }
        else
            return new CommonResult<List<Category>>(500,"没有找到",null);
    }

    /**
     * 这个就是模拟获取热门商品的--其实就是获取商品的前四个
     * @return
     */
    @GetMapping("/goods/goodsHot")
    public CommonResult<List<Goods>> getGoodsHot()
    {
        List<Goods> list=goodsService.getGoodsHot();

        if(list!=null)
        {
            log.info("查询成功"+list);
            return new CommonResult<List<Goods>>(200,"查询成功了",list);
        }
        else
            return new CommonResult<List<Goods>>(500,"没有找到",null);
    }
    /**
     * 这个就是模拟获取特价商品的--其实就是获取商品的后四个
     * @return
     */
    @GetMapping("/goods/goodsSpecial")
    public CommonResult<Goods> getGoodsSpecial()
    {
        List<Goods> list=goodsService.getGoodsSpecial();

        if(list!=null)
        {
            log.info("查询成功"+list);
            return new CommonResult(200,"查询成功了",list);
        }
        else
            return new CommonResult(500,"没有找到",null);
    }

    /**
     * 根据搜索内容去模糊搜索货物的信息
     * @param searchText
     * @return
     */
    @GetMapping("/goods/search")
    public CommonResult getGoodsBySearchText(@RequestParam("searchText") String searchText)
    {
        List<Goods> list = goodsService.getGoodsBySearchText(searchText);

        if(list!=null)
        {
            log.info("查询成功"+list);
            return new CommonResult(200,"查询成功了",list);
        }
        else
            return new CommonResult(500,"没有找到",null);
    }

}
