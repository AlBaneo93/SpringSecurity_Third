package edu.security.third.config;

import edu.security.third.web.oauth.CustomOAuth2UserService;
import edu.security.third.web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private MemberService memberService;

  private PasswordEncoder passwordEncoder;

  private CustomOAuth2UserService customOAuth2UserService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable().headers().frameOptions().disable()
        .and()
        .authorizeRequests()
        .antMatchers("/", "/css/**", "/js/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .logout().logoutSuccessUrl("/")
        .and()
        .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);

    // Resource Server 설정 추가
    http
        .authorizeRequests(authz -> authz
            .antMatchers(HttpMethod.GET, "/").hasAuthority("SCOPE_read")
            .antMatchers(HttpMethod.POST, "/").hasAuthority("SCOPE_write")
            .anyRequest().authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2.jwt());

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(memberService).passwordEncoder(passwordEncoder);
  }


}