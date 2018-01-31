package com.spark.crawler.test;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.junit.Test;

import com.spark.crawler.util.CrawlerUtils;

public class CrawlingTest {

	@Test
	public void getUrlLinksMethodTest() {
		CrawlerUtils crawlerUtils=new CrawlerUtils();
		CrawlerUtils.setDepth(0);		
		crawlerUtils.getUrlLinks("http://www.google.com",-1);	
		System.out.println(CrawlerUtils.getUrlArray());
		System.out.println(CrawlerUtils.getUrlArray().size());
		JSONArray jsArray = new JSONArray(CrawlerUtils.getUrlArray());
		System.out.println(jsArray);
		assertNotNull(jsArray);
	}

}
