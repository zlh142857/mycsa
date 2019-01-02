package com.hx.service.impl.userinfo;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/19 15:10
 *@功能:
 */

import com.hx.shiro.SysPermission;
import com.hx.shiro.SysRole;
import com.hx.shiro.UserInfo;
import com.hx.config.md5.Md5;
import com.hx.config.md5.Salt;
import com.hx.dao.system.UserInfoRepository;
import com.hx.service.UserInfoService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public Map<String,Object> ajaxLogin(String name, String password) {
        Map<String,Object> map=new HashMap<>(  );
        try{
            if(name==null|| password==null){
                map.put( "msg","传值失败" );
                return map;
            }
            UsernamePasswordToken token;
            token = new UsernamePasswordToken(
                    name,
                    password
            );
            Subject subject = SecurityUtils.getSubject();
            //登录方法走realm
            subject.login(token);
            UserInfo userInfo=(UserInfo) subject.getPrincipal();
            //查询所有权限
            List<SysRole> roleList=userInfo.getRoleList();
            List<SysPermission> permissionsList=null;
            for (SysRole role : roleList) {
                permissionsList=role.getPermissions();
            }
            map.put("permissionsList", permissionsList);
            map.put("token", subject.getSession().getId());
            map.put("msg", "登录成功");
            map.put("userInfo", userInfo);
            return map;
        }catch (IncorrectCredentialsException e) {
            map.put("msg", "密码错误");
            return map;
        } catch (LockedAccountException e) {
            map.put("msg", "登录失败，该用户已被冻结");
            return map;
        } catch (AuthenticationException e) {
            map.put("msg", "该用户不存在");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        }catch (Throwable throwable){
            System.out.println(throwable);
            map.put( "msg","出错了,联系后台" );
            return map;
        }
    }

    @Override
    public void regisetUser() {
        String username="赵六";
        String password="123456";
        String salt=Salt.getSalt();
        String npassword=Md5.getPassword( username,password,salt );
        UserInfo userInfo=new UserInfo();
        userInfo.setPersonnelName( "赵六" );
        userInfo.setPassword( npassword );
        userInfo.setSalt( salt );
        userInfo.setUsername( username );
        userInfoRepository.save( userInfo );
    }

}
