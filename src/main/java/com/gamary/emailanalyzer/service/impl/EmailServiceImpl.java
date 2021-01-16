package com.gamary.emailanalyzer.service.impl;

import com.gamary.emailanalyzer.domain.Email;
import com.gamary.emailanalyzer.repository.EmailRepository;
import com.gamary.emailanalyzer.service.DTO.AnalyzerDecisionDTO;
import com.gamary.emailanalyzer.service.DTO.EmailDTO;
import com.gamary.emailanalyzer.service.EmailAnalyzerService;
import com.gamary.emailanalyzer.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailAnalyzerService emailAnalyzerService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnalyzerDecisionDTO saveEmails(List<EmailDTO> newEmails) {
        newEmails.stream().forEach(ne -> emailRepository.save(modelMapper.map(ne,Email.class)) );

        return emailAnalyzerService.findLongestEmail(newEmails);
    }
}
