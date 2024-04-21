package com.cjy.auth.entity;

import com.cjy.base.util.GenerateSnowflakeId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
public class User {

     @Id
     @GeneratedValue(generator = "snowflake")
     @GenericGenerator(name = "snowflake", type = GenerateSnowflakeId.class)
     private Long userId;
     private String userName;
     private String mobile;
     private String mobileNationalCode;
     private String email;
}
