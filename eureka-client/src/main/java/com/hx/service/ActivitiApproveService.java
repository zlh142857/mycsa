package com.hx.service;/*
 */

import com.hx.Activiti.ActMsgPersonnel;
import com.hx.pwcontrol.system.SysUser;

import java.util.Map;

public interface ActivitiApproveService {
    /*String lCountryRefer(SysUser userInfo, ActMsgPersonnel actMsgPersonnel, String ip);  //提交离境审批

    String goWorkRefer(SysUser userInfo, ActMsgPersonnel actMsgPersonnel, String ip);  //提交上岗审批

    String lPostRefer(SysUser userInfo, ActMsgPersonnel actMsgPersonnel, String ip);  //提交离岗审批

    Map<String,Object> selectSelfLCTask(String uid, String ip, String username); //查询自己要审批的离境任务

    Map<String,Object> selectSelfTWTask(String uid, String ip, String username);//查询自己要审批的上岗任务

    Map<String,Object> selectSelfLPTask(String uid, String ip, String username);//查询自己要审批的离职任务

    String aduitback(String taskId, String ip, String username);  //审核驳回按钮

    String aduitok(String taskId,Integer uid, String ip, String username);   //审核通过按钮

    String goComplete(String taskId, String ip, String username);  //取消申请按钮

    String applyAgain(String taskId, String ip, String username); //重新申请按钮

    Map<String,Object> selectRunningTask(Integer uid, String ip, String username); //查询该用户提交申请中正在进行审批的流程

    Map<String,Object> selectRunedTask(Integer uid, String ip, String username); //查询该用户提交申请中已经运行结束的流程*/
}
