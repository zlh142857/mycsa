package com.hx.service.personnel;/*
 */

import com.hx.personnel.PersonnelInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "eureka-client")
public interface PersonnelInfoService {
    @RequestMapping(value = "/personnelInfoController/personnelList",method = RequestMethod.GET)
    String queryPersonnelList(@RequestParam(value = "page")Integer page,@RequestParam(value = "size") Integer size);
    @PostMapping(value = "/personnelInfoController/insertPer")
    String insertPer(@RequestBody PersonnelInfo personnelInfo);
}
