package com.gamary.emailanalyzer.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyzerDecisionDTO {
    private String analysisMessage;
    private String analysisRecommendedAction;
}
