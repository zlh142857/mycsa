package com.hx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface DefaulService {
    @RequestMapping(value="/unauth",method = RequestMethod.GET)
    String login(@RequestParam(value = "userinfo")String userinfo);
}
