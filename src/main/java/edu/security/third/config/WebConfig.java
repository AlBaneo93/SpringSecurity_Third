package edu.security.third.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // 모든 매핑된 경로에 대하여, 모든 오리진 허용
    registry.addMapping("/**").allowedOrigins("*");
  }
}