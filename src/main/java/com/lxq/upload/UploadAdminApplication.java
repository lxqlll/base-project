package com.lxq.upload;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.lxq.upload.module.mapper")
public class UploadAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadAdminApplication.class, args);
    }

}
