package com.lucaslucenak.Shurima.controllers;

import com.lucaslucenak.Shurima.entities.OrderEventsPollingEntity;
import com.lucaslucenak.Shurima.services.OrderEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order/events")
public class OrderEventsController {

    @Autowired
    private OrderEventsService orderEventsService;

    @GetMapping(value = "/polling")
    public ResponseEntity<List<Object>> getOrderEventsPolling() {
        return ResponseEntity.ok().body(orderEventsService.getOrderEventsPolling());
    }
}
