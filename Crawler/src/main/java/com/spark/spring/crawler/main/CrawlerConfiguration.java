package com.spark.spring.crawler.main;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spark.spring.crawler.main.controllers.CrawlerService;

import org.springframework.boot.SpringApplication;
@SpringBootApplication
@ComponentScan(basePackageClasses=CrawlerService.class)
public class CrawlerConfiguration {
	public static void main(String[] args) {
		SpringApplication.run(CrawlerConfiguration.class, args);
	}
}
