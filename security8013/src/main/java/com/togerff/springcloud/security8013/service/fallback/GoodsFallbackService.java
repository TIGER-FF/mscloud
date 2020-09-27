package com.togerff.springcloud.security8013.service.fallback;

import com.tigerff.springcloud.commons.entities.Category;
import com.tigerff.springcloud.commons.entities.CommonResult;
import com.togerff.springcloud.security8013.service.GoodsFeignService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/27 11:40
 */
@Component
@Slf4j
public class GoodsFallbackService implements GoodsFeignService {
    /**
     * 获取货物的种类列表
     *
     * @return
     */
    @Override
    public CommonResult getGoodsCategory() {
        log.error("降级了");
        //降级--返回我自己的数据
        return new CommonResult(500,"error","降级了");
    }

    /**
     * 这个就是模拟获取特价商品的--其实就是获取商品的后四个
     *
     * @return
     */
    @Override
    public CommonResult getGoodsSpecial() {
        log.error("getGoodsSpecial---降级了");
        //降级--返回我自己的数据
        return new CommonResult(500,"error","降级了");
    }

    /**
     * 这个就是模拟获取热门商品的--其实就是获取商品的前四个
     *
     * @return
     */
    @Override
    public CommonResult getGoodsHot() {
        log.error("getGoodsHot----降级了");
        //降级--返回我自己的数据
        return new CommonResult(500,"error","降级了");
    }

    /**
     * 根据id去获取到哟个货物的信息
     *
     * @param id
     * @return
     */
    @Override
    public CommonResult getGoodsById(Long id) {
        log.error("getGoodsById----降级了");
        //降级--返回我自己的数据
        return new CommonResult(500,"error","降级了");
    }

    /**
     * 根据id去获取到那个货物的类别
     *
     * @param categoryId
     * @return
     */
    @Override
    public CommonResult getCategoryById(Long categoryId) {
        log.error("getCategoryById----降级了");
        //降级--返回我自己的数据
        return new CommonResult(500, "error", "降级了");
    }
    /**
     * 根据搜索内容去模糊搜索货物的信息
     *
     * @param searchText
     * @return
     */
    @Override
    public CommonResult getGoodsBySearchText(String searchText) {
            log.error("getGoodsBySearchText----降级了");
            //降级--返回我自己的数据
            return new CommonResult(500,"error","降级了");
    }
}
