package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 14:57
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.Activiti.ActMsgPersonnel;
import com.hx.UserInfo;
import com.hx.service.ActivitiApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "activitiApprove")
public class ActivitiApproveController {
    @Autowired
    private ActivitiApproveService activitiApproveService;
    /**
     *
     * 功能描述: 离境申请
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/10 13:42
     */
    @PostMapping(value = "/lCountryRefer")
    @ResponseBody
    public String lCountryRefer(@RequestParam("userInfo") UserInfo userInfo, @RequestParam("actMsgPersonnel") ActMsgPersonnel actMsgPersonnel){
        String referMsg=activitiApproveService.lCountryRefer(userInfo, actMsgPersonnel );
        return JSONObject.toJSONString( referMsg );
    }
    /**
     *
     * 功能描述: 上岗申请
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/10 16:09
     */
    @PostMapping(value = "/goWorkRefer")
    @ResponseBody
    public String goWorkRefer(@RequestParam("userInfo") UserInfo userInfo, @RequestParam("actMsgPersonnel") ActMsgPersonnel actMsgPersonnel){
        String referMsg=activitiApproveService.goWorkRefer(userInfo, actMsgPersonnel );
        return JSONObject.toJSONString( referMsg );
    }
    /**
     *
     * 功能描述: 离岗申请
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/10 16:09
     */
    @PostMapping(value = "/lPostRefer")
    @ResponseBody
    public String lPostRefer(@RequestParam("userInfo") UserInfo userInfo, @RequestParam("actMsgPersonnel") ActMsgPersonnel actMsgPersonnel){
        String referMsg=activitiApproveService.lPostRefer(userInfo, actMsgPersonnel );
        return JSONObject.toJSONString( referMsg );
    }
    /**
     *
     * 功能描述: 查询自己要审批的离境任务
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 9:18
     */
    @GetMapping(value = "/selectSelfLCTask")
    @ResponseBody
    public String selectSelfLCTask(@RequestParam("uid") String uid){
        Map<String,Object> map=activitiApproveService.selectSelfLCTask(uid );
        return JSONObject.toJSONStringWithDateFormat( map,"yyyy-MM-dd HH:mm:ss" );
    }
    /**
     *
     * 功能描述:查询自己要审批的上岗任务
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 10:07
     */
    @GetMapping(value = "/selectSelfTWTask")
    @ResponseBody
    public String selectSelfTWTask(@RequestParam("uid") String uid){
        Map<String,Object> map=activitiApproveService.selectSelfTWTask(uid );
        return JSONObject.toJSONStringWithDateFormat( map,"yyyy-MM-dd HH:mm:ss" );
    }
    /**
     *
     * 功能描述: 查询自己要审批的离职任务
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 10:13
     */
    @GetMapping(value = "/selectSelfLPTask")
    @ResponseBody
    public String selectSelfLPTask(@RequestParam("uid") String uid){
        Map<String,Object> map=activitiApproveService.selectSelfLPTask(uid );
        return JSONObject.toJSONStringWithDateFormat( map,"yyyy-MM-dd HH:mm:ss" );
    }
    /**
     *
     * 功能描述: 审核驳回按钮
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 13:32
     */
    @GetMapping(value = "/aduitback")
    @ResponseBody
    public String aduitback(@RequestParam("taskId") String taskId){
        String msg=activitiApproveService.aduitback(taskId );
        return JSONObject.toJSONString( msg);
    }
    /**
     *
     * 功能描述: 审核通过按钮
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 14:18
     */
    @GetMapping(value = "/aduitok")
    @ResponseBody
    public String aduitok(@RequestParam("taskId") String taskId,@RequestParam("uid")Integer uid){
        String msg=activitiApproveService.aduitok(taskId,uid );
        return JSONObject.toJSONString( msg);
    }
    /**
     *
     * 功能描述: 取消申请按钮
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 15:25
     */
    @GetMapping(value = "/goComplete")
    @ResponseBody
    public String goComplete(@RequestParam("taskId") String taskId){
        String msg=activitiApproveService.goComplete(taskId);
        return JSONObject.toJSONString( msg);
    }
    /**
     *
     * 功能描述: 重新申请按钮
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 15:40
     */
    @GetMapping(value = "/applyAgain")
    @ResponseBody
    public String applyAgain(@RequestParam("taskId") String taskId){
        String msg=activitiApproveService.applyAgain(taskId);
        return JSONObject.toJSONString( msg);
    }
    /**
     *
     * 功能描述: 查询该用户提交申请中正在进行审批的流程
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 15:48
     */
    @GetMapping(value = "/selectRunningTask")
    @ResponseBody
    public String selectRunningTask(@RequestParam("uid")Integer uid){
        Map<String,Object> map=activitiApproveService.selectRunningTask(uid);
        return JSONObject.toJSONString( map);
    }
    /**
     *
     * 功能描述: 查询该用户提交申请中已经运行结束的流程
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/11 16:16
     */
    @GetMapping(value = "/selectRunedTask")
    @ResponseBody
    public String selectRunedTask(@RequestParam("uid")Integer uid){
        Map<String,Object> map=activitiApproveService.selectRunedTask(uid);
        return JSONObject.toJSONString( map);
    }
}