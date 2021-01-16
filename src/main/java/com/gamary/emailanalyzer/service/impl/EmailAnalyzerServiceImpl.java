package com.gamary.emailanalyzer.service.impl;

import com.gamary.emailanalyzer.domain.Email;
import com.gamary.emailanalyzer.repository.EmailRepository;
import com.gamary.emailanalyzer.service.DTO.AnalyzerDecisionDTO;
import com.gamary.emailanalyzer.service.DTO.EmailDTO;
import com.gamary.emailanalyzer.service.EmailAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailAnalyzerServiceImpl implements EmailAnalyzerService {
    @Autowired
    private EmailRepository emailRepository;
    @Override
    public AnalyzerDecisionDTO findLongestEmail(List<EmailDTO> emails) {
        return emails.stream().max(((o1, o2) -> o1.getEmailContent().length()-o2.getEmailContent().length())).
                map(result -> new AnalyzerDecisionDTO("Email with subject: \""+result.getSubject()+"\" is the longest","Ask for summary")).get();
    }

    @Override
    public AnalyzerDecisionDTO findTheMostIrritatingSender() {
        return emailRepository.findAll().stream().collect(Collectors.groupingBy(Email::getSender)).entrySet().stream().
                max((o1,o2)->o1.getValue().stream().mapToInt(email -> email.getEmailContent().length()).sum() -
                        o2.getValue().stream().mapToInt(email -> email.getEmailContent().length()).sum()).
                map(entry -> new AnalyzerDecisionDTO("\""+entry.getKey()+"\" is the sender with longest emails in total","Silent")).get();
    }
}
