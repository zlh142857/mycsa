package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/7 15:03
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.service.DictService;
import com.hx.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "dictController")
public class DictController {
    @Autowired
    private DictService dictService;
    @GetMapping(value = "/querySexNameAndSort")
    @ResponseBody
    public String querySexNameAndSort(){
        Map<String,Object> dictList=dictService.querySexNameAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryMiNameAndSort")
    @ResponseBody
    public String queryMiNameAndSort(){
        Map<String,Object> dictList=dictService.queryMiNameAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryIsMiNameAndSort")
    @ResponseBody
    public String queryIsMiNameAndSort(){
        Map<String,Object> dictList=dictService.queryIsMiNameAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryFileLevelNameAndSort")
    @ResponseBody
    public String queryFileLevelNameAndSort(){
        Map<String,Object> dictList=dictService.queryFileLevelNameAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryIsReadNameAndSort")
    @ResponseBody
    public String queryIsReadNameAndSort(){
        Map<String,Object> dictList=dictService.queryIsReadNameAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryIsJiyaoNameAndSort")
    @ResponseBody
    public String queryIsJiyaoNameAndSort(){
        Map<String,Object> dictList=dictService.queryIsJiyaoNameAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryImportantNameAndSort")
    @ResponseBody
    public String queryImportantNameAndSort(){
        Map<String,Object> dictList=dictService.queryImportantNameAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryCourtTypeNameAndSort")
    @ResponseBody
    public String queryCourtTypeNameAndSort(){
        Map<String,Object> dictList=dictService.queryCourtTypeNameAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryDeptNameAndSort")
    @ResponseBody
    public String queryDeptNameAndSort(){
        Map<String,Object> dictList=dictService.queryDeptNameAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryWorkStatusAndSort")
    @ResponseBody
    public String queryWorkStatusAndSort(){
        Map<String,Object> dictList=dictService.queryWorkStatusAndSort();
        return JSONObject.toJSONString( dictList);
    }
    @GetMapping(value = "/queryFacStatusAndSort")
    @ResponseBody
    public String queryFacStatusAndSort(){
        Map<String,Object> dictList=dictService.queryFacStatusAndSort();
        return JSONObject.toJSONString( dictList);
    }
}
