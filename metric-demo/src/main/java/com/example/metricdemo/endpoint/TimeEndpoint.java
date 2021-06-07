package com.example.metricdemo.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.time.LocalDateTime;

@Endpoint(id = "time")
public class TimeEndpoint {
    @ReadOperation
    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
