package com.demo.project56.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageListener {
    public void receiveMessage(String message) {
        log.info("Received message: {}", message);
    }
}
