package com.gamary.emailanalyzer.service;

import com.gamary.emailanalyzer.service.DTO.AnalyzerDecisionDTO;
import com.gamary.emailanalyzer.service.DTO.EmailDTO;

import java.util.List;

public interface EmailAnalyzerService {
    AnalyzerDecisionDTO findLongestEmail(List<EmailDTO> emails);
    AnalyzerDecisionDTO findTheMostIrritatingSender();
}
