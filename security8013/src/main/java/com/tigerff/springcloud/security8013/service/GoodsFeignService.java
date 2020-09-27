package com.tigerff.springcloud.security8013.service;

import com.tigerff.springcloud.security8013.entities.CommonResult;
import com.tigerff.springcloud.security8013.entities.Goods;
import com.tigerff.springcloud.security8013.service.fallback.GoodsFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/23 10:17
 */
@Service
//这一块写在eureka注册的id就可以自动的实现负载均衡---其实还是ribbon的负载均衡
@FeignClient(value = "cloud-goods-service",fallback = GoodsFallbackService.class)
public interface GoodsFeignService {
    /**
     * 获取货物的种类列表
     * @return
     */
    @GetMapping("/goods/category")
    CommonResult getGoodsCategory();

    /**
     * 这个就是模拟获取特价商品的--其实就是获取商品的后四个
     * @return
     */
    @GetMapping("/goods/goodsSpecial")
    CommonResult getGoodsSpecial();
    /**
     * 这个就是模拟获取热门商品的--其实就是获取商品的前四个
     * @return
     */
    @GetMapping("/goods/goodsHot")
    CommonResult getGoodsHot();

    /**
     * 根据id去获取到哟个货物的信息
     * @param id
     * @return
     */
    @GetMapping("/goods/{id}")
    CommonResult getGoodsById(@PathVariable("id") Long id);

    /**
     * 根据id去获取到那个货物的类别
     * @param categoryId
     * @return
     */
    @GetMapping("/category/{id}")
    CommonResult getCategoryById(@PathVariable("id") Long categoryId);


    /**
     * 根据搜索内容去模糊搜索货物的信息
     * @param searchText
     * @return
     */
    @GetMapping("/goods/search")
    CommonResult getGoodsBySearchText(@RequestParam("searchText") String searchText);
}
