package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:55
 *@功能:
 */

import com.hx.service.LjobMenageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/ljobMenage")
public class LjobMenage {
    @Autowired
    private LjobMenageService ljobMenageService;
    @RequestMapping(value = "/ljobList",method = RequestMethod.GET)
    public boolean ljobList(){
        return true;
    }
}
