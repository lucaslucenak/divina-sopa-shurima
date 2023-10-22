package com.lucaslucenak.Shurima.controllers;

import com.lucaslucenak.Shurima.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "order/details")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<Object> getOrderCancellationReasons(@PathVariable UUID orderId, @RequestHeader("Authorization") String accessToken) {
        return ResponseEntity.ok().body(orderDetailsService.getOrderDetails(orderId, accessToken));
    }
}
