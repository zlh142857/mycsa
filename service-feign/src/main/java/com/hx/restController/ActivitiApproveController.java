package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 13:41
 *@功能:工作流审批,提交申请
 */

import com.hx.Activiti.ActMsg;
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
    public String lCountryRefer(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsg") ActMsg actMsg){
        String referMsg=activitiApproveService.lCountryRefer(userInfo,actMsg);
        return referMsg;
    }
    public String lCountryReferError(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsg") ActMsg actMsg) {
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
    public String goWorkRefer(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsg") ActMsg actMsg){
        String referMsg=activitiApproveService.goWorkRefer(userInfo,actMsg);
        return referMsg;
    }
    public String goWorkReferError(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsg") ActMsg actMsg) {
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
    public String lPostRefer(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsg") ActMsg actMsg){
        String referMsg=activitiApproveService.lPostRefer(userInfo,actMsg);
        return referMsg;
    }
    public String lPostReferError(@RequestParam("userInfo") UserInfo userInfo,@RequestParam("actMsg") ActMsg actMsg) {
        return "服务未响应";
    }
}
