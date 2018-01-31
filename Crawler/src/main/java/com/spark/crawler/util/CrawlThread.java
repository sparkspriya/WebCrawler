package com.spark.crawler.util;

public class CrawlThread extends Thread{
CrawlerUtils crawlerUtils=new CrawlerUtils();
private String url;
private int count;
public CrawlThread(String url,int count) {
	this.url=url;
	this.count=count;
}
	@Override
	public void run() {
		crawlerUtils.getUrlLinks(url, count);
	}

}
