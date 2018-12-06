package com.hx.service;/*
 */

import com.hx.model.facility.FacilityInformation;

import java.util.Map;

public interface EquipmentInfoAService {
    Map<String,Object> queryEquipmentList(Integer page, Integer size); //查询所有的设备信息

    String insertEquipment(FacilityInformation facilityInformation); //录入设备信息库
}
