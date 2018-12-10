package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:57
 *@功能:设备信息库crud
 */

import com.hx.facility.FacilityInformation;
import com.hx.service.EquipmentInfoAService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/equipmentList",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="equipmentListError")
    public String queryEquipmentList(Integer page,Integer size){
        return equipmentInfoAService.queryEquipmentList(page,size);
    }
    public String equipmentListError(Integer page,Integer size) {
        return "服务未响应";
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
    @HystrixCommand(fallbackMethod ="insertEquipmentError")
    public String insertEquipment(FacilityInformation facilityInformation){
        return equipmentInfoAService.insertEquipment(facilityInformation);
    }
    public String insertEquipmentError(FacilityInformation facilityInformation) {
        return "服务未响应";
    }
}
