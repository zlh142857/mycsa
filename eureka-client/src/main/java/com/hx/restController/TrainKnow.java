package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:52
 *@功能:
 */

import com.hx.service.TrainKnowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/trainKnow")
public class TrainKnow {
    @Autowired
    private TrainKnowService trainKnowService;
    @RequestMapping(value = "/trainKnowList",method = RequestMethod.GET)
    public boolean trainKnowList(){
        return true;
    }
}
