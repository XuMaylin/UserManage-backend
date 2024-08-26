package org.example.usermanagebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.example.usermanagebackend.mapper")
public class UserManageBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManageBackendApplication.class, args);
    }

}
