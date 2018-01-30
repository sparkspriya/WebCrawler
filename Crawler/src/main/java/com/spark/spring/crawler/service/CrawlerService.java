package com.spark.spring.crawler.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.Crawler.util.CrawlerUtils;
@RestController
@RequestMapping("/crawl")
public class CrawlerService {
	public @ResponseBody String getCrawlerResponse(String url,int depth){
		url="https://www.javatpoint.com";
		CrawlerUtils crawlerUtils=new CrawlerUtils();
		CrawlerUtils.setDepth(1);
		CrawlerUtils.getUrlArray().add(url);
		if(depth>0) {
			crawlerUtils.getUrlLinks(url,0);
		}
		System.out.println(CrawlerUtils.getUrlArray());
		System.out.println(CrawlerUtils.getUrlArray().size());
		return CrawlerUtils.getUrlArray().toString();
	}
}
