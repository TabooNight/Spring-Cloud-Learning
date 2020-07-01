package com.chy.scleurekaclientconsumer.controller;

import com.chy.scleurekaclientconsumer.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author chy
 * @date 2020-06-15 17:59
 */
@RestController
@RequestMapping("/consumer")
public class TestController {

    private final TestFeign feign;

    @Autowired
    public TestController(TestFeign feign) {
        this.feign = feign;
    }

    @GetMapping("/info")
    public Map<String, String> get() {
        return this.feign.getTest();
    }

}