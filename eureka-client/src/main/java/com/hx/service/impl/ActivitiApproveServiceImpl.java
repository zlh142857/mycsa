package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 14:59
 *@功能:
 */

import com.hx.Activiti.ActMsg;
import com.hx.UserInfo;
import com.hx.config.utils.ProKey;
import com.hx.dao.ActivitiRepository;
import com.hx.dao.UserInfoRepository;
import com.hx.service.ActivitiApproveService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivitiApproveServiceImpl implements ActivitiApproveService {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ActivitiRepository activitiRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public String lCountryRefer(UserInfo userInfo, ActMsg actMsg) {
        try{
            //启动流程实例
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("inputUser", userInfo.getUid());
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProKey.CommonKey,variables);
            //将流程id放到这个用户的流程关联表中
            actMsg.setUid( userInfo.getUid());
            ActMsg actMsg1=activitiRepository.save(actMsg);
            String refMsg="申请失败";
            if(actMsg1 != null){
                Map<String, Object> variables2 = new HashMap<String, Object>();
                variables2.put("name",actMsg.getName());
                variables2.put("post",actMsg.getPost());
                variables2.put("reason",actMsg.getReason());
                variables2.put("lcTime",actMsg.getLcTime());
                variables2.put("backTime",actMsg.getBackTime());
                variables2.put("goWhere",actMsg.getGoWhere());
                variables2.put("dept",actMsg.getDept());
                variables2.put("phone",actMsg.getPhone());
                variables2.put("type","离境");
                Long uid=userInfoRepository.findUserByDeptCodeAndDeptLeader(userInfo.getDeptCode(),userInfo.getDeptLeader());
                variables2.put("userID1", uid.toString());//查找该用户领导,将其领导做为下一个审批人
                //用户确认申请请假,提交到下一个节点
                List<Task> list = taskService.createTaskQuery().taskAssignee(userInfo.getUid().toString()).list();
                if(list!=null && list.size()>0){
                    for(Task task:list){
                        if(task.getProcessInstanceId().equals( pi.getId() )){
                            synchronized (task.getId()){
                                taskService.complete( task.getId(),variables2 );
                            }
                            refMsg="申请成功";
                            return refMsg;
                        }
                    }
                    return refMsg;
                }else{
                    return refMsg;
                }
            }else{
                return refMsg;
            }
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            String refMsg="申请失败";
            return refMsg;
        }
    }

    @Override
    public String goWorkRefer(UserInfo userInfo, ActMsg actMsg) {
        try{
            //启动流程实例
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("inputUser", userInfo.getUid());
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProKey.CommonKey,variables);
            //将流程id放到这个用户的流程关联表中
            actMsg.setUid( userInfo.getUid());
            ActMsg actMsg1=activitiRepository.save(actMsg);
            String refMsg="申请失败";
            if(actMsg1 != null){
                Map<String, Object> variables2 = new HashMap<String, Object>();
                variables2.put("name",actMsg.getName());
                variables2.put("post",actMsg.getPost());
                variables2.put("workContent",actMsg.getWorkContent());
                variables2.put("toWorkTime",actMsg.getToWorkTime());
                variables2.put("birTime",actMsg.getBirTime());
                variables2.put("deptLeader",actMsg.getDeptLeader());
                variables2.put("dept",actMsg.getDept());
                variables2.put("phone",actMsg.getPhone());
                variables2.put("isMiCode",actMsg.getIsMiCode());
                variables2.put("type","上岗");
                Long uid=userInfoRepository.findUserByDeptCodeAndDeptLeader(userInfo.getDeptCode(),userInfo.getDeptLeader());
                variables2.put("userID1", uid.toString());//查找该用户领导,将其领导做为下一个审批人
                //用户确认申请请假,提交到下一个节点
                List<Task> list = taskService.createTaskQuery().taskAssignee(userInfo.getUid().toString()).list();
                if(list!=null && list.size()>0){
                    for(Task task:list){
                        if(task.getProcessInstanceId().equals( pi.getId() )){
                            synchronized (task.getId()){
                                taskService.complete( task.getId(),variables2 );
                            }
                            refMsg="申请成功";
                            return refMsg;
                        }
                    }
                    return refMsg;
                }else{
                    return refMsg;
                }
            }else{
                return refMsg;
            }
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            String refMsg="申请失败";
            return refMsg;
        }
    }

    @Override
    public String lPostRefer(UserInfo userInfo, ActMsg actMsg) {
        try{
            //启动流程实例
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("inputUser", userInfo.getUid());
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProKey.CommonKey,variables);
            //将流程id放到这个用户的流程关联表中
            actMsg.setUid( userInfo.getUid());
            ActMsg actMsg1=activitiRepository.save(actMsg);
            String refMsg="申请失败";
            if(actMsg1 != null){
                Map<String, Object> variables2 = new HashMap<String, Object>();
                variables2.put("name",actMsg.getName());
                variables2.put("post",actMsg.getPost());
                variables2.put("reason",actMsg.getReason());
                variables2.put("lPostTime",actMsg.getLPostTime());
                variables2.put("deptLeader",actMsg.getDeptLeader());
                variables2.put("dept",actMsg.getDept());
                variables2.put("phone",actMsg.getPhone());
                variables2.put("isMiCode",actMsg.getIsMiCode());
                variables2.put("type","离职");
                Long uid=userInfoRepository.findUserByDeptCodeAndDeptLeader(userInfo.getDeptCode(),userInfo.getDeptLeader());
                variables2.put("userID1", uid.toString());//查找该用户领导,将其领导做为下一个审批人
                //用户确认申请请假,提交到下一个节点
                List<Task> list = taskService.createTaskQuery().taskAssignee(userInfo.getUid().toString()).list();
                if(list!=null && list.size()>0){
                    for(Task task:list){
                        if(task.getProcessInstanceId().equals( pi.getId() )){
                            synchronized (task.getId()){
                                taskService.complete( task.getId(),variables2 );
                            }
                            refMsg="申请成功";
                            return refMsg;
                        }
                    }
                    return refMsg;
                }else{
                    return refMsg;
                }
            }else{
                return refMsg;
            }
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            String refMsg="申请失败";
            return refMsg;
        }
    }
}
