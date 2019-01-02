package com.hx.service.notice;/*
 */

import com.hx.system.Notice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "eureka-client")
public interface NoticeService {
    @RequestMapping(value = "/noticeController/queryNoticeList",method = RequestMethod.GET)
    String queryNoticeList();
    @RequestMapping(value = "/noticeController/insertNotice",method = RequestMethod.POST)
    String insertNotice(@RequestParam("notice") Notice notice, @RequestParam(value = "username")String username, @RequestParam(value = "request")HttpServletRequest request);
    @RequestMapping(value = "/noticeController/delNotice",method = RequestMethod.POST)
    String delNotice(Integer noticeId, @RequestParam(value = "username")String username, @RequestParam(value = "request")HttpServletRequest request);
}
