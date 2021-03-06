package com.chy.scleurekaclientconsumer.controller;

import com.chy.scleurekaclientconsumer.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chy
 * @date 2020-06-15 17:59
 */
@RefreshScope
@RestController
@RequestMapping("/consumer")
public class TestController {

    private final TestFeign feign;

    @Value("${profile}")
    private String profile;
    @Value("${password}")
    private String password;

    @Autowired
    public TestController(TestFeign feign) {
        this.feign = feign;
    }

    @GetMapping("/info")
    public Map<String, String> get() {
        return this.feign.getTest();
    }

    @GetMapping("/config")
    public Map<String, String> getConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("profile", this.profile);
        map.put("password", password);
        return map;
    }

}
