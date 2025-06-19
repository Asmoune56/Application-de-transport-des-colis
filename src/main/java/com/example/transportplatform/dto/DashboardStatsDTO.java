package com.example.transportplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardStatsDTO {
    private long usersCount;
    private long tripsCount;
    private long parcelsCount;
    private long requestsCount;
}
