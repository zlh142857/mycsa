package com.hx.service;/*
 */

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "eureka-client")
public interface NoticeService {
    String queryNoticeList();
}
