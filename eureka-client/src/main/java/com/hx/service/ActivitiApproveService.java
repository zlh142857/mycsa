package com.hx.service;/*
 */

import com.hx.Activiti.ActMsg;
import com.hx.UserInfo;

public interface ActivitiApproveService {
    String lCountryRefer(UserInfo userInfo, ActMsg actMsg);  //提交离境审批

    String goWorkRefer(UserInfo userInfo, ActMsg actMsg);  //提交上岗审批

    String lPostRefer(UserInfo userInfo, ActMsg actMsg);  //提交离岗审批
}
