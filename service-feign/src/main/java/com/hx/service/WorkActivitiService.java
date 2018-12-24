package com.hx.service;/*
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "eureka-client")
public interface WorkActivitiService {
    @RequestMapping(value = "/workActiviti/workExamine",method = RequestMethod.GET)
    String workExamine(@RequestParam("request") HttpServletRequest request);
}
