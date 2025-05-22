package com.exam.Synchrony.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImgurConfig {
    @Value("${imgur.client.id}")
    private String clientId;

    public String getClientId() {
        return clientId;
    }
}
