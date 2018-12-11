package com.hx.service;/*
 */

import com.hx.Activiti.ActMsgPersonnel;
import com.hx.UserInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ActivitiApproveService {
    String lCountryRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel);  //提交离境审批

    String goWorkRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel);  //提交上岗审批

    String lPostRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel);  //提交离岗审批

    Map<String,Object> selectSelfLCTask(String uid); //查询自己要审批的离境任务

    Map<String,Object> selectSelfTWTask(String uid);//查询自己要审批的上岗任务

    Map<String,Object> selectSelfLPTask(String uid);//查询自己要审批的离职任务

    String aduitback(String taskId);  //审核驳回按钮

    String aduitok(String taskId,Integer uid);   //审核通过按钮

    String goComplete(String taskId);  //取消申请按钮

    String applyAgain(String taskId); //重新申请按钮

    Map<String,Object> selectRunningTask(Integer uid); //查询该用户提交申请中正在进行审批的流程

    Map<String,Object> selectRunedTask(Integer uid); //查询该用户提交申请中已经运行结束的流程
}
