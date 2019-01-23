package com.hx.service;/*
 */

import com.hx.Object.MuchObj;

import java.util.Map;

public interface DictService {
    Map<String,Object> delDictById(String id, MuchObj muchObj, String ip);//根据id删除字典表的数据
}
