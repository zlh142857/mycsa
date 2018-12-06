package com.hx.controller;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/15 17:02
 *@功能:
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = {"/toLoginHtml","/"},method = RequestMethod.GET)
    public String toLoginHtml(){
        return "/index.html";
    }
}
