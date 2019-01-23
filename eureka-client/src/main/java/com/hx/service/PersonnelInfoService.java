package com.hx.service;/*
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface PersonnelInfoService {
   /* Map<String, Object> queryPersonnelList(Integer page,Integer size,String ip,String username); //查询人员信息库中所有的人员信息

    *//*String insertPersonnel(PersonnelInfo personnelInfo,List<PersonnelRecord> personnelRecords,
                           List<ClanInfo> clanInfos,String base64, String ip); //人员录入信息接口*//*

    void showImage(String photoUrl, HttpServletResponse response, HttpServletRequest request);  //展示人员照片

    Map<String,Object> queryPersonnelDetail(Integer perId,String ip,String username);  //查询人员信息详情*/
}
