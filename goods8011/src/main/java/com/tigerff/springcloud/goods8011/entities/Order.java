package com.tigerff.springcloud.goods8011.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/21 10:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private Double orderPrice;
    private Long userId;
}
