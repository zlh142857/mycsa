package com.hx.restController.equipment;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:00
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.facility.FacilityInformation;
import com.hx.service.EquipmentInfoAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = "/equipmentInfo")
public class EquipmentInfo {
    @Autowired
    private EquipmentInfoAService equipmentInfoService;
    @GetMapping(value = "/equipmentList")
    @ResponseBody
    public String queryEquipmentList(Integer page,Integer size,String username,@RequestParam("ip")String ip){
        Map<String,Object> personnelList=equipmentInfoService.queryEquipmentList(page,size,username,ip);
        return JSONObject.toJSONStringWithDateFormat( personnelList,"yyyy-MM-dd HH:mm:ss" );
    }

    @PostMapping(value = "/insertEquipment")
    @ResponseBody
    public String insertEquipment(@RequestBody FacilityInformation facilityInformation,String username,@RequestParam("ip")String ip){
        String insertMsg=equipmentInfoService.insertEquipment(facilityInformation,username,ip);
        return JSONObject.toJSONString(insertMsg);
    }

}
