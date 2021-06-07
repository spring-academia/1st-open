package com.example.metricdemo.api;

import com.example.metricdemo.service.RequestOderUsecase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private final AtomicLong counter = new AtomicLong();
    private final Random random = new Random();
    private final RequestOderUsecase requestOderUsecase;

    public HelloController(RequestOderUsecase requestOderUsecase) {
        this.requestOderUsecase = requestOderUsecase;
    }

    @GetMapping("/hello/{percent}")
    public String hello(@PathVariable Integer percent) throws InterruptedException {
        if (random.nextInt(100) < percent) {
            int sleepTime = 100 + random.nextInt(500);
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            throw new RuntimeException("delayed");
        }
        return "world";
    }

    @GetMapping("/order")
    public void order() throws InterruptedException {
        requestOderUsecase.requestOder();
        TimeUnit.MILLISECONDS.sleep(100);
    }

    @GetMapping("/hello")
    public String world() {
        counter.incrementAndGet();
        return "world";
    }

    @GetMapping("/mon/counter")
    public long getCount() {
        return counter.get();
    }
}

