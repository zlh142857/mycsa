package com.hx.restController.dict;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/7 14:47
 *@功能:
 */

import com.hx.service.dict.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "dictController")
public class DictController {
    @Autowired
    private DictService dictService;
    @RequestMapping(value = "/querySexNameAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String querySexNameAndSort(){
        String dictList=dictService.querySexNameAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryMiNameAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryMiNameAndSort(){
        String dictList=dictService.queryMiNameAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryIsMiNameAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryIsMiNameAndSort(){
        String dictList=dictService.queryIsMiNameAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryFileLevelNameAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryFileLevelNameAndSort(){
        String dictList=dictService.queryFileLevelNameAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryIsReadNameAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryIsReadNameAndSort(){
        String dictList=dictService.queryIsReadNameAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryIsJiyaoNameAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryIsJiyaoNameAndSort(){
        String dictList=dictService.queryIsJiyaoNameAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryImportantNameAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryImportantNameAndSort(){
        String dictList=dictService.queryImportantNameAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryCourtTypeNameAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryCourtTypeNameAndSort(){
        String dictList=dictService.queryCourtTypeNameAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryDeptNameAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryDeptNameAndSort(){
        String dictList=dictService.queryDeptNameAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryWorkStatusAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryWorkStatusAndSort(){
        String dictList=dictService.queryWorkStatusAndSort();
        return dictList;
    }

    @RequestMapping(value = "/queryFacStatusAndSort",method = RequestMethod.GET)
    @ResponseBody
    public String queryFacStatusAndSort(){
        String dictList=dictService.queryFacStatusAndSort();
        return dictList;
    }

    //删除字典数据,进行服务降级
}
