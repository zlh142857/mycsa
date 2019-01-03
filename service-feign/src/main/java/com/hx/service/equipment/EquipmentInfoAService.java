package com.hx.service.equipment;/*
 */

import com.hx.facility.FacilityInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "eureka-client")
public interface EquipmentInfoAService {
    @GetMapping(value = "/equipmentInfo/equipmentList")
    String queryEquipmentList(@RequestParam(value = "page")Integer page, @RequestParam(value = "size") Integer size, @RequestParam(value = "username")String username,@RequestParam(value = "ip") String ip);
    @RequestMapping(value = "/equipmentInfo/insertEquipment",method = RequestMethod.POST)
    String insertEquipment(@RequestBody FacilityInformation facilityInformation, @RequestParam(value = "username")String username,@RequestParam(value = "ip") String ip);
}
