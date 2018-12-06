package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:42
 *@功能:
 */

import com.hx.service.CaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/caseInfo")
public class CaseInfo {
    @Autowired
    private CaseInfoService caseInfoService;
    @RequestMapping(value = "/caseList",method = RequestMethod.GET)
    public boolean caseList(){
        return true;
    }
}
