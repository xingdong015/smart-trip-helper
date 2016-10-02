package com.ai.trip.processor;

import com.ai.trip.pipeline.QunarCrawPipeline;
import com.ai.trip.constant.QunarCrawURLConstants;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.net.URLEncoder;

/**
 * Created by chengzheng on 16/9/19.
 */
public class QunarJsonProcessor implements PageProcessor {

    private static  String URL = QunarCrawURLConstants.LongWellInfoURL;

    private Site site = Site.me().setCharset("UTF-8").setRetryTimes(3).setSleepTime(1000);
    public void process(Page page) {
        page.putField("result",page.getRawText());
    }

    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {

        StationParameDTO stationParameDTO = new StationParameDTO().invoke();

        URL = getURL(stationParameDTO.getStartStation(),stationParameDTO.getEndStation());
        Spider.create(new QunarJsonProcessor()).addUrl(URL)
                .addPipeline(new QunarCrawPipeline())
                .thread((Runtime.getRuntime().availableProcessors() - 1) << 1)
                .runAsync();


    }

    private static  String getURL(String startStation,String endStation){
        return URL.replace("$startStation",startStation).replace("$endStation",endStation).replace("$time","2016-10-04").replace("$returnedTime","2016-10-04");
    }

    private static class StationParameDTO {
        private String startStation;
        private String endStation;

        public String getStartStation() {
            return startStation;
        }

        public String getEndStation() {
            return endStation;
        }

        public StationParameDTO invoke() {
            startStation = "北京";
            endStation = "西安";
            startStation = URLEncoder.encode(startStation);
            endStation = URLEncoder.encode(endStation);
            return this;
        }
    }
}
