package com.hx.service;/*
 */

import com.hx.Activiti.ActMsgPersonnel;
import com.hx.UserInfo;

import java.util.Map;

public interface ActivitiApproveService {
    String lCountryRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel);  //提交离境审批

    String goWorkRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel);  //提交上岗审批

    String lPostRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel);  //提交离岗审批

    Map<String,Object> selectSelfTask(String uid); //查询自己要审批的任务
}
