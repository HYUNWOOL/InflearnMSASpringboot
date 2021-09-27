package com.inflearn.lecture.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.Date;

@Data
@AllArgsConstructor
@ApiModel(description = "사용자 상세 정보")
//@JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserInfo")
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요")
    private Date createAt;

    @Size(min=2, message = "Name 2 글자 이상")
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요")
    private String name;

    @ApiModelProperty(notes = "사용자 주민등록번호를 입력해 주세요")
    private String ssn;

    @ApiModelProperty(notes = "사용자 비밀번호 입력해 주세요")
    private String password;
}
