package com.spark.spring.crawler.main.controllers;


import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.crawler.util.CrawlerUtils;


@RestController
public class CrawlerService {
	@RequestMapping("/crawl")
	public @ResponseBody String getCrawlerResponse(@RequestParam("url") String url,@RequestParam("depth") int depth){
		CrawlerUtils crawlerUtils=new CrawlerUtils();
		CrawlerUtils.setDepth(depth);		
		crawlerUtils.getUrlLinks(url,-1);	
		System.out.println(CrawlerUtils.getUrlArray());
		System.out.println(CrawlerUtils.getUrlArray().size());
		JSONArray jsArray = new JSONArray(CrawlerUtils.getUrlArray());
		return jsArray.toString();
	}
}
