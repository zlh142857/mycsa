package com.hx.service;/*
 */

import com.hx.facility.FacilityInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface EquipmentInfoAService {
    @RequestMapping(value = "/equipmentInfo/equipmentList",method = RequestMethod.GET)
    String queryEquipmentList(@RequestParam(value = "page")Integer page, @RequestParam(value = "size") Integer size);
    @RequestMapping(value = "/equipmentInfo/insertEquipment",method = RequestMethod.POST)
    String insertEquipment(@RequestParam(value = "facilityInformation")FacilityInformation facilityInformation);
}
