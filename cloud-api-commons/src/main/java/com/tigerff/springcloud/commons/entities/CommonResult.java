package com.tigerff.springcloud.commons.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个类主要用于数据的输出，并且将状态码和提示的信息以及获取的信息进行了封装
 * 屌！！！
 * @param <T>
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
