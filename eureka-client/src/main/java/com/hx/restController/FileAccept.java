package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:28
 *@功能:
 */

import com.hx.service.FileAcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/fileAccept")
public class FileAccept {
    @Autowired
    private FileAcceptService fileAcceptService;
    @RequestMapping(value = "/fileAcceptList",method = RequestMethod.GET)
    public boolean fileAcceptList(){
        return true;
    }
}
