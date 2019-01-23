package com.hx.service.impl.dictionary;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/18 14:05
 *@功能:
 */

import com.hx.Object.MuchObj;
import com.hx.dao.DictRepo;
import com.hx.service.DictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictServiceImpl implements DictService {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private DictRepo dictRepo;
    @Override
    public Map<String,Object> delDictById(String id, MuchObj muchObj, String ip) {
        Map<String,Object> map=new HashMap<>(  );
        MDC.put( "Uri", "/dict/delDict");
        MDC.put( "QueryStr", id+","+ip);
        MDC.put( "VistorIp",ip );
        MDC.put( "Application","eureka-client" );
        MDC.put( "UserId",muchObj.UserId );
        MDC.put( "DeptId",muchObj.DeptId );
        MDC.put( "UnitId",muchObj.UnitId );
        MDC.put( "MenuId",muchObj.MenuId );
        try{
            dictRepo.deleteById( id );
            map.put( "msg","删除成功" );
            logger.info( "删除成功" );
        }catch (Throwable t){
            map.put( "msg","删除成功" );
            logger.error( t.toString() );
        }
        return map;
    }
}
