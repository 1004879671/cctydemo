package com.ccty.beanDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MainConfigOfLifeCycle {
//    @Bean(initMethod="initTest", destroyMethod="detoryTest")
    public Car car() {
        return new Car();
    }
}