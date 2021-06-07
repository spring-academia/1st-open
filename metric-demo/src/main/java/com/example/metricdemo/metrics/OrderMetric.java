package com.example.metricdemo.metrics;

import com.example.metricdemo.service.InMemoryRepository;
import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class OrderMetric {

    InMemoryRepository repository;


    public OrderMetric(MeterRegistry meterRegistry, InMemoryRepository repository) {
        FunctionCounter.builder("product.count", repository, InMemoryRepository::getTotalCount)
                .description("주문서 상 판매된 갯수")
                .register(meterRegistry);

        FunctionCounter.builder("product.price", repository, InMemoryRepository::getTotalPrice)
                .description("주문서 상 금액")
                .register(meterRegistry);
    }
}
