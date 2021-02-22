package edu.security.third.config;

import edu.security.third.web.oauth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

  private final LoginUserArgumentResolver loginUserArgumentResolver;

  //  LoginUser어노테이션을 적용하기 위한 ArgumentResolver를 Spring 프로젝트의 resolver에 추가해 사용할 수 있도록 함
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(loginUserArgumentResolver);
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // 모든 매핑된 경로에 대하여, 모든 오리진 허용
    registry.addMapping("/**").allowedOrigins("*");
  }
}