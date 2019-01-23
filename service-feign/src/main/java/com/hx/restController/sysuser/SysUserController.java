package com.hx.restController.sysuser;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/16 10:51
 *@功能:
 */

import com.hx.Object.MuchObj;
import com.hx.component.GetIpUtil;
import com.hx.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    /**
     *
     * 功能描述: 人员录入
     *
     * 业务逻辑:
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2019/1/17 16:50
     */
    @PostMapping(value = "/inputUser")
    @ResponseBody
    public String inputUser(@RequestBody MuchObj muchObj, HttpServletRequest request){
        String ip=GetIpUtil.getIpAddr( request );
        return sysUserService.inputUser(muchObj,ip);
    }

}
