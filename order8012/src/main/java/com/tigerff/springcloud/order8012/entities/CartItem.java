package com.tigerff.springcloud.order8012.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 7:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Long cartItemId;
    private Long goodsId;
    private String goodsName;
    private Integer goodsNum;
    private double goodsPrice;
    private double cartItemPrice;
    private Long userId;
}
