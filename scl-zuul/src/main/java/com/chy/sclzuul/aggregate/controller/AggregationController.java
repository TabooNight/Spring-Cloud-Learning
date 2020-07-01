package com.chy.sclzuul.aggregate.controller;

import com.chy.sclzuul.aggregate.service.AggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;
import java.util.Map;

/**
 * 聚合控制层
 *
 * @author chy
 * @date 2020-07-01 11:20
 */
@RestController
@RequestMapping("/aggregate")
public class AggregationController {

    private static final Logger log = LoggerFactory.getLogger(AggregationController.class);

    private final AggregationService aggregationService;

    @Autowired
    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping
    public DeferredResult<Map> aggregate() {
        Observable<Map> result = this.aggregateObservable();
        return this.toDeferredResult(result);
    }

    private DeferredResult<Map> toDeferredResult(Observable<Map> result) {
        DeferredResult<Map> deferredResult = new DeferredResult<>();
        result.subscribe(new Observer<Map>() {
            @Override
            public void onCompleted() {
                log.info("执行完成...");
            }

            @Override
            public void onError(Throwable e) {
                log.info("执行失败：" + e.toString());
            }

            @Override
            public void onNext(Map map) {
                log.info("onNext...");
                deferredResult.setResult(map);
            }
        });
        return deferredResult;
    }

    private Observable<Map> aggregateObservable() {
        return Observable.zip(
                this.aggregationService.getByConsumer(),
                this.aggregationService.getByProvider(),
                (consumer, provider) -> {
                    Map<String, Map<String, String>> map = new HashMap<>();
                    map.put("consumer", consumer);
                    map.put("provider", provider);
                    return map;
                }
        );
    }
}
