package com.hx.service;/*
 */

import java.util.Map;

public interface DictService {
    Map<String,Object> querySexNameAndSort();

    Map<String,Object> queryMiNameAndSort();

    Map<String,Object> queryIsMiNameAndSort();

    Map<String,Object> queryFileLevelNameAndSort();

    Map<String,Object> queryIsReadNameAndSort();

    Map<String,Object> queryIsJiyaoNameAndSort();

    Map<String,Object> queryImportantNameAndSort();

    Map<String,Object> queryCourtTypeNameAndSort();

    Map<String,Object> queryDeptNameAndSort();

    Map<String,Object> queryWorkStatusAndSort();

    Map<String,Object> queryFacStatusAndSort();
}
