package com.spark.spring.crawler.main.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.Crawler.util.CrawlerUtils;
@RestController
public class CrawlerService {
	@RequestMapping("/crawl")
	public @ResponseBody String getCrawlerResponse(){
		String url="https://www.javatpoint.com";
		CrawlerUtils crawlerUtils=new CrawlerUtils();
		CrawlerUtils.setDepth(1);		
		crawlerUtils.getUrlLinks(url,0);	
		System.out.println(CrawlerUtils.getUrlArray());
		System.out.println(CrawlerUtils.getUrlArray().size());
		return CrawlerUtils.getUrlArray().toString();
	}
}
