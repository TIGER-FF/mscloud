package com.tigerff.springcloud.security8013.controller;

import com.alibaba.fastjson.JSONObject;
import com.tigerff.springcloud.security8013.entities.CartItem;
import com.tigerff.springcloud.security8013.entities.Category;
import com.tigerff.springcloud.security8013.entities.Goods;
import com.tigerff.springcloud.security8013.entities.MyUser;
import com.tigerff.springcloud.security8013.service.UserService;
import com.tigerff.springcloud.security8013.service.GoodsFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 这个就是用来访问templates下的html页面的
 * 直接访问不好看
 */

@Controller
@Slf4j
public class IndexController {
	private final String PREFIX_LOG = "log/";
	private final String PREFIX_INDEX = "index/";
	@Autowired
	GoodsFeignService goodsFeignService;

	@Autowired
    UserService userService;
	/**
	 * 欢迎页--加载基本信息
	 * @return
	 */
	@GetMapping("/")
	public String index(Map<String,Object> map) {
		//货物的分类类别
		Object categoryData =goodsFeignService.getGoodsCategory().getData();
		log.info("货物的分类类别"+categoryData.toString());
		map.put("goodsCategory",categoryData);
		//货物的热门物品
		Object goodsHotData = goodsFeignService.getGoodsHot().getData();
		log.info("货物的分类类别"+goodsHotData.toString());
		map.put("goodsHotData",goodsHotData);
		//货物的特价物品
		Object goodsSpecialData = goodsFeignService.getGoodsSpecial().getData();
		log.info("货物的分类类别"+goodsSpecialData.toString());
		map.put("goodsSpecialData",goodsSpecialData);

		return PREFIX_INDEX+"index";
	}
	@GetMapping("/index/top_part")
	public String top_part() {
		return PREFIX_INDEX+"top-part";
	}
	@GetMapping("/index/search_part")
	public String search_part() {
		return PREFIX_INDEX+"search-part";
	}
	@GetMapping("/log/order")
	public String order() {
		return PREFIX_LOG+"order";
	}
	@GetMapping("/log/fin_order")
	public String fin_order() {
		return PREFIX_LOG+"fin-order";
	}
	@GetMapping("/index/userimg_part")
	public String userimg_part() {
		return PREFIX_INDEX+"userimg-part";
	}

	@GetMapping("/index/register")
	public String register() {
		return PREFIX_INDEX+"register";
	}



	/**
	 * 获取货物的类别列表 并跳转到sortgoods页面
	 * @return
	 */
	@GetMapping("/index/goods/category")
	public String sortgoods(Map<String,Object> map) {
		List data =(List)goodsFeignService.getGoodsCategory().getData();
		log.info(data.toString());
		map.put("goodsCategory",data);
		return PREFIX_INDEX+"sortgoods";
	}

	/**
	 * 跳转到物品的详情页面
	 * @param goodsId
	 * @param map
	 * @return
	 */
	@GetMapping("/index/goodsinfo/goods/{id}")
	public String goodsinfo(@PathVariable("id") Long goodsId,Map<String,Object> map) {
		Object goods = goodsFeignService.getGoodsById(goodsId).getData();
		List goodsCategoryList =(List) goodsFeignService.getGoodsCategory().getData();
		//找出货物类别id对应的类别名字
		for(Object object:goodsCategoryList)
		{
			Category category = JSONObject.parseObject(JSONObject.toJSONString(object), Category.class);
			Goods goods1 = JSONObject.parseObject(JSONObject.toJSONString(goods), Goods.class);
			if(category.getCategoryId().equals(goods1.getCategoryId())) {
				log.info("物品类别"+category.getCategoryName());
				map.put("goodsCategory", category.getCategoryName());
				break;
			}
		}
		log.info("物品"+goods);
		map.put("goods",goods);
		return PREFIX_INDEX+"goodsinfo";
	}

	/**
	 * 跳到搜索界面，并且加载搜索的内容
	 * @return
	 */
	@GetMapping("/index/search")
	public String search(Map<String,Object> map,@RequestParam("searchText") String searchText) {
		map.put("searchText",searchText);
		List goodsBySearchText =(List)goodsFeignService.getGoodsBySearchText(searchText).getData();
		log.info("模糊查找"+goodsBySearchText);
		map.put("goodsBySearchText",goodsBySearchText);
		return PREFIX_INDEX+"search";
	}

	/**
	 * 跳转到user并且进行数据回显--将原来的数据显示出来
	 * @return
	 */
	@GetMapping("/log/user")
	public String user(Map<String,Object> map) {
		//获取到登录的用户名 这里的User对象是Spring-Security提供的User
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//根据登录后的用户姓名去查找用户的所以信息，进行回显
		map.put("user",userService.getUserByName(user.getUsername()));
		return PREFIX_LOG+"user";
	}


}
