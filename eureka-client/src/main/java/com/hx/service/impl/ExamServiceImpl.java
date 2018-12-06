package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 11:24
 *@功能:
 */

import com.hx.dao.ExamInfoRepository;
import com.hx.dao.ExamRepository;
import com.hx.model.exam.ExamChoose;
import com.hx.model.exam.ExamInfo;
import com.hx.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="/examService")
public class ExamServiceImpl implements ExamService {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ExamInfoRepository examInfoRepository;
    @Override
    public Map<String, Object> examList() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<ExamChoose> examChooses= examRepository.findAll();
            map.put( "examChooses",examChooses );
            map.put( "msg","获取考题成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","获取考题失败");
            return map;
        }
    }

    @Override
    public String insertExamInfo(Integer userId, Integer score) {
        try{
            ExamInfo examInfo=new ExamInfo();
            examInfo.setUserId( userId );
            examInfo.setScore( score );
            ExamInfo exam=examInfoRepository.save(examInfo);
            String insertMsg="";
            if(exam!=null){
                insertMsg="录入成功";
            }
            return insertMsg;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            String insertMsg="录入失败,请重新保存";
            return insertMsg;
        }
    }

    @Override
    public String insertExamChoose(ExamChoose examChoose) {
        try{
            ExamChoose exam=examRepository.save(examChoose);
            String insertMsg="";
            if(exam!=null){
                insertMsg="录入成功";
            }
            return insertMsg;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+throwable.toString() );
            String insertMsg="录入失败,请重新录入";
            return insertMsg;
        }
    }
}
