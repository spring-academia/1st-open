package com.example.metricdemo.service;


import com.example.metricdemo.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryRepository {
    final AtomicLong totalPrice = new AtomicLong();
    final AtomicLong totalCount = new AtomicLong();

    public void insertOrder(Order order) {
        totalPrice.addAndGet(order.getPrice());
        totalCount.addAndGet(order.getProductCount());
    }

    public long getTotalPrice() {
        return totalPrice.get();
    }

    public long getTotalCount() {
        return totalCount.get();
    }
}
