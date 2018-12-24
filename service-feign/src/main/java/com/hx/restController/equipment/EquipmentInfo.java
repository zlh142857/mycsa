package com.hx.restController.equipment;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:57
 *@功能:设备信息库crud
 */

import com.hx.facility.FacilityInformation;
import com.hx.service.equipment.EquipmentInfoAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/equipmentInfo")
public class EquipmentInfo {
    @Autowired
    private EquipmentInfoAService equipmentInfoAService;
    /**
     *
     * 功能描述: 设备信息库的信息查询接口,查询列表和详情页共用一个接口
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/6 14:13
     */
    @GetMapping(value = "/equipmentList")
    @ResponseBody
    public String queryEquipmentList(Integer page,Integer size){
        return equipmentInfoAService.queryEquipmentList(page,size);
    }
    /**
     *
     * 功能描述: 设备信息库的录入
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/6 14:14
     */
    @RequestMapping(value = "/insertEquipment",method = RequestMethod.POST)
    @ResponseBody
    public String insertEquipment(@RequestBody FacilityInformation facilityInformation){
        return equipmentInfoAService.insertEquipment(facilityInformation);
    }

    //删除增加断路器,提示 服务器繁忙,未响应
}
