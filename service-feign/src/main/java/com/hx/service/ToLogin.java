package com.hx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@FeignClient(value = "eureka-client")
public interface ToLogin {
    @RequestMapping(value = "/toLogin/ajaxLogin")
    @ResponseBody
    String ajaxLogin(HttpServletRequest request);
}
