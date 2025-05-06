//package com.agroconnect.frogger.controller;
//
//import com.agroconnect.frogger.entity.Delivery;
//import com.agroconnect.frogger.service.DeliveryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/deliveries")
//public class DeliveryController {
//    @Autowired
//    private DeliveryService deliveryService;
//
//    @PutMapping("/{id}/status")
//    public ResponseEntity<Delivery> updateDeliveryStatus(@PathVariable Long id, @RequestParam String status) {
//        return ResponseEntity.ok(deliveryService.updateDeliveryStatus(Math.toIntExact(id), status));
//    }
//}