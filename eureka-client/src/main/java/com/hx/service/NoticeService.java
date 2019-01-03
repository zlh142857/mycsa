package com.hx.service;/*
 */

import com.hx.system.Notice;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface NoticeService {
    Map<String,Object> queryNoticeList();  //获取公告信息

    String insertNotice(Notice notice,String username,String ip);  //发布公告

    String delNotice(Integer noticeId,String username,String ip);  //删除公告
}
