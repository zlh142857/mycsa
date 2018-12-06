package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:46
 *@功能:
 */

import com.hx.service.LrealmMenageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value="/lrealmMenage")
public class LrealmMenage {
    @Resource
    private LrealmMenageService lrealmMenageService;
    @RequestMapping(value = "/lrealmList",method = RequestMethod.GET)
    @ResponseBody
    public boolean lrealmList(){
        return lrealmMenageService.lrealmList();
    }
}
