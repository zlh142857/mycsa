package com.hx.service.impl.notice;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/7 14:02
 *@功能:
 */

import com.hx.system.Notice;
import com.hx.dao.system.NoticeRepository;
import com.hx.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
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
            logger.info( "查询成功");
            return map;
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }
    }

    @Override
    public String insertNotice(Notice notice,String username,String ip) {
        try{
            MDC.put( "username",username );
            MDC.put( "ip",ip );
            Notice notice1= noticeRepository.save(notice);
            String insertMsg="";
            if(notice1 != null){
                insertMsg="发布成功";
                logger.info( "发布成功");
            }else{
                insertMsg="未能成功发布";
                MDC.put( "username",username );
                MDC.put( "ip",ip );
                logger.error( "保存notice==null");
            }
            return insertMsg;
        }catch (Throwable throwable){
            MDC.put( "ip",ip );
            logger.error( throwable.toString() );
            String insertMsg="未能成功发布";
            return insertMsg;
        }
    }

    @Override
    public String delNotice(Integer noticeId,String username,String ip) {
        try{
            MDC.put( "username",username );
            MDC.put( "ip",ip );
            Integer count =noticeRepository.deleteNoticeById(noticeId);
            String delMsg="";
            if(count != 0){
                delMsg="删除成功";
                logger.info( "删除成功");
            }else{
                delMsg="未能成功删除";
                logger.error( "删除count==0");
            }
            return delMsg;
        }catch (Throwable throwable){
            MDC.put( "ip",ip );
            logger.error( throwable.toString() );
            String delMsg="未能成功删除";
            return delMsg;
        }
    }
}
