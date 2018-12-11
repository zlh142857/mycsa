package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 14:59
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.Activiti.ActMsgPersonnel;
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

import java.util.*;

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
    public String lCountryRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel) {
        try{
            //启动流程实例
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("inputUser", userInfo.getUid());
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProKey.CommonKey,variables);
            //将流程id放到这个用户的流程关联表中
            actMsgPersonnel.setUid( userInfo.getUid());
            ActMsgPersonnel actMsgPersonnel1 =activitiRepository.save( actMsgPersonnel );
            String refMsg="申请失败";
            if(actMsgPersonnel1 != null){
                Map<String, Object> variables2 = new HashMap<String, Object>();
                variables2.put("name", actMsgPersonnel.getName());
                variables2.put("post", actMsgPersonnel.getPost());
                variables2.put("reason", actMsgPersonnel.getReason());
                variables2.put("lcTime", actMsgPersonnel.getLcTime());
                variables2.put("backTime", actMsgPersonnel.getBackTime());
                variables2.put("goWhere", actMsgPersonnel.getGoWhere());
                variables2.put("dept", actMsgPersonnel.getDept());
                variables2.put("phone", actMsgPersonnel.getPhone());
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
                            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功" );
                            return refMsg;
                        }
                    }
                    logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:没有找到相对应实例id的流程" );
                    return refMsg;
                }else{
                    logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:taskList==null" );
                    return refMsg;
                }
            }else{
                logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:actMsgPersonnel1==null" );
                return refMsg;
            }
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            String refMsg="申请失败";
            return refMsg;
        }
    }

    @Override
    public String goWorkRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel) {
        try{
            //启动流程实例
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("inputUser", userInfo.getUid());
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProKey.CommonKey,variables);
            //将流程id放到这个用户的流程关联表中
            actMsgPersonnel.setUid( userInfo.getUid());
            ActMsgPersonnel actMsgPersonnel1 =activitiRepository.save( actMsgPersonnel );
            String refMsg="申请失败";
            if(actMsgPersonnel1 != null){
                Map<String, Object> variables2 = new HashMap<String, Object>();
                variables2.put("name", actMsgPersonnel.getName());
                variables2.put("post", actMsgPersonnel.getPost());
                variables2.put("workContent", actMsgPersonnel.getWorkContent());
                variables2.put("toWorkTime", actMsgPersonnel.getToWorkTime());
                variables2.put("birTime", actMsgPersonnel.getBirTime());
                variables2.put("deptLeader", actMsgPersonnel.getDeptLeader());
                variables2.put("dept", actMsgPersonnel.getDept());
                variables2.put("phone", actMsgPersonnel.getPhone());
                variables2.put("isMiCode", actMsgPersonnel.getIsMiCode());
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
                            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功" );
                            refMsg="申请成功";
                            return refMsg;
                        }
                    }
                    logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:没有找到相对应实例id的流程" );
                    return refMsg;
                }else{
                    logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:taskList==null" );
                    return refMsg;
                }
            }else{
                logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:actMsgPersonnel1==null" );
                return refMsg;
            }
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            String refMsg="申请失败";
            return refMsg;
        }
    }

    @Override
    public String lPostRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel) {
        try{
            //启动流程实例
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("inputUser", userInfo.getUid());
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProKey.CommonKey,variables);
            //将流程id放到这个用户的流程关联表中
            actMsgPersonnel.setUid( userInfo.getUid());
            ActMsgPersonnel actMsgPersonnel1 =activitiRepository.save( actMsgPersonnel );
            String refMsg="申请失败";
            if(actMsgPersonnel1 != null){
                Map<String, Object> variables2 = new HashMap<String, Object>();
                variables2.put("name", actMsgPersonnel.getName());
                variables2.put("post", actMsgPersonnel.getPost());
                variables2.put("reason", actMsgPersonnel.getReason());
                variables2.put("lPostTime", actMsgPersonnel.getLPostTime());
                variables2.put("deptLeader", actMsgPersonnel.getDeptLeader());
                variables2.put("dept", actMsgPersonnel.getDept());
                variables2.put("phone", actMsgPersonnel.getPhone());
                variables2.put("isMiCode", actMsgPersonnel.getIsMiCode());
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
                            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功" );
                            refMsg="申请成功";
                            return refMsg;
                        }
                    }
                    logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:没有找到相对应实例id的流程" );
                    return refMsg;
                }else{
                    logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:taskList==null" );
                    return refMsg;
                }
            }else{
                logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:actMsgPersonnel1==null" );
                return refMsg;
            }
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            String refMsg="申请失败";
            return refMsg;
        }
    }

    @Override
    public Map<String,Object> selectSelfTask(String uid) {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<Task> list= taskService.createTaskQuery().taskAssignee(uid).list();
            List<ActMsgPersonnel> taskList = new ArrayList<>(  );
            for(Task task:list){
                String type=taskService.getVariable( task.getId(),"type" ).toString();
                if(type=="离境"){
                    ActMsgPersonnel actMsg= new ActMsgPersonnel();
                    actMsg.setTaskId( task.getId() );
                    actMsg.setTaskName( task.getName() );
                    actMsg.setName( taskService.getVariable( task.getId(),"name" ).toString() );
                    actMsg.setPost( taskService.getVariable( task.getId(),"post" ).toString() );
                    actMsg.setReason( taskService.getVariable( task.getId(),"reason" ).toString() );
                    actMsg.setLcTime( (Date) taskService.getVariable( task.getId(),"lcTime" ) );
                    actMsg.setBackTime( (Date)taskService.getVariable( task.getId(),"backTime" ) );
                    actMsg.setGoWhere( taskService.getVariable( task.getId(),"goWhere" ).toString() );
                    actMsg.setDept( taskService.getVariable( task.getId(),"dept" ).toString() );
                    actMsg.setPhone( taskService.getVariable( task.getId(),"phone" ).toString() );
                    actMsg.setApplyUserName(taskService.getVariable( task.getId(),"name" ).toString());
                    actMsg.setCreateTime( task.getCreateTime() );
                    taskList.add( actMsg );
                }
            }
            map.put( "taskList",taskList );
            map.put( "msg","获取信息成功" );
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功" );
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","获取信息失败" );
            return map;
        }
    }
}
