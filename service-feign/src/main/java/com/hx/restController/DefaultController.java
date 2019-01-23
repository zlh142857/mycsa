package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:26
 *@功能:默认访问页面
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.component.GetIpUtil;
import com.hx.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DefaultController {
    @Autowired
    private SysUserService sysUserService;


    /**
     *
     * 功能描述: 默认访问接口
     *
     * 业务逻辑:人员录入其实就是注册,在用户首次插入key时,先判断sysUser表中是否有该用户,没有的话就跳转到人员录入界面,有该用户,后台自动登录,然后跳转页面至首页
     *
     * @param: key或者是token,key好一些,因为可以直接查询,token因为权限机制不同,所以无法解析用户信息
     * @return: boolean flag
     * @auther: 张立恒
     * @date: 2019/1/16 10:54
     */
    @RequestMapping(value = "/")
    @ResponseBody
    public String defaultMenu(@RequestParam("key") String key, HttpServletRequest request){
        //从request获取ip地址
        String ip=GetIpUtil.getIpAddr( request );
        //拿到key,直接去数据库表中查询,是否存在该用户,key为该用户唯一标识之一
        boolean flag=sysUserService.findByKey(key,ip);
        Map<String,Object> map=new HashMap<>(  );
        if(flag){
            //为true,已存在,直接登录
            String info=sysUserService.toLogin(key,ip);
            //跳转到首页,由前端判断,进行跳转页面
            map.put( "flag",flag );
            map.put( "info",info );
        }else{
            //跳转到录入界面
            map.put( "flag",flag );
        }
        return JSONObject.toJSONString( map );
    }

}
