package com.chy.scleurekaclientprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chy
 * @date 2020-06-12 14:43
 */
@RestController
@RequestMapping("/provider")
public class TestController {

    @GetMapping("/info")
    public Map<String, String> get() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("application.name", "eureka-client-provider");
        map.put("server.port", "8080");
        return map;
    }

}
