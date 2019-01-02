package com.hx.Object;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/28 10:26
 *@功能:
 */

import com.hx.Activiti.ActMsgPersonnel;
import com.hx.personnel.ClanInfo;
import com.hx.personnel.PersonnelInfo;
import com.hx.personnel.PersonnelRecord;
import com.hx.shiro.UserInfo;

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
    public UserInfo userInfo;
    public ActMsgPersonnel actMsgPersonnel;
    public PersonnelInfo personnelInfo;
    public List<PersonnelRecord> personnelRecords;
    public List<ClanInfo> clanInfos;
    public String base64;
}
