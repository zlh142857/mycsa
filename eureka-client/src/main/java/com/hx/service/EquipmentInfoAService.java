package com.hx.service;/*
 */


import com.hx.facility.FacilityInformation;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface EquipmentInfoAService {
    Map<String,Object> queryEquipmentList(Integer page, Integer size,String username,HttpServletRequest request); //查询所有的设备信息

    String insertEquipment(FacilityInformation facilityInformation,String username,HttpServletRequest request); //录入设备信息库
}
