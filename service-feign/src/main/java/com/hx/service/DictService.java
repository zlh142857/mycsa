package com.hx.service;/*
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-client")
public interface DictService {
    @RequestMapping(value = "/dictController/querySexNameAndSort",method = RequestMethod.GET)
    String querySexNameAndSort(); //查询性别的子字典名称和排序值
    @RequestMapping(value = "/dictController/queryMiNameAndSort",method = RequestMethod.GET)
    String queryMiNameAndSort(); //查询密级的
    @RequestMapping(value = "/dictController/queryIsMiNameAndSort",method = RequestMethod.GET)
    String queryIsMiNameAndSort(); //查询是否涉密的
    @RequestMapping(value = "/dictController/queryFileLevelNameAndSort",method = RequestMethod.GET)
    String queryFileLevelNameAndSort(); //查询公文等级的
    @RequestMapping(value = "/dictController/queryIsReadNameAndSort",method = RequestMethod.GET)
    String queryIsReadNameAndSort(); //查询是否已读的
    @RequestMapping(value = "/dictController/queryIsJiyaoNameAndSort",method = RequestMethod.GET)
    String queryIsJiyaoNameAndSort(); //查询是否机要人员
    @RequestMapping(value = "/dictController/queryImportantNameAndSort",method = RequestMethod.GET)
    String queryImportantNameAndSort(); //查询重要程度
    @RequestMapping(value = "/dictController/queryCourtTypeNameAndSort",method = RequestMethod.GET)
    String queryCourtTypeNameAndSort(); //查询法院类型
    @RequestMapping(value = "/dictController/queryDeptNameAndSort",method = RequestMethod.GET)
    String queryDeptNameAndSort(); //查询部门
    @RequestMapping(value = "/dictController/queryWorkStatusAndSort",method = RequestMethod.GET)
    String queryWorkStatusAndSort(); //查询任职状态
    @RequestMapping(value = "/dictController/queryFacStatusAndSort",method = RequestMethod.GET)
    String queryFacStatusAndSort(); //查询设备状态
}
