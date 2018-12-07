package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:25
 *@功能:
 */

import com.hx.service.FileAcceptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/fileAccept")
public class FileAccept {
    @Autowired
    private FileAcceptService fileAcceptService;
    @RequestMapping(value = "/fileAcceptList",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean fileAcceptList(){
        return fileAcceptService.fileAcceptList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
