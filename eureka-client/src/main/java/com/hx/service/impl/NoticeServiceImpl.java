package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/7 14:02
 *@功能:
 */

import com.hx.Notice;
import com.hx.config.utils.DictCode;
import com.hx.dao.NoticeRepository;
import com.hx.dao.PersonnelInfoRepository;
import com.hx.personnel.PersonnelInfo;
import com.hx.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "noticeService")
public class NoticeServiceImpl implements NoticeService {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public Map<String, Object> queryNoticeList() {
        try{
            Map<String,Object> map=new HashMap<>(  );
            List<Notice> list= noticeRepository.find();
            map.put( "list",list );
            map.put( "msg","查询成功");
            logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+"报错行号:"+Thread.currentThread().getStackTrace()[1].getLineNumber()+";异常"+throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public String insertNotice(Notice notice) {
        try{
            Notice notice1= noticeRepository.save(notice);
            String insertMsg="";
            if(notice != null){
                insertMsg="发布成功";
                logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:发布成功");
            }else{
                insertMsg="未能成功发布";
                logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:保存notice==null");
            }
            return insertMsg;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+"报错行号:"+Thread.currentThread().getStackTrace()[1].getLineNumber()+";异常"+throwable.toString() );

            String insertMsg="未能成功发布";
            return insertMsg;
        }
    }

    @Override
    public String delNotice(Integer noticeId) {
        try{
            Integer count =noticeRepository.deleteNoticeById(noticeId);
            String delMsg="";
            if(count != 0){
                delMsg="删除成功";
                logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:删除成功");
            }else{
                delMsg="未能成功删除";
                logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:删除count==0");
            }
            return delMsg;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+"报错行号:"+Thread.currentThread().getStackTrace()[1].getLineNumber()+";异常"+throwable.toString() );
            String delMsg="未能成功删除";
            return delMsg;
        }
    }
}
