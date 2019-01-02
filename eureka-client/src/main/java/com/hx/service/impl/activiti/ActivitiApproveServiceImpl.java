package com.hx.service.impl.activiti;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 14:59
 *@功能:
 */

import com.hx.Activiti.ActMsgPersonnel;
import com.hx.component.GetIpUtil;
import com.hx.shiro.UserInfo;
import com.hx.config.utils.ActType;
import com.hx.config.utils.ProKey;
import com.hx.dao.activi.ActivitiRepository;
import com.hx.dao.system.UserInfoRepository;
import com.hx.service.ActivitiApproveService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
    public String lCountryRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel, HttpServletRequest request) {
        MDC.put( "username", userInfo.getUsername());
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        String refMsg="申请失败";
        try{
            //启动流程实例
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("inputUser", userInfo.getUid());
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProKey.CommonKey,variables);
            //将流程id放到这个用户的流程关联表中
            actMsgPersonnel.setUid( userInfo.getUid());
            actMsgPersonnel.setCreateTime( new Date(  ) );
            actMsgPersonnel.setProId( pi.getId());
            ActMsgPersonnel actMsgPersonnel1 =activitiRepository.save( actMsgPersonnel );
            if(actMsgPersonnel1 != null){
                Map<String, Object> variables2 = new HashMap<String, Object>();
                variables2.put("name", actMsgPersonnel.getName());
                variables2.put("post", actMsgPersonnel.getPost());
                variables2.put("reason", actMsgPersonnel.getReason());
                variables2.put("lcTime", actMsgPersonnel.getLcTime());
                variables2.put("backTime", actMsgPersonnel.getBackTime());
                variables2.put("goWhere", actMsgPersonnel.getGoWhere());
                variables2.put("dept", actMsgPersonnel.getDept());
                variables2.put("type",ActType.LC);
                variables2.put("message", "提交申请");
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
                            logger.info( "提交申请成功" );
                            refMsg="提交申请成功";
                            return refMsg;
                        }
                    }
                    logger.error( "没有找到相对应实例id的流程" );
                    return refMsg;
                }else{
                    logger.error( "taskList==null" );
                    return refMsg;
                }
            }else{
                logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:actMsgPersonnel1==null" );
                return refMsg;
            }
        }catch (Throwable throwable){
            logger.error(throwable.toString() );
            return refMsg;
        }
    }

    @Override
    public String goWorkRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel, HttpServletRequest request) {
        MDC.put( "username", userInfo.getUsername());
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        String refMsg="申请失败";
        try{
            //启动流程实例
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("inputUser", userInfo.getUid());
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProKey.CommonKey,variables);
            //将流程id放到这个用户的流程关联表中
            actMsgPersonnel.setUid( userInfo.getUid());
            actMsgPersonnel.setCreateTime( new Date(  ) );
            ActMsgPersonnel actMsgPersonnel1 =activitiRepository.save( actMsgPersonnel );
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
                variables2.put("type",ActType.TW);
                variables2.put("message", "提交申请");
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
                            logger.info( "提交申请成功" );
                            refMsg="提交申请成功";
                            return refMsg;
                        }
                    }

                    logger.info( "没有找到相对应实例id的流程" );
                    return refMsg;
                }else{
                    logger.info( "taskList==null" );
                    return refMsg;
                }
            }else{
                logger.info( "actMsgPersonnel1==null" );
                return refMsg;
            }
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            return refMsg;
        }
    }

    @Override
    public String lPostRefer(UserInfo userInfo, ActMsgPersonnel actMsgPersonnel, HttpServletRequest request) {
        MDC.put( "username", userInfo.getUsername());
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        String refMsg="申请失败";
        try{
            //启动流程实例
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("inputUser", userInfo.getUid());
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProKey.CommonKey,variables);
            //将流程id放到这个用户的流程关联表中
            actMsgPersonnel.setUid( userInfo.getUid());
            actMsgPersonnel.setCreateTime( new Date(  ) );
            ActMsgPersonnel actMsgPersonnel1 =activitiRepository.save( actMsgPersonnel );
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
                variables2.put("type", ActType.LP);
                variables2.put("message", "提交申请");
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
                            logger.info( "提交申请成功" );
                            refMsg="申请成功";
                            return refMsg;
                        }
                    }
                    logger.info( "没有找到相对应实例id的流程" );
                    return refMsg;
                }else{
                    logger.info( "taskList==null" );
                    return refMsg;
                }
            }else{
                logger.info( "actMsgPersonnel1==null" );
                return refMsg;
            }
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            return refMsg;
        }
    }

    @Override
    public Map<String,Object> selectSelfLCTask(String uid, HttpServletRequest request, String username) {
        MDC.put( "username",username);
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        Map<String,Object> map=new HashMap<>(  );
        try{
            List<Task> list= taskService.createTaskQuery().taskAssignee(uid).list();
            List<ActMsgPersonnel> taskList = new ArrayList<>(  );
            for(Task task:list){
                String type=taskService.getVariable( task.getId(),"type" ).toString();
                if(type==ActType.LC){
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
            logger.info( "获取待审批任务成功" );
            return map;
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            map.put( "msg","获取信息失败" );
            return map;
        }
    }

    @Override
    public Map<String, Object> selectSelfTWTask(String uid, HttpServletRequest request, String username) {
        MDC.put( "username",username);
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        Map<String,Object> map=new HashMap<>(  );
        try{
            List<Task> list= taskService.createTaskQuery().taskAssignee(uid).list();
            List<ActMsgPersonnel> taskList = new ArrayList<>(  );
            for(Task task:list){
                String type=taskService.getVariable( task.getId(),"type" ).toString();
                if(type==ActType.TW){
                    ActMsgPersonnel actMsg= new ActMsgPersonnel();
                    actMsg.setTaskId( task.getId() );
                    actMsg.setTaskName( task.getName() );
                    actMsg.setName( taskService.getVariable( task.getId(),"name" ).toString() );
                    actMsg.setPost( taskService.getVariable( task.getId(),"post" ).toString() );
                    actMsg.setWorkContent( taskService.getVariable( task.getId(),"workContent" ).toString() );
                    actMsg.setToWorkTime( (Date) taskService.getVariable( task.getId(),"toWorkTime" ) );
                    actMsg.setBirTime( (Date)taskService.getVariable( task.getId(),"birTime" ) );
                    actMsg.setIsMiCode( (Integer)taskService.getVariable( task.getId(),"isMiCode" ));
                    actMsg.setDeptLeader( taskService.getVariable( task.getId(),"deptLeader" ).toString() );
                    actMsg.setApplyUserName(taskService.getVariable( task.getId(),"name" ).toString());
                    actMsg.setCreateTime( task.getCreateTime() );
                    taskList.add( actMsg );
                }
            }
            map.put( "taskList",taskList );
            map.put( "msg","获取信息成功" );
            logger.info( "获取待审批任务成功" );
            return map;
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            map.put( "msg","获取信息失败" );
            return map;
        }
    }

    @Override
    public Map<String, Object> selectSelfLPTask(String uid, HttpServletRequest request, String username) {
        Map<String,Object> map=new HashMap<>(  );
        MDC.put( "username",username);
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        try{
            List<Task> list= taskService.createTaskQuery().taskAssignee(uid).list();
            List<ActMsgPersonnel> taskList = new ArrayList<>(  );
            for(Task task:list){
                String type=taskService.getVariable( task.getId(),"type" ).toString();
                if(type==ActType.LP){
                    ActMsgPersonnel actMsg= new ActMsgPersonnel();
                    actMsg.setTaskId( task.getId() );
                    actMsg.setTaskName( task.getName() );
                    actMsg.setName( taskService.getVariable( task.getId(),"name" ).toString() );
                    actMsg.setPost( taskService.getVariable( task.getId(),"post" ).toString() );
                    actMsg.setWorkContent( taskService.getVariable( task.getId(),"workContent" ).toString() );
                    actMsg.setToWorkTime( (Date) taskService.getVariable( task.getId(),"toWorkTime" ) );
                    actMsg.setBirTime( (Date)taskService.getVariable( task.getId(),"birTime" ) );
                    actMsg.setIsMiCode( (Integer)taskService.getVariable( task.getId(),"isMiCode" ));
                    actMsg.setDeptLeader( taskService.getVariable( task.getId(),"deptLeader" ).toString() );
                    actMsg.setApplyUserName(taskService.getVariable( task.getId(),"name" ).toString());
                    actMsg.setCreateTime( task.getCreateTime() );
                    taskList.add( actMsg );
                }
            }
            map.put( "taskList",taskList );
            map.put( "msg","获取信息成功" );
            logger.info( "获取待审批任务成功" );
            return map;
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            map.put( "msg","获取信息失败" );
            return map;
        }
    }

    @Override
    public String aduitback(String taskId, HttpServletRequest request, String username) {
        MDC.put( "username",username);
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        String msg="";
        try{
            if(taskId==null || taskId==""){
                logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:taskId没有传值到后台" );
                return msg="taskId为空";
            }else{
                Map<String, Object> variables = new HashMap<String, Object>();
                variables.put("message", "驳回");
                synchronized (taskId){
                    taskService.complete(taskId,variables);
                }
                logger.info( "驳回成功" );
                return msg="驳回成功";
            }
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            return msg="程序出错,操作失败";
        }
    }

    @Override
    public String aduitok(String taskId,Integer uid, HttpServletRequest request, String username) {
        String msg="";
        MDC.put( "username",username);
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        try{
            if(taskId==null || uid ==null){
                logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:taskId或者uid没有传值到后台" );
                return msg="taskId为空,或者uid为空";
            }else{
                Map<String, Object> variables = new HashMap<String, Object>();
                variables.put("message", "批准");
                //获取用户的角色信息,根据用户角色判断是什么职位,不同的职位审批通过需要的工作流程图键值userID不同
                //根据用户的id查询角色id,再根据角色id查询角色
                String role=userInfoRepository.findRoleByUid(uid);
                if(role=="部门领导"){
                    //根据角色获取上级领导的uid
                    Integer upuid=userInfoRepository.findUidByRoleDept();
                    variables.put("userID2", upuid.toString());//查找该用户领导,将其领导做为下一个审批人
                    synchronized (taskId){
                        taskService.complete(taskId,variables);
                    }
                    logger.info( "部门领导审批通过" );
                    return msg="审批通过";
                }else if(role=="机要处领导"){
                    //根据角色获取上级领导的uid
                    Integer upuid=userInfoRepository.findUidByRoleDept();
                    variables.put("userID3", upuid.toString());//查找该用户领导,将其领导做为下一个审批人
                    synchronized (taskId){
                        taskService.complete(taskId,variables);
                    }
                    logger.info( "机要处领导审批通过" );
                    return msg="审批通过";
                }else if(role=="办公厅厅长"){
                    //审核通过之后,流程结束,需要改变actMagPersonnel表中的状态值,表示审批已经结束,等到查询已经结束的流程中可以直接查询
                    String pid=taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
                    Integer userid=(Integer) taskService.getVariable( taskId,"inputUser" );
                    int count=activitiRepository.updateStatusByPid(pid,userid,new Date(  ));
                    if(count == 0){
                        logger.error( "修改actMsgPersonnel表状态失败" );
                        return msg="审批失败";
                    }else{
                        synchronized (taskId){
                            taskService.complete(taskId,variables);
                        }
                        logger.info( "办公厅厅长审批通过" );
                        return msg="审批通过";
                    }
                }else{
                    logger.error( "该用户角色没有审批权限" );
                    return msg="该用户角色没有审批权限";
                }
            }
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            return msg="程序出错,操作失败";
        }
    }

    @Override
    public String goComplete(String taskId, HttpServletRequest request, String username) {
        String msg="";
        MDC.put( "username",username);
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        try{
            if(taskId==null || taskId==""){
                logger.error( "taskId没有传值到后台" );
                return msg="taskId为空";
            }else{
                //审核通过之后,流程结束,需要改变actMagPersonnel表中的状态值,表示审批已经结束,等到查询已经结束的流程中可以直接查询
                String pid=taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
                Integer userid=(Integer) taskService.getVariable( taskId,"inputUser" );
                int count=activitiRepository.updateStatusByPid(pid,userid,new Date(  ));
                if(count == 0){
                    logger.error( "修改actMsgPersonnel表状态失败" );
                    return msg="操作失败";
                }else{
                    Map<String, Object> variables = new HashMap<String, Object>();
                    variables.put("message", "取消申请");
                    synchronized (taskId){
                        taskService.complete(taskId,variables);
                    }
                    logger.info( "取消申请成功" );
                    return msg="取消申请成功";
                }
            }
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            return msg="程序出错,操作失败";
        }
    }

    @Override
    public String applyAgain(String taskId, HttpServletRequest request, String username) {
        String msg="";
        MDC.put( "username",username);
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        try{
            if(taskId==null || taskId==""){
                logger.error( "taskId没有传值到后台" );
                return msg="taskId为空";
            }else{
                Map<String, Object> variables = new HashMap<String, Object>();
                variables.put("message", "提交申请");
                synchronized (taskId){
                    taskService.complete(taskId,variables);
                }
                logger.info( "重新申请成功" );
                return msg="重新申请成功";
            }
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            return msg="程序出错,操作失败";
        }
    }

    @Override
    public Map<String,Object> selectRunningTask(Integer uid, HttpServletRequest request, String username) {
        Map<String,Object> map=new HashMap<>(  );
        MDC.put( "username",username);
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        try{
            if(uid==null){
                logger.error( "uid没有传值到后台" );
                map.put( "msg","uid为空" );
                return map;
            }else{
                List<ActMsgPersonnel> list=activitiRepository.findRunningTask(uid);
                if(list != null){
                    map.put( "list",list );
                    map.put( "msg","查询成功" );
                    logger.info( "查询成功" );
                    return map;
                }else{
                    logger.error( "查询到的list为空" );
                    map.put( "msg","list为空" );
                    return map;
                }
            }
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            map.put( "msg","程序出错,操作失败" );
            return map;
        }
    }

    @Override
    public Map<String, Object> selectRunedTask(Integer uid, HttpServletRequest request, String username) {
        Map<String,Object> map=new HashMap<>(  );
        MDC.put( "username",username);
        MDC.put( "ip", GetIpUtil.getIpAddr(request) );
        try{
            if(uid==null){
                logger.error( "uid没有传值到后台" );
                map.put( "msg","uid为空" );
                return map;
            }else{
                List<ActMsgPersonnel> list=activitiRepository.findRunnedTask(uid);
                if(list != null){
                    map.put( "list",list );
                    map.put( "msg","查询成功" );
                    logger.info( ":查询成功" );
                    return map;
                }else{
                    logger.error( "查询到的list为空" );
                    map.put( "msg","list为空" );
                    return map;
                }
            }
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            map.put( "msg","程序出错,操作失败" );
            return map;
        }
    }
}
