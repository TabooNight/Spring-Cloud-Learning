package com.chy.scleurekaclientconsumer.feign;

import com.chy.scleurekaclientconsumer.config.FeignConfig;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chy
 * @date 2020-06-15 18:00
 */
@FeignClient(name = "scl-eureka-client-provider", configuration = FeignConfig.class, fallbackFactory = TestFeignFallback.class)
public interface TestFeign {

    @GetMapping("/provider/info")
    Map<String, String> getTest();

}

@Component
class TestFeignFallback implements FallbackFactory<TestFeign> {

    private static final Logger log = LoggerFactory.getLogger(TestFeignFallback.class);

    @Override
    public TestFeign create(Throwable throwable) {
        return new TestFeign() {
            @Override
            public Map<String, String> getTest() {
                log.error("fallback; reason was: " + throwable);
                return new HashMap<>();
            }
        };
    }
}
