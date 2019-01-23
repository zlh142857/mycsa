package com.hx.restController.dictionary;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/18 13:39
 *@功能:字典表增删改查,和字典表的子代码查询
 */

import com.hx.Object.MuchObj;
import com.hx.component.GetIpUtil;
import com.hx.service.DictService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/dict")
public class DictController {
    @Autowired
    private DictService dictService;
    /**
     *
     * 功能描述: 删除字典表某条数据
     *
     * 业务逻辑:根据id删除
     * 
     * @param: id,muchObj日志数据,request
     * @return: 
     * @auther: 张立恒
     * @date: 2019/1/18 13:44
     */
    @RequestMapping(value = "/delDict")
    @ResponseBody
    @HystrixCommand(fallbackMethod ="delDictFallBack")
    public String delDict(@RequestParam("id") String id, @RequestBody MuchObj muchObj, HttpServletRequest request){
        String ip=GetIpUtil.getIpAddr( request );
        return dictService.delDictById(id,muchObj,ip);
    }
    /**
     *
     * 功能描述: 删除字典表的降级服务
     *
     * 业务逻辑:
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2019/1/18 13:57
     */
    public String delDictFallBack(@RequestParam("id") String id, @RequestBody MuchObj muchObj, HttpServletRequest request) {
        return "当前系统繁忙,请稍后再试!";
    }
}
