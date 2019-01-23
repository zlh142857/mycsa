package com.hx.restController.dictionary;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/18 14:01
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.Object.MuchObj;
import com.hx.component.GetIpUtil;
import com.hx.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/dict")
public class DictController {
    @Autowired
    private DictService dictService;
    @RequestMapping(value = "/delDict")
    @ResponseBody
    public String delDict(@RequestParam("id") String id, @RequestBody MuchObj muchObj,@RequestParam("ip") String ip){
        Map<String,Object> map=dictService.delDictById(id,muchObj,ip);
        return JSONObject.toJSONString( map );
    }
}
