package com.gamary.emailanalyzer.web.rest;

import com.gamary.emailanalyzer.service.DTO.AnalyzerDecisionDTO;
import com.gamary.emailanalyzer.service.DTO.EmailDTO;
import com.gamary.emailanalyzer.service.EmailAnalyzerService;
import com.gamary.emailanalyzer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
@CrossOrigin
public class EmailResource {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailAnalyzerService emailAnalyzerService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity<AnalyzerDecisionDTO> createEmails(@RequestBody List<EmailDTO> emails)  {
        return ResponseEntity.status(HttpStatus.CREATED).body(emailService.saveEmails(emails));
    }
    @CrossOrigin
    @GetMapping("/analyser")
    public ResponseEntity<AnalyzerDecisionDTO> getTheMostIrritatingSender()  {
        return ResponseEntity.ok(emailAnalyzerService.findTheMostIrritatingSender());
    }
}
