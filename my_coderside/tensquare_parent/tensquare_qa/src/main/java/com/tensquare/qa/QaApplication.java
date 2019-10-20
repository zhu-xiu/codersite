package com.tensquare.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @author root
 * 启动类
 */
@SpringBootApplication
@EnableJpaRepositories
public class QaApplication {

    public static void main(String[] args){
        SpringApplication.run(QaApplication.class,args);
    }
}
