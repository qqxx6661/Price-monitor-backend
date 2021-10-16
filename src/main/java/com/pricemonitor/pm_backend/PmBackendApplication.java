package com.pricemonitor.pm_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yzd
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
@MapperScan("com.pricemonitor.pm_backend.mapper")
public class PmBackendApplication {

	/**
	 * 用于在类中注入BCryptPasswordEncoder
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(PmBackendApplication.class, args);
	}
}
