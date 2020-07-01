package com.chy.sclzuul.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务消费者
 *
 * @author chy
 * @date 2020-07-01 10:58
 */
@FeignClient(name = "scl-eureka-client-consumer", fallbackFactory = ConsumerFeignFallback.class)
public interface ConsumerFeign {

    @GetMapping("/consumer/info")
    Map<String, String> get();

}

@Component
class ConsumerFeignFallback implements FallbackFactory<ConsumerFeign> {

    @Override
    public ConsumerFeign create(Throwable throwable) {
        return () -> {
            Map<String, String> map = new HashMap<>();
            map.put("errcode", "500");
            map.put("errmsg", "Consumer异常，请稍后重试");
            return map;
        };
    }
}
