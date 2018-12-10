package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 14:57
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.Activiti.ActMsg;
import com.hx.UserInfo;
import com.hx.service.ActivitiApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String lCountryRefer(@RequestParam("userInfo") UserInfo userInfo, @RequestParam("actMsg") ActMsg actMsg){
        String referMsg=activitiApproveService.lCountryRefer(userInfo,actMsg);
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
    public String goWorkRefer(@RequestParam("userInfo") UserInfo userInfo, @RequestParam("actMsg") ActMsg actMsg){
        String referMsg=activitiApproveService.goWorkRefer(userInfo,actMsg);
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
    public String lPostRefer(@RequestParam("userInfo") UserInfo userInfo, @RequestParam("actMsg") ActMsg actMsg){
        String referMsg=activitiApproveService.lPostRefer(userInfo,actMsg);
        return JSONObject.toJSONString( referMsg );
    }
}
