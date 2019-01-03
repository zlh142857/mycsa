package com.hx.restController.personnel;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 15:37
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.Object.MuchObj;
import com.hx.config.utils.Base;
import com.hx.config.utils.FileUtil;
import com.hx.config.utils.FtpUtil;
import com.hx.personnel.ClanInfo;
import com.hx.personnel.PersonnelInfo;
import com.hx.personnel.PersonnelRecord;
import com.hx.service.PersonnelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personnelInfoController")
public class PeosonnelInfoController {
    @Autowired
    private PersonnelInfoService personnelInfoService;
    @GetMapping(value = "/personnelList")
    @ResponseBody
    public String queryPersonnelList(Integer page,Integer size,@RequestParam("ip")String ip,String username){
        Map<String,Object> personnelList=personnelInfoService.queryPersonnelList(page,size,ip,username);
        return JSONObject.toJSONStringWithDateFormat( personnelList,"yyyy-MM-dd HH:mm:ss" );
    }

    @GetMapping(value = "/personnelDetail")
    @ResponseBody
    public String queryPersonnelDetail(Integer perId,@RequestParam("ip")String ip,String username){
        Map<String,Object> personnel=personnelInfoService.queryPersonnelDetail(perId,ip,username);
        return JSONObject.toJSONStringWithDateFormat( personnel,"yyyy-MM-dd HH:mm:ss" );
    }

    @PostMapping(value = "/insertPer")
    @ResponseBody
    @Async
    public String insertPersonnel(@RequestBody MuchObj muchObj,@RequestParam("ip")String ip){
        PersonnelInfo personnelInfo=muchObj.personnelInfo;
        List<PersonnelRecord> personnelRecords=muchObj.personnelRecords;
        List<ClanInfo> clanInfos=muchObj.clanInfos;
        String base64=muchObj.base64;
        base64=base64.replaceFirst("data:image/jpeg;base64,", "");
        base64.replaceAll(" ", "+");
        String insertMsg=personnelInfoService.insertPersonnel(personnelInfo,personnelRecords,clanInfos,base64,ip);
        return JSONObject.toJSONString( insertMsg );
    }
    @GetMapping(value = "/showImage")
    @ResponseBody
    @Async //多线程异步调用
    public void showImage(String photoUrl,HttpServletResponse response, HttpServletRequest request){
        personnelInfoService.showImage(photoUrl,response,request);
    }
    /*@PostMapping(value = "/up")
    @ResponseBody
    public void up()  {
        try {
            String base64="data:image/jpeg;base64,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";
            base64=base64.replaceFirst("data:image/jpeg;base64,", "");
            base64=base64.replaceAll(" ", "+");
            String filename=FtpUtil.ftpUpload( Base.base64( base64 ) );
            if(filename != null){
                System.out.println(filename);
            }else{
                System.out.println("没有连接成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }*/
}
