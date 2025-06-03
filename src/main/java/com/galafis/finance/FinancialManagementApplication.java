package com.galafis.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Financial Management System
 * @author Gabriel Demetrios Lafis
 */
@SpringBootApplication
@RestController
public class FinancialManagementApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FinancialManagementApplication.class, args);
    }
    
    @GetMapping("/")
    public String home() {
        return "Financial Management System - Gabriel Lafis";
    }
    
    @GetMapping("/api/health")
    public String health() {
        return "System is running successfully!";
    }
}
