package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 15:37
 *@功能:人员信息库crud
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.personnel.PersonnelInfo;
import com.hx.service.PersonnelInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/personnelInfoController")
public class PersonnelInfoController {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private PersonnelInfoService personnelInfoService;
    /**
     *
     * 功能描述: 查询人员信息库所有信息,查询列表和详情页共用一个接口
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/6 13:37
     */
    @RequestMapping(value = "/personnelList",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="queryPersonnelListError")
    @ResponseBody
    public String queryPersonnelList(Integer page,Integer size){
        String personnelList=personnelInfoService.queryPersonnelList(page,size);
        return personnelList;
    }
    public String queryPersonnelListError(Integer page,Integer size) {
        return "服务未响应";
    }

    @PostMapping(value = "/insertPersonnel")
    @HystrixCommand(fallbackMethod ="insertPerError")
    @ResponseBody
    public String insertPer(@RequestBody PersonnelInfo personnelInfo){
        try{
            String insertMsg=personnelInfoService.insertPer(personnelInfo);
            return insertMsg;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            return throwable.toString();
        }

    }
    public String insertPerError(@RequestBody PersonnelInfo personnelInfo) {
        return "服务未响应";
    }


}
