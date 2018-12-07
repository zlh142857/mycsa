package com.hx.service;/*
 */

import com.hx.Notice;

import java.util.Map;

public interface NoticeService {
    Map<String,Object> queryNoticeList();  //获取公告信息

    String insertNotice(Notice notice);  //发布公告

    String delNotice(Integer noticeId);  //删除公告
}
