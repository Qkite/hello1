package com.likelion.korea_hospital.parser;

import com.likelion.korea_hospital.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ParserFactory {

    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext() throws IOException {
        return new ReadLineContext<Hospital>(new HospitalParser());
    }
}
