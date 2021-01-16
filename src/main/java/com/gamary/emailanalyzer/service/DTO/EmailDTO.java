package com.gamary.emailanalyzer.service.DTO;

import lombok.Data;

@Data
public class EmailDTO {
    private String id;

    private String emailContent;

    private String sender;

    private String subject;

}
