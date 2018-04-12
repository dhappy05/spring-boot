package com.ding.readWriteSparation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ding.readWriteSparation.dao")//告诉mapper所在的包名
public class ReadWriteSparationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadWriteSparationApplication.class, args);
	}
}
