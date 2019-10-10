package com.edm.base;

import com.edm.common.util.SnowflakeIdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ChuChinRCC
 */
@SpringBootApplication
@EnableJpaRepositories
public class CoderSiteBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoderSiteBaseApplication.class, args);
	}

	@Bean
	public SnowflakeIdWorker idWorker(){
		return new SnowflakeIdWorker(1,1);
	}

}
