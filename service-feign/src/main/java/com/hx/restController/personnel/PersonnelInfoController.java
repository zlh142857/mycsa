package com.hx.restController.personnel;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 15:37
 *@功能:人员信息库crud
 */

import com.hx.Object.MuchObj;
import com.hx.service.personnel.PersonnelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
    @ResponseBody
    public String queryPersonnelList(Integer page,Integer size){
        String personnelList=personnelInfoService.queryPersonnelList(page,size);
        return personnelList;
    }
    /**
     *
     * 功能描述: 查询单个人员详情
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/26 13:27
     */
    @GetMapping(value = "/personnelDetail")
    @ResponseBody
    public String personnelDetail(Integer perId){
        String personnel=personnelInfoService.personnelDetail(perId);
        return personnel;
    }

    @PostMapping(value = "/insertPersonnel")
    @ResponseBody
    public String insertPer(@RequestBody MuchObj muchObj){
        String insertMsg=personnelInfoService.insertPer(muchObj);
        return "";
    }

    //删除增加断路器,提示 服务器繁忙,未响应


    @GetMapping(value = "/showImage")
    @ResponseBody
    public void showImage(String photoUrl, HttpServletResponse response){
        personnelInfoService.showImage(photoUrl,response);
    }

}
