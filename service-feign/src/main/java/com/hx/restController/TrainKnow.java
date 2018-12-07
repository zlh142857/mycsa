package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:48
 *@功能:培训知识
 */

import com.hx.service.TrainKnowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/trainKnow")
public class TrainKnow {
    @Autowired
    private TrainKnowService trainKnowService;
    @RequestMapping(value = "/trainKnowList",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="trainKnowListError")
    public boolean trainKnowList(){
        return true;
    }
    public String trainKnowListError() {
        return "hi,sorry,error!";
    }
}
