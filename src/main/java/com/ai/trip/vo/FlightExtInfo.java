package com.ai.trip.vo;

/**
 * Created by chengzheng on 16/10/2.
 */

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

/**
 *
 ml:"true",
 sp:"0",
 spCity:"",
 spAirPort:"",
 cs:"",
 et:"true",
 ps:false,
 hot:false,
 lqf:0,
 fdt:"2小时10分钟",
 fot:"0",
 acf:"50",
 lcc:false,
 sc : {full : "1034",dis : "4"  },
 zj : {url : 'http://airchina.travelsky.com/cab2c/getOckiConfig.do',info : "本航班支持网上值机，航班起飞前36小时即可办理北京始发国航实际运营国内航班的乘机手续，航班起飞前2小时停止办理。请您不晚于航班起飞前20分钟到达指定登机口登机。国际航班国内段暂不办理。" },
 qibe:0}
 ,
 */
public class FlightExtInfo {
//    private static final String ml ="ml";
//    private static final String sp = "sp";
//    private static final String spCity = "spCity";
//    private static final String spAirPort = "spAirPort";
//    private static final String cs = "cs";
//    private static final String et = "et";
//
//
//    private static final String ps ="ps";
//    private static final String hot = "hot";
//    private static final String lqf = "lqf";
//    private static final String fdt = "fdt";
//    private static final String fot = "fot";
//    private static final String acf = "acf";
//
//    private static final String lcc ="lcc";
//    private static final String sc = "sc";
//    private static final String full = "full";
//    private static final String dis = "dis";
//    private static final String zj = "zj";
//    private static final String url = "url";
//    private static final String info = "info";
//    private static final String qibe = "qibe";
    public static void main(String[] args) throws ParseException {
        String s = "{\"CA1201\":{\n" +
                "\t\tml:\"true\",\n" +
                "\t\tsp:\"0\",\n" +
                "\t\tspCity:\"\",\n" +
                "\t\tspAirPort:\"\",\n" +
                "\t\tcs:\"\",\n" +
                "\t\tet:\"true\",\n" +
                "\t\tps:false,\n" +
                "\t\thot:false,\n" +
                "\t\tlqf:0,\n" +
                "\t\tfdt:\"2小时10分钟\",\n" +
                "\t\tfot:\"0\",\n" +
                "\t\tacf:\"50\",\t\n" +
                "\t\tlcc:false,\n" +
                "\t\tsc : {full : \"1034\",dis : \"4\"  },   \n" +
                "\t    zj : {url : 'http://airchina.travelsky.com/cab2c/getOckiConfig.do',info : \"本航班支持网上值机，航班起飞前36小时即可办理北京始发国航实际运营国内航班的乘机手续，航班起飞前2小时停止办理。请您不晚于航班起飞前20分钟到达指定登机口登机。国际航班国内段暂不办理。\" },\n" +
                "\t    qibe:0}}";
        s = s.replaceAll("(\\s\\w+)","\"$1\"");
        JSONParser parser = new JSONParser();
        JSONObject parse = (JSONObject) parser.parse(s);
        System.out.println(parse);

//        System.out.println(s);

    }


}
