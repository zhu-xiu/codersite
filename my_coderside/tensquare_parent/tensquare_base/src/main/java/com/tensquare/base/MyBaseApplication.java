package com.tensquare.base;

import com.tensquare.common.util.SnowflakeIdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 *  启动类
 * @author root
 */

@SpringBootApplication
@EnableJpaRepositories
public class MyBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBaseApplication.class, args) ;
    }

    @Bean
    public SnowflakeIdWorker idworker(){
        return new SnowflakeIdWorker(1,1);
    }

}
