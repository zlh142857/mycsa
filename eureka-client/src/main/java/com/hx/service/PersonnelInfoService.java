package com.hx.service;/*
 */


import com.hx.personnel.ClanInfo;
import com.hx.personnel.PersonnelInfo;
import com.hx.personnel.PersonnelRecord;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface PersonnelInfoService {
    Map<String, Object> queryPersonnelList(Integer page,Integer size); //查询人员信息库中所有的人员信息

    String insertPersonnel(PersonnelInfo personnelInfo,List<PersonnelRecord> personnelRecords,
                           List<ClanInfo> clanInfos,String base64); //人员录入信息接口

    void showImage(String photoUrl, HttpServletResponse response);  //展示人员照片

    Map<String,Object> queryPersonnelDetail(Integer perId);  //查询人员信息详情
}
