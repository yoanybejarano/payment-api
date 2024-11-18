package com.hatefulbug.payment.api.controller;

import com.hatefulbug.payment.api.model.AuditLog;
import com.hatefulbug.payment.api.reponse.ApiResponse;
import com.hatefulbug.payment.api.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {
    private final AuditLogService logService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> getLogsByUser(@PathVariable int userId) {
        List<AuditLog> logs = logService.getLogsByUser(userId);
        return new ResponseEntity<>(new ApiResponse(logs, "Logs obtained success"), HttpStatus.OK);
    }

    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity<ApiResponse> getLogsByDates(@PathVariable Date from, @PathVariable Date to) {
        List<AuditLog> logs = logService.getLogsByDateRange(from, to) ;
        return new ResponseEntity<>(new ApiResponse(logs, "Logs successfully obtained"), HttpStatus.OK);
    }

}
