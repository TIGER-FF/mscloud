package com.tigerff.springcloud.goods8011.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/23 10:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long categoryId;
    private String categoryName;
}
