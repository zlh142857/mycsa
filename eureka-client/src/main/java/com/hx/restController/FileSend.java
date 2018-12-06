package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:31
 *@功能:
 */

import com.hx.service.FileSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping(value = "/fielSend")
public class FileSend {
    @Autowired
    private FileSendService fileSendService;
    @RequestMapping(value = "/fileSendList",method = RequestMethod.GET)
    public boolean fileSendList(){
        return true;
    }
}
