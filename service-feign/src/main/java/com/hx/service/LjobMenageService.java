package com.hx.service;/*
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-client")
public interface LjobMenageService {
    @RequestMapping(value = "/ljobMenage/ljobList")
    boolean ljobList();
}
