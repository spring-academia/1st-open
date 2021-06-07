package com.example.metricdemo.service;

import com.example.metricdemo.domain.Order;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class RequestOderUsecase {
    private final InMemoryRepository repository;
    private final Counter counter;

    public RequestOderUsecase(InMemoryRepository repository, MeterRegistry meterRegistry) {
        counter = Counter.builder("order.count")
                .tag("app", "order")
                .register(meterRegistry);
        this.repository = repository;
    }

    public void requestOder() {
        Order order = Order.createRandomOrder();
        repository.insertOrder(order);
//        counter.increment();
    }

}
