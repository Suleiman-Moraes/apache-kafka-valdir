package com.moraes.strproducer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moraes.strproducer.service.StringProducerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "producer")
@RequiredArgsConstructor
public class StringProducerController {

    private final StringProducerService service;

    @PostMapping
    public ResponseEntity<Object> sendMessage(@RequestBody String message) {
        service.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
