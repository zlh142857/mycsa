package com.hx.service;/*
 */


import com.hx.facility.FacilityInformation;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface EquipmentInfoAService {
    Map<String,Object> queryEquipmentList(Integer page, Integer size,String username,String ip); //查询所有的设备信息

    String insertEquipment(FacilityInformation facilityInformation,String username,String ip); //录入设备信息库
}
