package com.cricketnotifier.backend.alert.controller;

import com.cricketnotifier.backend.alert.dto.SubscribeRequest;
import com.cricketnotifier.backend.alert.entity.AlertPreference;
import com.cricketnotifier.backend.alert.service.AlertService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alert")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    // Subscribe
    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@Valid @RequestBody SubscribeRequest request) {

        alertService.subscribe(request);
        return ResponseEntity.ok("Subscribed successfully");
    }

    // Unsubscribe
    @PostMapping("/unsubscribe")
    public ResponseEntity<String> unsubscribe(@Valid @RequestBody SubscribeRequest request) {

        alertService.unsubscribe(request);
        return ResponseEntity.ok("Unsubscribed successfully");
    }

    // Get my subscriptions
    @GetMapping("/my")
    public ResponseEntity<List<AlertPreference>> getMyAlerts() {

        return ResponseEntity.ok(alertService.getMyAlerts());
    }
}
