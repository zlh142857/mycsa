package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:10
 *@功能:
 */

import com.hx.service.EquipmentMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/equipmentMaintain")
public class EquipmentMaintain {
    @Autowired
    private EquipmentMaintainService equipmentMaintainService;
    @RequestMapping(value = "/equipmentMaintainList",method = RequestMethod.GET)
    public boolean equipmentMaintainList(){
        return true;
    }
}
