package com.example.metricdemo.domain;

import java.util.Random;

public class Order {
    private static Random random = new Random();
    final int productCount;
    final int price;

    public Order(int productCount, int price) {
        this.productCount = productCount;
        this.price = price;
    }


    public int getProductCount() {
        return productCount;
    }

    public int getPrice() {
        return price;
    }

    public static Order createRandomOrder() {
        int count = random.nextInt(3) + 1;
        int price = random.nextInt(10000) * 10 + 100;
        return new Order(count, price);
    }
}
