package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:35
 *@功能:
 */

import com.hx.service.VideoInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/videoInfo")
public class VideoInfo {
    @Autowired
    private VideoInfoService videoInfoService;
    @RequestMapping(value = "/videoList/{id}",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean videoList(){
        return videoInfoService.videoList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
