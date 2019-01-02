package com.hx.service.impl.exam;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 11:24
 *@功能:
 */

import com.hx.component.GetIpUtil;
import com.hx.dao.exam.ExamInfoRepository;
import com.hx.dao.exam.ExamRepository;
import com.hx.exam.ExamChoose;
import com.hx.exam.ExamInfo;
import com.hx.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
        Map<String,Object> map=new HashMap<>(  );
        try{
            List<ExamChoose> examChooses= examRepository.findAll();
            map.put( "examChooses",examChooses );
            map.put( "msg","获取考题成功");
            logger.info( "获取考题成功");
            return map;
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            map.put( "msg","获取考题失败");
            return map;
        }
    }

    @Override
    public String insertExamInfo(Integer userId, Integer score,String username,HttpServletRequest request) {
        MDC.put( "username",username );
        MDC.put( "ip",GetIpUtil.getIpAddr( request ) );
        try{
            ExamInfo examInfo=new ExamInfo();
            examInfo.setUserId( userId );
            examInfo.setScore( score );
            ExamInfo exam=examInfoRepository.save(examInfo);
            String insertMsg="";
            if(exam!=null){
                insertMsg="录入成功";
                MDC.put( "username",username );
                MDC.put( "ip",GetIpUtil.getIpAddr( request ) );
                logger.info( "录入成功");
            }else{
                insertMsg="录入失败";
                MDC.put( "username",username );
                MDC.put( "ip",GetIpUtil.getIpAddr( request ) );
                logger.error( "录入失败");
            }
            return insertMsg;
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            String insertMsg="录入失败,请重新保存";
            return insertMsg;
        }
    }

    @Override
    public String insertExamChoose(ExamChoose examChoose,String username,HttpServletRequest request) {
        MDC.put( "username",username );
        MDC.put( "ip",GetIpUtil.getIpAddr( request ) );
        try{
            ExamChoose exam=examRepository.save(examChoose);
            String insertMsg="";
            if(exam!=null){
                insertMsg="录入成功";
                MDC.put( "username",username );
                MDC.put( "ip",GetIpUtil.getIpAddr( request ) );
                logger.info( "录入成功");
            }else{
                insertMsg="录入失败";
                MDC.put( "username",username );
                MDC.put( "ip",GetIpUtil.getIpAddr( request ) );
                logger.error( "保存exam==null");
            }
            return insertMsg;
        }catch (Throwable throwable){
            logger.error(throwable.toString() );
            String insertMsg="录入失败,请重新录入";
            return insertMsg;
        }
    }
}
