package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/7 15:06
 *@功能:
 */

import com.hx.SysDictData;
import com.hx.config.utils.DictCode;
import com.hx.dao.CodeRepository;
import com.hx.service.DictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DictServiceImpl implements DictService {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private CodeRepository codeRepository;
    @Override
    public Map<String, Object> querySexNameAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.SEX );
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryMiNameAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.MI_JI );
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryIsMiNameAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.IS_MI );
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryFileLevelNameAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.FILE_LEVEL );
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryIsReadNameAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.IS_READ);
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryIsJiyaoNameAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.IS_JI_YAO );
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryImportantNameAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.IMPORTANT);
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryCourtTypeNameAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.COURT_TYPE);
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryDeptNameAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.DEPT_CODE);
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryWorkStatusAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.WORK_STATUS);
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryFacStatusAndSort() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<SysDictData> list= codeRepository.find(DictCode.Facility_Status_Code);
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }
}
