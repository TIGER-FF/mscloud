package com.tigerff.springcloud.goods8011.dao;

import com.tigerff.springcloud.commons.entities.Category;
import com.tigerff.springcloud.commons.entities.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * 根据id去获取到哟个货物的信息
     * @param id
     * @return
     */
    Goods getGoodsById(Long id);

    /**
     * 获取货物的分页
     * @param page
     * @param size
     * @return
     */
    List<Goods> getGoodsPage(Integer page, Integer size);

    /**
     * 获取货物的总数量
     * @return
     */
    Long getGoodsCount();

    /**
     * 获取货物的种类列表
     * @return
     */
    List<Category> getGoodsCategory();
    /**
     * 这个就是模拟获取热门商品的--其实就是获取商品的前四个
     * @return
     */
    List<Goods> getGoodsHot();


    /**
     * 这个就是模拟获取特价商品的--其实就是获取商品的后四个
     * @return
     */
    List<Goods> getGoodsSpecial();

    /**
     * 根据搜索内容去模糊搜索货物的信息
     * @param searchText
     * @return
     */
    List<Goods> getGoodsBySearchText(@Param("searchText") String searchText);
}
