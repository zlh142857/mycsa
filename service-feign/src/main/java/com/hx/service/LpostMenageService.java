package com.hx.service;/*
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-client")
public interface LpostMenageService {
    @RequestMapping(value = "/lpostMenage/lpostList",method = RequestMethod.GET)
    boolean lpostList();
}
