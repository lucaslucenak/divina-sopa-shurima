package com.lucaslucenak.Shurima.controllers;

import com.lucaslucenak.Shurima.entities.OrderCancellationReasonEntity;
import com.lucaslucenak.Shurima.services.OrderActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/order/actions")
public class OrderActionsController {

    @Autowired
    private OrderActionsService orderActionsService;

    @PostMapping(value = "/{orderId}/confirm")
    public ResponseEntity<Void> confirmOrder(@PathVariable UUID orderId, @RequestHeader("Authorization") String accessToken) {
        return ResponseEntity.accepted().body(orderActionsService.confirmOrder(orderId, accessToken));
    }

    @PostMapping(value = "/{orderId}/startPreparation")
    public ResponseEntity<Void> startOrderPreparation(@PathVariable UUID orderId, @RequestHeader("Authorization") String accessToken) {
        return ResponseEntity.accepted().body(orderActionsService.startOrderPreparation(orderId, accessToken));
    }

    @PostMapping(value = "/{orderId}/readyToPickup")
    public ResponseEntity<Void> orderReadyToPickup(@PathVariable UUID orderId, @RequestHeader("Authorization") String accessToken) {
        return ResponseEntity.accepted().body(orderActionsService.orderReadyToPickup(orderId, accessToken));
    }

    @PostMapping(value = "/{orderId}/dispatch")
    public ResponseEntity<Void> dispatchOrder(@PathVariable UUID orderId, @RequestHeader("Authorization") String accessToken) {
        return ResponseEntity.accepted().body(orderActionsService.dispatchOrder(orderId, accessToken));
    }

    @GetMapping(value = "/{orderId}/cancellationReasons")
    public ResponseEntity<List<OrderCancellationReasonEntity>> getOrderCancellationReasons(@PathVariable UUID orderId, @RequestHeader("Authorization") String accessToken) {
        return ResponseEntity.accepted().body(orderActionsService.getOrderCancellationReasons(orderId, accessToken));
    }

}
