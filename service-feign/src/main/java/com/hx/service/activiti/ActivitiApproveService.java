package com.hx.service.activiti;/*
 */

import com.hx.Activiti.ActMsgPersonnel;
import com.hx.Object.MuchObj;
import com.hx.shiro.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "eureka-client")
public interface ActivitiApproveService {
    @RequestMapping(value = "/activitiApprove/lCountryRefer",method = RequestMethod.POST)
    String lCountryRefer(@RequestBody MuchObj muchObj);
    @RequestMapping(value = "/activitiApprove/goWorkRefer",method = RequestMethod.POST)
    String goWorkRefer(@RequestBody MuchObj muchObj);
    @RequestMapping(value = "/activitiApprove/lPostRefer",method = RequestMethod.POST)
    String lPostRefer(@RequestBody MuchObj muchObj);
    @RequestMapping(value = "/activitiApprove/selectSelfLCTask",method = RequestMethod.GET)
    String selectSelfLCTask(@RequestParam("uid")String uid);
    @RequestMapping(value = "/activitiApprove/selectSelfTWTask",method = RequestMethod.GET)
    String selectSelfTWTask(@RequestParam("uid")String uid);
    @RequestMapping(value = "/activitiApprove/selectSelfLPTask",method = RequestMethod.GET)
    String selectSelfLPTask(@RequestParam("uid")String uid);
    @RequestMapping(value = "/activitiApprove/aduitback",method = RequestMethod.GET)
    String aduitback(@RequestParam("taskId")String taskId);
    @RequestMapping(value = "/activitiApprove/aduitok",method = RequestMethod.GET)
    String aduitok(@RequestParam("taskId")String taskId,@RequestParam("uid")Integer uid);
    @RequestMapping(value = "/activitiApprove/goComplete",method = RequestMethod.GET)
    String goComplete(@RequestParam("taskId") String taskId); //取消申请按钮
    @RequestMapping(value = "/activitiApprove/applyAgain",method = RequestMethod.GET)
    String applyAgain(@RequestParam("taskId")String taskId); //重新申请按钮
    @RequestMapping(value = "/activitiApprove/selectRunningTask",method = RequestMethod.GET)
    String selectRunningTask(@RequestParam("uid")Integer uid);  //查询该用户提交申请中正在进行审批的流程
    @RequestMapping(value = "/activitiApprove/selectRunedTask",method = RequestMethod.GET)
    String selectRunedTask(@RequestParam("uid")Integer uid); //查询该用户提交申请中已经运行结束的流程
}
