package com.NaSSIB.spring.SpringDemo.config;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class AppConfig {
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {

    return builder.setConnectTimeout(Duration.ofMillis(2000))
        .setReadTimeout(Duration.ofMillis(2000)).build();
  }
}