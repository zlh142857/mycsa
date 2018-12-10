package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 15:37
 *@功能:人员信息库crud
 */

import com.hx.personnel.PersonnelInfo;
import com.hx.service.PersonnelInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personnelInfoController")
public class PersonnelInfoController {
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

    @RequestMapping(value = "/insertPersonnel",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod ="insertPersonnelError")
    @ResponseBody
    public String insertPersonnel(PersonnelInfo personnelInfo){
        String insertMsg=personnelInfoService.insertPersonnel(personnelInfo);
        return insertMsg;
    }
    public String insertPersonnelError(PersonnelInfo personnelInfo) {
        return "服务未响应";
    }


}
