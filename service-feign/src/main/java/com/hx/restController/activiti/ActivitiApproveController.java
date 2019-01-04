package com.hx.restController.activiti;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 13:41
 *@功能:工作流审批,提交申请
 */

import com.hx.Object.MuchObj;
import com.hx.component.GetIpUtil;
import com.hx.service.activiti.ActivitiApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    @PostMapping(value = "/lCountryRefer")
    @ResponseBody
    public String lCountryRefer(@RequestBody MuchObj muchObj, HttpServletRequest request){
        String ip=GetIpUtil.getIpAddr( request );
        String referMsg=activitiApproveService.lCountryRefer(muchObj,ip);
        return referMsg;
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
    @ResponseBody
    public String goWorkRefer(@RequestBody MuchObj muchObj, HttpServletRequest request){
        String ip=GetIpUtil.getIpAddr( request );
        String referMsg=activitiApproveService.goWorkRefer(muchObj,ip );
        return referMsg;
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
    @ResponseBody
    public String lPostRefer(@RequestBody MuchObj muchObj, HttpServletRequest request){
        String ip=GetIpUtil.getIpAddr( request );
        String referMsg=activitiApproveService.lPostRefer(muchObj,ip);
        return referMsg;
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
    @ResponseBody
    public String selectSelfLCTask(@RequestParam("uid") String uid, HttpServletRequest request,@RequestParam("username")String username){
        String ip=GetIpUtil.getIpAddr( request );
        String map=activitiApproveService.selectSelfLCTask(uid,ip,username);
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
    @ResponseBody
    public String selectSelfTWTask(@RequestParam("uid") String uid, HttpServletRequest request,@RequestParam("username")String username){
        String ip=GetIpUtil.getIpAddr( request );
        String map=activitiApproveService.selectSelfTWTask(uid,ip,username);
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
    @ResponseBody
    public String selectSelfLPTask(@RequestParam("uid") String uid, HttpServletRequest request,@RequestParam("username")String username){
        String ip=GetIpUtil.getIpAddr( request );
        String map=activitiApproveService.selectSelfLPTask(uid,ip,username);
        return map;
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
    @ResponseBody
    public String aduitback(@RequestParam("taskId") String taskId, HttpServletRequest request,@RequestParam("username")String username){
        String ip=GetIpUtil.getIpAddr( request );
        String msg=activitiApproveService.aduitback(taskId,ip,username);
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
    @ResponseBody
    public String aduitok(@RequestParam("taskId") String taskId,@RequestParam("uid")Integer uid, HttpServletRequest request,@RequestParam("username")String username){
        String ip=GetIpUtil.getIpAddr( request );
        String msg=activitiApproveService.aduitok(taskId,uid,ip,username);
        return msg;
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
    @ResponseBody
    public String goComplete(@RequestParam("taskId") String taskId, HttpServletRequest request,@RequestParam("username")String username){
        String ip=GetIpUtil.getIpAddr( request );
        String msg=activitiApproveService.goComplete(taskId,ip,username);
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
    @ResponseBody
    public String applyAgain(@RequestParam("taskId") String taskId, HttpServletRequest request,@RequestParam("username")String username){
        String ip=GetIpUtil.getIpAddr( request );
        String msg=activitiApproveService.applyAgain(taskId,ip,username);
        return msg;
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
    @ResponseBody
    public String selectRunningTask(@RequestParam("uid") Integer uid, HttpServletRequest request,@RequestParam("username")String username){
        String ip=GetIpUtil.getIpAddr( request );
        String msg=activitiApproveService.selectRunningTask(uid,ip,username);
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
    @ResponseBody
    public String selectRunedTask(@RequestParam("uid") Integer uid, HttpServletRequest request,@RequestParam("username")String username){
        String ip=GetIpUtil.getIpAddr( request );
        String msg=activitiApproveService.selectRunedTask(uid,ip,username);
        return msg;
    }
}
