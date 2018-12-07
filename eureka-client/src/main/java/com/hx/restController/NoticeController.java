package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/7 13:59
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.Notice;
import com.hx.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "noticeController")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @GetMapping(value = "/queryNoticeList")
    @ResponseBody
    public String queryNoticeList(){
        Map<String,Object> noticeList=noticeService.queryNoticeList();
        return JSONObject.toJSONString( noticeList);
    }

    @PostMapping(value = "/insertNotice")
    @ResponseBody
    public String insertNotice(Notice notice){
        String insertMsg=noticeService.insertNotice(notice);
        return JSONObject.toJSONString( insertMsg);
    }

    @PostMapping(value = "/delNotice")
    @ResponseBody
    public String delNotice(Integer noticeId){
        String delMsg=noticeService.delNotice(noticeId);
        return JSONObject.toJSONString( delMsg);
    }
}
