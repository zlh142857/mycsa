package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:36
 *@功能:
 */

import com.hx.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/toLogin")
public class ToLogin {
    @Autowired
    private UserInfoService userInfoService;
    /**
     * 登录方法
     * @param
     * @return
     * String username,String password,boolean rememberMe
     *
    /* *//*
    @RequestMapping(value = "/ajaxLogin",method = RequestMethod.POST)
    @ResponseBody
    public String ajaxLogin(String name,String password,boolean rememberMe) {
        try{
            JSONObject jsonObject=new JSONObject(  );
            if(name==null|| password==null){
                return jsonObject.put( "msg","传值失败" ).toString();
            }
            UsernamePasswordToken token;
            //
            if(rememberMe){
                //token= new UsernamePasswordToken(username,password,rememberMe);
                token = new UsernamePasswordToken(
                        *//*AESUtils.dcodes( name ),
                        AESUtils.dcodes( password ),*//*
                        name,
                        password,
                        rememberMe
                );
                Subject subject = SecurityUtils.getSubject();
                try {
                    //登录方法走realm
                    subject.login(token);
                    UserInfo userInfo=(UserInfo) subject.getPrincipal();
            *//*UserInfo userInfo = userInfoService.findByUsername(username);
            List<SysRole> roleList=userInfo.getRoleList();
            List<SysPermission> permissionsList=null;
            for (SysRole role : roleList) {
                 permissionsList=role.getPermissions();
            }
            System.out.println(permissionsList+"11111111111111111111111111111");*//*
                    jsonObject.put("name",AESUtils.ecodes("{username:\""+name+"\"}"));
                    jsonObject.put( "password",AESUtils.ecodes("{password:\""+password+"\"}") );
                    jsonObject.put("token", subject.getSession().getId());
                    jsonObject.put("userId", userInfo.getUid());
                    jsonObject.put("msg", "登录成功");
                } catch (IncorrectCredentialsException e) {
                    jsonObject.put("msg", "密码错误");
                } catch (LockedAccountException e) {
                    jsonObject.put("msg", "登录失败，该用户已被冻结");
                } catch (AuthenticationException e) {
                    jsonObject.put("msg", "该用户不存在");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return jsonObject.toString();
            }else{
                //token = new UsernamePasswordToken(username,password);
                token = new UsernamePasswordToken(
                        name,
                        password
                );
                Subject subject = SecurityUtils.getSubject();
                try {
                    //登录方法走realm
                    subject.login(token);
                    UserInfo userInfo=(UserInfo) subject.getPrincipal();
            *//*UserInfo userInfo = userInfoService.findByUsername(username);
            List<SysRole> roleList=userInfo.getRoleList();
            List<SysPermission> permissionsList=null;
            for (SysRole role : roleList) {
                 permissionsList=role.getPermissions();
            }
            System.out.println(permissionsList+"11111111111111111111111111111");*//*
                    jsonObject.put("token", subject.getSession().getId());
                    jsonObject.put("msg", "登录成功");
                    jsonObject.put("userId", userInfo.getUid());
                } catch (IncorrectCredentialsException e) {
                    jsonObject.put("msg", "密码错误");
                } catch (LockedAccountException e) {
                    jsonObject.put("msg", "登录失败，该用户已被冻结");
                } catch (AuthenticationException e) {
                    jsonObject.put("msg", "该用户不存在");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return jsonObject.toString();
            }
        }catch (Throwable throwable){
            System.out.println(throwable);
            return throwable.toString();
        }

    }*/
}
