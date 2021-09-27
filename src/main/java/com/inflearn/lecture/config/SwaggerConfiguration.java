package com.inflearn.lecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SwaggerConfiguration {
  private static Contact default_contact = new Contact(
      "LEEHYUNWOO","github.com/HYUNWOOL","kiesland1121@naver.com"
  );

  private static final Set<String> consumes = new HashSet<>(
      Arrays.asList("application/json","application/xml")
  );

  @Bean
  public Docket swaggerApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(swaggerInfo())
        .produces(consumes)
        .consumes(consumes)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.inflearn.lecture.controller"))
        .build()
        .useDefaultResponseMessages(false); // 기본으로 세팅되는 200,401,403,404 메시지를 표시 하지 않음
  }

  private ApiInfo swaggerInfo() {
    return new ApiInfoBuilder().title("Spring API Documentation").description("인프런 실습 페이지")
        .version("1.0").contact(default_contact).build();
  }
}
