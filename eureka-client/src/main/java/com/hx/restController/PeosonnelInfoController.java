package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 15:37
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.personnel.PersonnelInfo;
import com.hx.service.PersonnelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/personnelInfoController")
public class PeosonnelInfoController {
    @Autowired
    private PersonnelInfoService personnelInfoService;
    @GetMapping(value = "/personnelList")
    @ResponseBody
    public String queryPersonnelList(Integer page,Integer size){
        Map<String,Object> personnelList=personnelInfoService.queryPersonnelList(page,size);
        return JSONObject.toJSONStringWithDateFormat( personnelList,"yyyy-MM-dd HH:mm:ss" );
    }

    @PostMapping(value = "/insertPer")
    @ResponseBody
    public String insertPersonnel(@RequestBody PersonnelInfo personnelInfo){
        String insertMsg=personnelInfoService.insertPersonnel(personnelInfo);
        return JSONObject.toJSONString( insertMsg );
    }
}
