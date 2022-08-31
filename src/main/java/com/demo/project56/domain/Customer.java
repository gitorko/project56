package com.demo.project56.domain;

import java.io.Serializable;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Customer")
@Data
public class Customer implements Serializable {

    @org.springframework.data.annotation.Id
    private String Id;
    private String name;
    private String city;
}
