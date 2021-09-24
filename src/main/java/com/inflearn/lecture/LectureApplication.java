package com.inflearn.lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class LectureApplication {

  public static void main(String[] args) {
    SpringApplication.run(LectureApplication.class, args);
  }

  //지역에 따라 언어가 다르도록
  @Bean
  public LocaleResolver localeResolver(){
    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
    localeResolver.setDefaultLocale(Locale.KOREA);
    return localeResolver;
  }
}
