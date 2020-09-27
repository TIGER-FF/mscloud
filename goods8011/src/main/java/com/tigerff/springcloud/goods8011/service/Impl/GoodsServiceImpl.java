package com.tigerff.springcloud.goods8011.service.Impl;

import com.tigerff.springcloud.goods8011.entities.Category;
import com.tigerff.springcloud.goods8011.entities.Goods;
import com.tigerff.springcloud.goods8011.entities.Page;
import com.tigerff.springcloud.goods8011.dao.GoodsDao;
import com.tigerff.springcloud.goods8011.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    /**
     * 根据id去获取到哟个货物的信息
     * @param id
     * @return
     */
    @Override
    public Goods getGoodsById(Long id) {
        return goodsDao.getGoodsById(id);
    }

    /**
     * 获取货物的分页
     * 加了redis的缓存，可以减少对数据库的访问
     * @param page
     * @param size
     * @return
     */
    @Override
    @Cacheable(value = "goods",key = "#page",unless = "#result == null")//设置缓存，和缓存的key
    public Page<Goods> getGoodsPage(Integer page, Integer size) {
        Page<Goods> list=new Page<>();
        list.setRows(goodsDao.getGoodsPage((page-1)*size, size));
        list.setPage(page);
        list.setSize(size);
        list.setTotal(goodsDao.getGoodsCount());
        return list;
    }

    /**
     * 获取货物的种类列表
     * 加了redis的缓存，可以减少对数据库的访问
     * @return
     */
    @Override
    @Cacheable(value = "goods",unless = "#result == null")//设置缓存，和缓存的key
    public List<Category> getGoodsCategory() {
        return goodsDao.getGoodsCategory();
    }

    /**
     * 这个就是模拟获取热门商品的--其实就是获取商品的前四个
     * @return
     */
    @Override
    public List<Goods> getGoodsHot() {

        return goodsDao.getGoodsHot();
    }
    /**
     * 这个就是模拟获取特价商品的--其实就是获取商品的后四个
     * @return
     */
    @Override
    public List<Goods> getGoodsSpecial() {
        return goodsDao.getGoodsSpecial();
    }

    /**
     * 根据搜索内容去模糊搜索货物的信息
     * @param searchText
     * @return
     */
    @Override
    public List<Goods> getGoodsBySearchText(String searchText) {
        return goodsDao.getGoodsBySearchText(searchText);
    }


}
