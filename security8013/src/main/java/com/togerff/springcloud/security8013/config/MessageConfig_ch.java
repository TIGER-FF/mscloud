package com.togerff.springcloud.security8013.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


/**
 * 定制提示信息的语言
 * messageSource  bean名字为这
 */
@Configuration
public class MessageConfig_ch {
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasename("classpath:org/springframework/security/messages_zh_CN");
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }

}
