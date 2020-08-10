package com.company;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        String url = "https://datalab.naver.com/keyword/realtimeList.naver?where=main";
	    Document doc = null;

	    try {
	        doc = Jsoup.connect(url).get();
        } catch (IOException e){
	        e.printStackTrace();
        }
        Elements realTime = doc.select("ul.ranking_list > li.ranking_item > div.item_box");


        for (Element rank : realTime) {

            System.out.println(rank.select("span.item_num").get(0).html()  + "\t" + rank.select("span.item_title").get(0).html());
        }


    }
}
