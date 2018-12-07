package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:29
 *@功能:
 */

import com.hx.service.FileSendService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/fileSend")
public class FileSend {
    @Autowired
    private FileSendService fileSendService;
    @RequestMapping(value = "/fileSendList",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean fileSendList(){
        return fileSendService.fileSendList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
