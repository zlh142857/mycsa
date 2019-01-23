package com.hx.Object;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/28 10:26
 *@功能:
 */

import com.hx.Activiti.ActMsgPersonnel;
import com.hx.pwcontrol.system.SysUser;
import com.hx.pwcontrol.system.SysUserFamily;
import com.hx.pwcontrol.system.SysUserResume;

import java.util.List;
/**
 *
 * 功能描述: 复杂参数传参,包含对象,list集合,传参时使用@requestbody+该类,之后获取参数名即可     当接口需要接收多个对象时,使用
 *
 * @param: 
 * @return: 
 * @auther: 张立恒
 * @date: 2018/12/29 9:11
 */
public class MuchObj{
    public SysUser sysUser;
    public ActMsgPersonnel actMsgPersonnel;
    public List<SysUserResume> sysUserResumeList;
    public List<SysUserFamily> sysUserFamilyList;
    public String base64;
    //日志需要的参数,从前端cookie中获取,然后放到muchObj对象中传到后台
    public String UserId;
    public String UnitId;
    public String DeptId;
    public String MenuId;
}
