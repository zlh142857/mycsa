package com.hx.service;/*
 */

import com.hx.model.personnel.PersonnelInfo;

import java.util.Map;

public interface PersonnelInfoService {
    Map<String, Object> queryPersonnelList(Integer page,Integer size); //查询人员信息库中所有的人员信息

    String insertPersonnel(PersonnelInfo personnelInfo); //人员录入信息接口
}
