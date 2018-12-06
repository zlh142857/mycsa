package com.hx.service;/*
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-client")
public interface EquipmentMaintainService {
    @RequestMapping(value = "/equipmentMaintain/equipmentMaintainList",method = RequestMethod.GET)
    boolean equipmentMaintainList();
}
