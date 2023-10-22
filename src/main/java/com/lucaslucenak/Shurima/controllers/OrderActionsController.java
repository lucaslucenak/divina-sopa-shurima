package com.lucaslucenak.Shurima.controllers;

import com.lucaslucenak.Shurima.services.OrderActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/order/actions")
public class OrderActionsController {

    @Autowired
    private OrderActionsService orderActionsService;

    @PostMapping(value = "/{orderId}/confirm")
    public ResponseEntity<Void> confirmOrderAction(@PathVariable UUID orderId) {
        return ResponseEntity.accepted().body(orderActionsService.confirmOrderAction(orderId));
    }
}
