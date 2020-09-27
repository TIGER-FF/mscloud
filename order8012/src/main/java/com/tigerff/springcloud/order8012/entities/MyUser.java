package com.tigerff.springcloud.order8012.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/21 22:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    private Long userId;
    private String userName;
    private String UserPassword;
    private String userPhone;
    private String userEmail;
    private String userQq;
}
