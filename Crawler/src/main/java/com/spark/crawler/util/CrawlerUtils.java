package com.spark.crawler.util;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerUtils {
	private static int depth;
	private static ArrayList<String> urlArray=new ArrayList<String>();
	public static int getDepth() {
		return depth;
	}
	public static void setDepth(int depth) {
		CrawlerUtils.depth = depth;
	}
	public static ArrayList<String> getUrlArray() {
		return urlArray;
	}
	public static void setUrlArray(ArrayList<String> urlArray) {
		CrawlerUtils.urlArray = urlArray;
	}

	public void getUrlLinks(String url,int count) {
		if(!urlArray.contains(url) && count<=depth) {
		try {
			urlArray.add(url);
			Document htmlDoc=Jsoup.connect(url).get();
			Elements links = htmlDoc.select("a[href]");
			count++;
			for (Element page : links) {
				if(count<=depth) {
				System.out.println(page.attr("abs:href"));
				CrawlThread crawlThread=new CrawlThread(page.attr("abs:href"), count);
				crawlThread.start();
				crawlThread.join();
				}
            }
		} catch (IOException|InterruptedException e) {
			System.out.println("Exception in processing url:"+url+" message:"+e.getMessage());
		}
	}
	}
}
