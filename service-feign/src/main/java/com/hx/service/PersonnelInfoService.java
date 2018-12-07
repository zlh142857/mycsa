package com.hx.service;/*
 */

import com.hx.personnel.PersonnelInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface PersonnelInfoService {
    @RequestMapping(value = "/personnelInfoController/personnelList",method = RequestMethod.GET)
    String queryPersonnelList(@RequestParam(value = "page")Integer page,@RequestParam(value = "size") Integer size);
    @RequestMapping(value = "/personnelInfoController/insertPersonnel",method = RequestMethod.POST)
    String insertPersonnel(@RequestParam(value = "personnelInfo")PersonnelInfo personnelInfo);
}
