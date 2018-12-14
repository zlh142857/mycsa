package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/7 9:35
 *@功能:公告管理
 */

import com.hx.Notice;
import com.hx.service.NoticeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/noticeController")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping(value = "/queryNoticeList",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="queryNoticeListError")
    @ResponseBody
    public String queryNoticeList(){
        String noticeList=noticeService.queryNoticeList();
        return noticeList;
    }
    public String queryNoticeListError() {
        return "服务未响应";
    }

    @RequestMapping(value = "/insertNotice",method = RequestMethod.POST)
    @ResponseBody
    public String insertNotice(Notice notice){
        String insertMsg=noticeService.insertNotice(notice);
        return insertMsg;
    }
    public String insertNoticeError(Notice notice) {
        return "服务未响应";
    }


    @RequestMapping(value = "/delNotice",method = RequestMethod.POST)
    @ResponseBody
    public String delNotice(Integer noticeId){
        String delMsg=noticeService.delNotice(noticeId);
        return delMsg;
    }

}
