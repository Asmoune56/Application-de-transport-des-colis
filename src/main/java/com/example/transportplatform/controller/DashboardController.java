package com.example.transportplatform.controller;

import com.example.transportplatform.dto.DashboardStatsDTO;
import com.example.transportplatform.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/stats")
    public DashboardStatsDTO getDashboardStats() {
        return dashboardService.getDashboardStats();
    }
}
