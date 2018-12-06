package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:34
 *@功能:
 */

import com.hx.service.FileStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/fileStatistics")
public class FileStatistics {
    @Autowired
    private FileStatisticsService fileStatisticsService;
    @RequestMapping(value = "/fileStatisticsList",method = RequestMethod.GET)
    public boolean fileStatisticsList(){
        return true;
    }
}
