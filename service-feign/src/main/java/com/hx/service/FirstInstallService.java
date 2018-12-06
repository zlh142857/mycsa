package com.hx.service;/*
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-client")
public interface FirstInstallService {
    @RequestMapping(value = "/firstInstall/installRegisterList",method = RequestMethod.GET)
    boolean installRegisterList();
}
