package com.hx.service;/*
 */

import com.hx.Notice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface NoticeService {
    @RequestMapping(value = "/noticeController/queryNoticeList",method = RequestMethod.GET)
    String queryNoticeList();
    @RequestMapping(value = "/noticeController/insertNotice",method = RequestMethod.POST)
    String insertNotice(@RequestParam("notice") Notice notice);
    @RequestMapping(value = "/noticeController/delNotice",method = RequestMethod.DELETE)
    String delNotice(Integer noticeId);
}
