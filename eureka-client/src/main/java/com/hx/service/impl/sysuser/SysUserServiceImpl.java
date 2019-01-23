package com.hx.service.impl.sysuser;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/16 11:12
 *@功能:
 */

import com.hx.Object.MuchObj;
import com.hx.dao.SysUserFamilyRepo;
import com.hx.dao.SysUserRepo;
import com.hx.dao.SysUserResumeRepo;
import com.hx.pwcontrol.system.*;
import com.hx.service.SysUserService;
import com.hx.utils.Base;
import com.hx.utils.FtpUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private SysUserRepo sysUserRepo;
    @Autowired
    private SysUserResumeRepo sysUserResumeRepo;
    @Autowired
    private SysUserFamilyRepo sysUserFamilyRepo;
    /**
     *
     * 功能描述: 
     *
     * 业务逻辑:查询key是否存在,存在count就大于0,flag为true,否则为false,返回flag做为判断标识
     * 
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2019/1/18 15:27
     */
    @Override
    public boolean findByKey(String key, String ip) {
        MDC.put( "Uri", "/default");
        MDC.put( "QueryStr", key+","+ip);
        MDC.put( "VistorIp",ip );
        MDC.put( "Application","eureka-client" );
        int count=sysUserRepo.findCountByUserKey(key);
        boolean flag=false;
        if(count > 0){
            flag=true;
            logger.info( "该用户已存在" );
        }else{
            logger.info( "该用户不存在" );
        }
        return flag;
    }

    @Override
    public Map<String, Object> toLogin(String key, String ip) {
        Map<String,Object> map=new HashMap<>(  );
        MDC.put( "Uri", "/toLogin");
        MDC.put( "QueryStr", key+","+ip);
        MDC.put( "VistorIp",ip );
        MDC.put( "Application","eureka-client" );
        try{
            if(key==null){
                map.put( "msg","传值失败" );
                logger.info( "传值失败" );
                return map;
            }
            //密码默认为123456,因为登录方式为单点登录,平台后台默认登录就行,统一密码为默认密码
            String password="123456";
            UsernamePasswordToken token;
            token = new UsernamePasswordToken(
                    key,
                    password
            );
            Subject subject = SecurityUtils.getSubject();
            //登录方法走realm
            subject.login(token);
            //SYSUser包含了roleList,但是不包含menuList
            SysUser sysUser=(SysUser) subject.getPrincipal();
            //查询所有权限
            List<SysRole> roleList=sysUser.getRoleList();
            List<SysMenu> menuList=null;
            for (SysRole role : roleList) {
                menuList=role.getMenuList();
            }
            map.put("menuList", menuList);
            map.put("token", subject.getSession().getId());
            map.put("msg", "登录成功");
            map.put("sysUser", sysUser);
            logger.info( "登录成功" );
        }catch (IncorrectCredentialsException e) {
            map.put("msg", "密码错误");
            logger.error( "密码错误" );
        } catch (LockedAccountException e) {
            map.put("msg", "登录失败，该用户已被冻结");
            logger.error( "登录失败，该用户已被冻结" );
        } catch (AuthenticationException e) {
            map.put("msg", "该用户不存在");
            logger.error( "该用户不存在" );
        }catch (Throwable throwable){
            map.put( "msg",throwable );
            logger.error( throwable.toString() );
        }
        return map;
    }
    /**
     *
     * 功能描述: 人员录入
     *
     * 业务逻辑:再保存用户的头像照片,头像照片通过ftp输出到图片的文件夹中,保存SYSUser对象,如果保存成功,就保存亲属和履历
     * ,之后给该用户分配角色,返回msg信息
     * 角色:使用人员角色,管理人员角色,超级管理员角色,运维人员角色
     *
     * @param:
     * @return: 
     * @auther: 张立恒
     * @date: 2019/1/17 16:58
     */
    @Override
    public Map<String, Object> inputUser(MuchObj muchObj, String ip) {
        Map<String,Object> map=new HashMap<>(  );
        MDC.put( "Uri", "/sysUser/inputUser");
        MDC.put( "QueryStr", muchObj+","+ip);
        MDC.put( "VistorIp",ip );
        MDC.put( "Application","eureka-client" );
        try{
            InputStream inputStream=Base.base64(muchObj.base64);
            String filename=FtpUtil.ftpUpload( inputStream );
            if(filename != null ){
                muchObj.sysUser.setUserPhoto( filename );
                SysUser sysUser=sysUserRepo.save( muchObj.sysUser );
                if(sysUser != null){
                    List<SysUserResume> sysUserResumeList=sysUserResumeRepo.saveAll( muchObj.sysUserResumeList );
                    if(sysUserResumeList != null){
                        List<SysUserFamily> sysUserFamilyList=sysUserFamilyRepo.saveAll( muchObj.sysUserFamilyList );
                        if(sysUserFamilyList != null){
                            //赋予相对应的角色,根据人员的职位不同角色不同,同时还要赋予审批关联表的角色,让他有审批资格,这一部分细节不清楚,
                            //不知道哪个职位怎么分配,所以暂时不分配角色
                            map.put( "msg","录入成功" );
                            logger.info( "录入成功" );
                        }else{
                            map.put( "msg","录入失败" );
                            logger.error( "录入sysUserFamilyList失败" );
                        }
                    }else{
                        map.put( "msg","录入失败" );
                        logger.error( "录入sysUserResumeList失败" );
                    }
                }else{
                    map.put( "msg","录入失败" );
                    logger.error( "录入sysUser失败" );
                }
            }else{
                map.put( "msg","录入头像失败" );
                logger.error( "录入头像失败" );
            }
        }catch (Throwable t){
            map.put( "msg","程序出错!" );
            logger.error(t.toString());
        }
        return map;
    }
}
