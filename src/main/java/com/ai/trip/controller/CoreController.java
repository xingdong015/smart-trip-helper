package com.ai.trip.controller;

import com.ai.trip.service.QunarBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chengzheng on 16/10/1.
 */
@Controller
@RequestMapping(value = "/api")
public class CoreController {

    @Autowired
    private QunarBusiness qunarBusiness;
    public String qunarProcessor(HttpServletRequest request){
        String time = request.getParameter("time");
        String startStation = request.getParameter("startStation");
        String endStation = request.getParameter("endStation");

        return "";
    }

}
