package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:08
 *@功能:
 */

import com.hx.service.EquipmentMaintainService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/equipmentMaintain")
public class EquipmentMaintain {
    @Autowired
    private EquipmentMaintainService equipmentMaintainService;
    @RequestMapping(value = "/equipmentMaintainList/{id}",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean equipmentMaintainList(){
        return equipmentMaintainService.equipmentMaintainList();
    }
    public boolean hiError() {
        return false;
    }
}
