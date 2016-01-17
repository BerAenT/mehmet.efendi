package com.mehmet.efendi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mehmet.efendi.service.InitService;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MehmetEfendiApplication implements CommandLineRunner {

	private static Logger LOGGER = LoggerFactory.getLogger(MehmetEfendiApplication.class);

	@Autowired
	private InitService initService;

	public static void main(String[] args) {
		SpringApplication.run(MehmetEfendiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.debug("Datas are loading ....");
		initService.loadData();
	}

}
