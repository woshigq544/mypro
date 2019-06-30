package com.syjpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyproApplication {
    public static void main(String[] args) {
        /*ConfigurableApplicationContext context = */SpringApplication.run(MyproApplication.class, args);
        /*DataSource dataSource = context.getBean(DataSource.class);

        System.out.println(dataSource.getClass());*/
    }
}
