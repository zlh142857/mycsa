package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:12
 *@功能:
 */

import com.hx.service.EquipmentReturnService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value="/equipmentReturn")
public class EquipmentReturn {
    @Autowired
    private EquipmentReturnService equipmentReturnService;
    @RequestMapping(value = "/equipmentReturnList",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean equipmentReturnList(){
        return equipmentReturnService.equipmentReturnList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
