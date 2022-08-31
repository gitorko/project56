package com.demo.project56.controller;

import java.util.UUID;

import com.demo.project56.domain.Customer;
import com.demo.project56.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final RedisTemplate<String, Long> counterTemplate;
    private final StringRedisTemplate chatTemplate;
    private final CustomerRepository customerRepository;

    @GetMapping("/api/send/{message}")
    public void sendMessage(@PathVariable String message) {
        log.info("Sending message {}", message);
        chatTemplate.convertAndSend("chat", message);
    }

    @GetMapping("/api/inc")
    public Long incrementCounter() {
        return counterTemplate.opsForValue().increment("chat");
    }

    @PostMapping("/api/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/api/customer")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/api/send-queue/{message}")
    public void sendToQueue(@PathVariable String message) {
        log.info("Sending to queue {}", message);
        chatTemplate.opsForList().leftPush("app-key", message);
    }

    @GetMapping("/api/get-queue")
    public String getFromQueue() {
        return chatTemplate.opsForList().leftPop("app-key");
    }

}
