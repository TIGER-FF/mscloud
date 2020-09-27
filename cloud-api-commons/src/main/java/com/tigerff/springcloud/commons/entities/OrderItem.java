package com.tigerff.springcloud.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/21 10:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Long orderItemId;
    private Long goodsId;
    private String goodsName;
    private Integer goodsNum;
    private Double goodsPrice;
    private Double orderItemPrice;
    private Long orderId;
}
