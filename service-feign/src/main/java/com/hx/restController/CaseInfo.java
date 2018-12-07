package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:39
 *@功能:
 */

import com.hx.service.CaseInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/caseInfo")
public class CaseInfo {
    @Autowired
    private CaseInfoService caseInfoService;
    @RequestMapping(value = "/caseList",method = RequestMethod.GET)
    @ResponseBody
    //@RequiresPermissions("caseInfo:view")
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean caseList(){
        return caseInfoService.caseList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
