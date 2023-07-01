package com.ccty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

//@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class CctyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CctyApplication.class, args);
    }
}
