package com.gamary.emailanalyzer;

import com.gamary.emailanalyzer.domain.Email;
import com.gamary.emailanalyzer.service.DTO.EmailDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmailAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailAnalyzerApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper= new ModelMapper();
//		modelMapper.addMappings(new PropertyMap<EmailDTO, Email>() {
//			@Override
//			protected void configure() {
//				skip(destination.getBlessedField());
//			}
//		});
		return modelMapper;

	}
}
