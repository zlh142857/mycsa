package com.hx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@FeignClient(value = "eureka-client")
public interface ToLoginService {
    @RequestMapping(value = "/toLogin/ajaxLogin",method = RequestMethod.POST)
    String ajaxLogin(@RequestParam("name")String name, @RequestParam("password")String password);
}
