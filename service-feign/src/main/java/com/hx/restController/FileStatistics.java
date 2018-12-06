package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:32
 *@功能:
 */

import com.hx.service.FileStatisticsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/fileStatistics")
public class FileStatistics {
    @Autowired
    private FileStatisticsService fileStatisticsService;
    @RequestMapping(value = "/fileStatisticsList/{id}",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean fileStatisticsList(){
        return fileStatisticsService.fileStatisticsList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
