package com.togerff.springcloud.security8013.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/24 8:43
 * 对错误进行统一的处理
 */
@Controller
public class MyErrorController implements ErrorController {

    @GetMapping("/error")
    public String getErrorPath(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        switch (statusCode) {
            case 404:
                return "index/404";
            default:
                return "index/others";
        }
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
