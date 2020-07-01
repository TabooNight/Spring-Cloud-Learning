package com.chy.scleurekaserver.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web安全配置类
 *
 * @author chy
 * @date 2020-06-15 10:54
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf校验，解决无法注册到服务注册中心的问题
        http.csrf().disable();
        super.configure(http);
    }
}
