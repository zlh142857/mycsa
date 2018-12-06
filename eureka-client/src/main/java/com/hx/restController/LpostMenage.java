package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:51
 *@功能:
 */

import com.hx.service.LpostMenageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/lpostMenage")
public class LpostMenage {
    @Autowired
    private LpostMenageService lpostMenageService;
    @RequestMapping(value = "/lpostList",method = RequestMethod.GET)
    public boolean lpostList(){
        return true;
    }

}
