package com.chy.sclzuul.aggregate.service;

import com.chy.sclzuul.feign.ConsumerFeign;
import com.chy.sclzuul.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.Map;

/**
 * 聚合服务类
 *
 * @author chy
 * @date 2020-07-01 10:55
 */
@Service
public class AggregationService {

    private final ConsumerFeign consumerFeign;
    private final ProviderFeign providerFeign;

    @Autowired
    public AggregationService(ConsumerFeign consumerFeign, ProviderFeign providerFeign) {
        this.consumerFeign = consumerFeign;
        this.providerFeign = providerFeign;
    }

    public Observable<Map> getByConsumer() {
        return Observable.create(observer -> {
            Map<String, String> map = this.consumerFeign.get();
            observer.onNext(map);
            observer.onCompleted();
        });
    }

    public Observable<Map> getByProvider() {
        return Observable.create(observer -> {
            Map<String, String> map = this.providerFeign.get();
            observer.onNext(map);
            observer.onCompleted();
        });
    }
}
