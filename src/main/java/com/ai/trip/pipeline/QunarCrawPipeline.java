package com.ai.trip.pipeline;

import com.google.common.collect.Maps;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;
import java.util.Set;

/**
 * Created by chengzheng on 16/9/21.
 */
public class QunarCrawPipeline implements Pipeline {
    private Map<String, String> dynamicFlightInfo = Maps.newConcurrentMap();

    public void process(ResultItems resultItems, Task task) {


        String result = resultItems.get("result");
        //解析不规则json返回对象
        result = result.replace("(\\w+:|\\w+ :)","\"$1\"").replace(":\"\"|:\"","\":\"").replace("(","").replace(")","");

        //暂时只是打印至控制台
        printResult(result);

//        String corrInfo = result.substring(result.indexOf("corrInfo:") + "corrInfo".length() + 1, result.indexOf("extInfo")).replace(",$", "");
//        corrInfo.replace("(\\w+:)", "\"$1\"").replace(":\"\"", "\":\"");
////        printResult(corrInfo);
//
//        //解析extInfo
//        corrInfo = result.substring(result.indexOf("extInfo :") + "extInfo :".length()).replace(")", "").replace("}$", "");
//        corrInfo.replace("^\\s\\w:$", "\"1\"");
//        printResult(corrInfo);

    }

    private void printResult(String corrInfo) {
        JSONParser parser = new JSONParser();
        JSONObject parse = null;
        try {
            parse = (JSONObject) parser.parse(corrInfo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Set<String> strings = parse.keySet();
        //打印信息extInfo信息
        for (String str : strings) {
            System.out.print(str + ":");
            System.out.println(parse.get(str));
        }
    }
}
