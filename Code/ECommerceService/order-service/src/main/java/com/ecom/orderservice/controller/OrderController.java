package com.ecom.orderservice.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @GetMapping("/{orderId}")
    public ResponseEntity<String> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok("Hello");
    }
}
