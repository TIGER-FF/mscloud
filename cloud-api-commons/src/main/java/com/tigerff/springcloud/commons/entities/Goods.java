package com.tigerff.springcloud.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/20 15:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Long goodsId;
    private String goodsName;
    private Double goodsPrice;
    private Long categoryId;
}
