package com.hx.service;/*
 */

import com.hx.Activiti.ActMsg;
import com.hx.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface ActivitiApproveService {
    @RequestMapping(value = "/activitiApprove/lCountryRefer",method = RequestMethod.POST)
    String lCountryRefer(@RequestParam("userInfo") UserInfo userInfo, @RequestParam("actMsg") ActMsg actMsg);
    @RequestMapping(value = "/activitiApprove/lCountryRefer",method = RequestMethod.POST)
    String goWorkRefer(@RequestParam("userInfo") UserInfo userInfo, @RequestParam("actMsg") ActMsg actMsg);
    @RequestMapping(value = "/activitiApprove/lPostRefer",method = RequestMethod.POST)
    String lPostRefer(@RequestParam("userInfo") UserInfo userInfo, @RequestParam("actMsg") ActMsg actMsg);
}
