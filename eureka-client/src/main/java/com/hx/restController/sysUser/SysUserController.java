package com.hx.restController.sysUser;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/17 16:54
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.Object.MuchObj;
import com.hx.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @PostMapping(value = "/inputUser")
    @ResponseBody
    public String inputUser(@RequestBody MuchObj muchObj,@RequestParam("ip") String ip){
        Map<String,Object> map=sysUserService.inputUser(muchObj,ip);
        return JSONObject.toJSONString( map );
    }
}
