package com.info.searchservice.config;

import com.info.searchservice.service.SearchServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  @Bean(name = "githubServiceClient")
  SearchServiceClient githubServiceClient() {
    return new SearchServiceClient("https://api.github.com/search/repositories");
  }

  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
