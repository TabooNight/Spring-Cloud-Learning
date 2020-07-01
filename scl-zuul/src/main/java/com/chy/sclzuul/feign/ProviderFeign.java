package com.chy.sclzuul.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务提供者
 *
 * @author chy
 * @date 2020-07-01 11:10
 */
@FeignClient(name = "scl-eureka-client-provider", fallbackFactory = ProviderFeignFallback.class)
public interface ProviderFeign {

    @GetMapping("/provider/info")
    Map<String, String> get();

}

@Component
class ProviderFeignFallback implements FallbackFactory<ProviderFeign> {

    @Override
    public ProviderFeign create(Throwable throwable) {
        return () -> {
            Map<String, String> map = new HashMap<>();
            map.put("errcode", "500");
            map.put("errmsg", "Provider异常，请稍后重试");
            return map;
        };
    }
}
