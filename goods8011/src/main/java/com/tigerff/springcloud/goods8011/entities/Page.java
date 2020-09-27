package com.tigerff.springcloud.goods8011.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/20 15:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    private int page;//当前页
    private int size;//每页记录数
    private List<T> rows;//返回的记录集合
    private long total;//总记录条数
}
