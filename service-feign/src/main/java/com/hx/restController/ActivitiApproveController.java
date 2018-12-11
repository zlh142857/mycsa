package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 13:41
 *@功能:工作流审批,提交申请
 */

import com.hx.Activiti.ActMsgPersonnel;
import com.hx.UserInfo;
import com.hx.service.ActivitiApproveService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "activitiApprove")
public class ActivitiApproveController {
    @Autowired
    private ActivitiApproveService activitiApproveService;
    /**
     *
     * 功能描述: 提交申请
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/10 13:42
     */
    @RequestMapping(value = "/lCountryRefer",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod ="lCountryReferError")
    @ResponseBody
    public String lCountryRefer(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsgPersonnel") ActMsgPersonnel actMsgPersonnel){
        String referMsg=activitiApproveService.lCountryRefer(userInfo, actMsgPersonnel );
        return referMsg;
    }
    public String lCountryReferError(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsgPersonnel") ActMsgPersonnel actMsgPersonnel) {
        return "服务未响应";
    }
    /**
     *
     * 功能描述: 上岗审批
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/10 15:55
     */
    @RequestMapping(value = "/goWorkRefer",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod ="goWorkReferError")
    @ResponseBody
    public String goWorkRefer(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsgPersonnel") ActMsgPersonnel actMsgPersonnel){
        String referMsg=activitiApproveService.goWorkRefer(userInfo, actMsgPersonnel );
        return referMsg;
    }
    public String goWorkReferError(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsgPersonnel") ActMsgPersonnel actMsgPersonnel) {
        return "服务未响应";
    }

    /**
     *
     * 功能描述: 离职审批
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/10 15:55
     */
    @RequestMapping(value = "/lPostRefer",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod ="lPostReferError")
    @ResponseBody
    public String lPostRefer(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsgPersonnel") ActMsgPersonnel actMsgPersonnel){
        String referMsg=activitiApproveService.lPostRefer(userInfo, actMsgPersonnel );
        return referMsg;
    }
    public String lPostReferError(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsgPersonnel") ActMsgPersonnel actMsgPersonnel) {
        return "服务未响应";
    }
    /**
     *
     * 功能描述: 查询自己要审批的离境任务
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/11 9:17
     */
    @RequestMapping(value = "/selectSelfLCTask",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="selectSelfTaskError")
    @ResponseBody
    public String selectSelfLCTask(@RequestParam("uid") String uid){
        String map=activitiApproveService.selectSelfLCTask(uid);
        return map;
    }
    /**
     *
     * 功能描述: 查询自己要审批的上岗任务
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 10:06
     */
    @RequestMapping(value = "/selectSelfTWTask",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="selectSelfTaskError")
    @ResponseBody
    public String selectSelfTWTask(@RequestParam("uid") String uid){
        String map=activitiApproveService.selectSelfTWTask(uid);
        return map;
    }
    /**
     *
     * 功能描述: 查询自己要审批的离职任务
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 10:12
     */
    @RequestMapping(value = "/selectSelfLPTask",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="selectSelfTaskError")
    @ResponseBody
    public String selectSelfLPTask(@RequestParam("uid") String uid){
        String map=activitiApproveService.selectSelfLPTask(uid);
        return map;
    }
    public String selectSelfTaskError(@RequestParam("uid") String uid) {
        return "服务未响应";
    }
    /**
     *
     * 功能描述: 审核驳回按钮
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 13:30
     */
    @RequestMapping(value = "/aduitback",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="aduitError")
    @ResponseBody
    public String aduitback(@RequestParam("taskId") String taskId){
        String msg=activitiApproveService.aduitback(taskId);
        return msg;
    }
    /**
     *
     * 功能描述: 审核通过按钮
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 13:38
     */
    @RequestMapping(value = "/aduitok",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="aduitokError")
    @ResponseBody
    public String aduitok(@RequestParam("taskId") String taskId,@RequestParam("uid")Integer uid){
        String msg=activitiApproveService.aduitok(taskId,uid);
        return msg;
    }
    public String aduitokError(@RequestParam("taskId") String taskId,@RequestParam("uid")Integer uid) {
        return "服务未响应";
    }
    /**
     *
     * 功能描述: 取消申请按钮
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/11 14:44
     */
    @RequestMapping(value = "/goComplete",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="aduitError")
    @ResponseBody
    public String goComplete(@RequestParam("taskId") String taskId){
        String msg=activitiApproveService.goComplete(taskId);
        return msg;
    }
    /**
     *
     * 功能描述: 重新申请按钮
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 15:39
     */
    @RequestMapping(value = "/applyAgain",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="aduitError")
    @ResponseBody
    public String applyAgain(@RequestParam("taskId") String taskId){
        String msg=activitiApproveService.applyAgain(taskId);
        return msg;
    }
    public String aduitError(@RequestParam("taskId") String taskId) {
        return "服务未响应";
    }

    /**
     *
     * 功能描述: 查询该用户提交申请中正在进行审批的流程
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/11 15:44
     */
    @RequestMapping(value = "/selectRunningTask",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="selectTaskError")
    @ResponseBody
    public String selectRunningTask(@RequestParam("uid") Integer uid){
        String msg=activitiApproveService.selectRunningTask(uid);
        return msg;
    }
    /**
     *
     * 功能描述: 查询该用户提交申请中已经运行结束的流程
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 16:14
     */
    @RequestMapping(value = "/selectRunedTask",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="selectTaskError")
    @ResponseBody
    public String selectRunedTask(@RequestParam("uid") Integer uid){
        String msg=activitiApproveService.selectRunedTask(uid);
        return msg;
    }
    public String selectTaskError(@RequestParam("uid") Integer uid) {
        return "服务未响应";
    }
}
