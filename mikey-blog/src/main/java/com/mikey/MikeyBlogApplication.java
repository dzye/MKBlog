package com.mikey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mikey
 */
@SpringBootApplication
@MapperScan("com.mikey.mapper")
public class MikeyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MikeyBlogApplication.class, args);
    }
}
