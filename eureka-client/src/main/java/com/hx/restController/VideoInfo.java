package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:38
 *@功能:
 */

import com.hx.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/videoInfo")
public class VideoInfo {
    @Autowired
    private VideoInfoService videoInfoService;
    @RequestMapping(value = "/videoList",method = RequestMethod.GET)
    public boolean videoList(){
        return true;
    }
}
