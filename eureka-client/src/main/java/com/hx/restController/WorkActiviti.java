package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:41
 *@功能:
 */

import com.hx.service.WorkActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/workActiviti")
public class WorkActiviti {
    @Autowired
    private WorkActivitiService workActivitiService;
    @RequestMapping(value = "/workExamine",method = RequestMethod.GET)
    public boolean workExamine(){
        return workActivitiService.workExam();
    }

}
