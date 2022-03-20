package com.cjy.auth.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

     @Id @GeneratedValue(generator = "snowflake")
     @GenericGenerator(name = "snowflake", strategy = "com.cjy.base.util.GenerateSnowflakeId")
     private Long userId;
     private String userName;
     private String mobile;
     private String mobileNationalCode;
     private String email;
}
