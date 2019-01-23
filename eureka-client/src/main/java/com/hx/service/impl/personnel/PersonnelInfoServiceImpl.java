package com.hx.service.impl.personnel;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 15:43
 *@功能:人员信息库
 */
import com.hx.service.PersonnelInfoService;
import com.hx.utils.Base;
import com.hx.utils.DictCode;
import com.hx.utils.FtpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Service(value = "/personnelInfoService")
public class PersonnelInfoServiceImpl implements PersonnelInfoService {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    /*@Autowired
    private PersonnelInfoRepository personnelInfoRepository;
    @Autowired
    private CodeRepository codeRepository;
    @Autowired
    private userinfo userinfo;
    @Autowired
    private PersonnelRecordRepository personnelRecordRepository;
    @Autowired
    private ClanInfoRepository clanInfoRepository;
    @Override
    public Map<String, Object> queryPersonnelList(Integer page,Integer size,String ip,String username) {
        Map<String,Object> map=new HashMap<>(  );
        try{
            MDC.put( "username",username );
            MDC.put( "ip",ip );
            //分页
            Integer pag=page-1;
            Pageable pageable = PageRequest.of(pag, size,Sort.Direction.DESC,"create_time");
            Page<PersonnelInfo> personnelInfoList=personnelInfoRepository.findAll(pageable);
            List<PersonnelInfo> lsit= personnelInfoList.getContent();
            //字典数据查询
            for (PersonnelInfo personnelInfo : lsit) {
                Integer sexCode=personnelInfo.getSexCode();
                Integer miJiCode=personnelInfo.getMiJiCode();
                Integer deptCode=personnelInfo.getDeptCode();
                if(sexCode!=null){
                    String sex=codeRepository.findByDictIdAndDictSort(DictCode.SEX,sexCode);
                    if(sex == null || sex == ""){
                        personnelInfo.setDept( "未知" );
                    }
                    personnelInfo.setSex( sex );
                }
                if(miJiCode!=null){
                    String miji=codeRepository.findByDictIdAndDictSort(DictCode.Mi_Ji_Code,miJiCode);
                    if(miji == null || miji == ""){
                        personnelInfo.setDept( "未知" );
                    }
                    personnelInfo.setMiJi( miji );
                }
                if(deptCode!=null){
                    String dept=codeRepository.findByDictIdAndDictSort(DictCode.DEPT_CODE,deptCode);
                    if(dept == null || dept == ""){
                        personnelInfo.setDept( "未知" );
                    }
                    personnelInfo.setDept( dept );
                }
            }
            map.put( "personnelInfoList",personnelInfoList );
            map.put( "msg","查询成功");
            logger.info("查询成功" );
            return map;
        }catch (Throwable throwable){
            MDC.put( "ip",ip );
            logger.error(throwable.toString() );
            map.put( "msg","查询失败");
            return map;
        }

    }

    @Override
    public String insertPersonnel(PersonnelInfo personnelInfo, List<PersonnelRecord> personnelRecords,
                                  List<ClanInfo> clanInfos, String base64, String ip) {
        MDC.put( "ip",ip );
        try{
            String insertMsg="";
            //保存图片
            InputStream inputStream=Base.base64(base64);
            String filename=FtpUtil.ftpUpload( inputStream );
            if(filename != null){
                personnelInfo.setCreateTime( new Date(  ) );
                personnelInfo.setPhotoUrl( filename );
                PersonnelInfo personnel=personnelInfoRepository.save(personnelInfo);
                //赋值perid关联
                for(PersonnelRecord personnelRecord:personnelRecords){
                    personnelRecord.setPerId( personnel.getPerId() );
                }
                List<PersonnelRecord> recordsL=personnelRecordRepository.saveAll( personnelRecords );
                for(ClanInfo clanInfo:clanInfos){
                    clanInfo.setPerId( personnel.getPerId() );
                }
                List<ClanInfo> clanL=clanInfoRepository.saveAll( clanInfos );
                if(personnel!=null || recordsL != null || clanL != null){
                    Integer perId=personnel.getPerId();
                    Integer deptcode=personnel.getDeptCode();
                    String deptLeader=personnel.getDeptLeader();
                    String personnelName=personnel.getPerName();
                    UserInfo userInfo=new UserInfo();
                    userInfo.setPersonnelId( perId );
                    userInfo.setDeptCode( deptcode );
                    userInfo.setDeptLeader( deptLeader );
                    userInfo.setPersonnelName( personnelName );
                    String salt=Salt.getSalt();
                    userInfo.setSalt( salt );
                    String npassword=Md5.getPassword( personnelInfo.getPerName(),"123456",salt );
                    userInfo.setPassword( npassword );
                    userInfo.setUsername( personnelInfo.getPerName() );
                    UserInfo userInfo1=userinfo.save( userInfo );
                    if(userInfo1 != null){
                        insertMsg="录入成功";
                        logger.info( "录入成功" );
                    }else{
                        insertMsg="录入失败";
                        logger.error( "新增userInfo1==null" );
                    }
                }else{
                    logger.error( "新增personnel==null" );
                    insertMsg="录入失败";
                }
            }else{
                insertMsg="ftp登录失败";
                logger.error( "ftp登录失败" );
            }
            return insertMsg;
        }catch (Throwable throwable){
            logger.error( throwable.toString() );
            String insertMsg="录入失败,请重新录入";
            return insertMsg;
        }
    }

    *//*@Override
    public void showImage(String photoUrl, HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream writer = null;
        try {
            inputStream = new FileInputStream(new File(photoUrl));
            writer = response.getOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                writer.write(buf, 0, len); //写
            }
            inputStream.close();
        } catch (Exception e) {
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+e.toString() );
        } finally{
            try {
                if(inputStream != null){
                    inputStream.close();
                }
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";异常"+e.toString() );
            }
        }
    }*//*
    @Override
    public void showImage(String photoUrl, HttpServletResponse response, HttpServletRequest request){
        try {
            FtpUtil.ftpDown( photoUrl,response );
        } catch (Exception e) {
            logger.error( e.toString() );
        }
    }

    @Override
    public Map<String, Object> queryPersonnelDetail(Integer perId, String ip,String username) {
        Map<String,Object> map=new HashMap<>(  );
        try{
            MDC.put( "username",username );
            MDC.put( "ip",ip );
            Optional optional=personnelInfoRepository.findById(perId);
            List<PersonnelRecord> pRList=personnelRecordRepository.findByPerId( perId );
            List<ClanInfo> cIList=clanInfoRepository.findByPerId(perId);
            if(optional.isPresent()){
                PersonnelInfo personnelInfo=(PersonnelInfo) optional.get();
                Integer sexCode=personnelInfo.getSexCode();
                Integer miJiCode=personnelInfo.getMiJiCode();
                Integer deptCode=personnelInfo.getDeptCode();
                if(sexCode!=null){
                    String sex=codeRepository.findByDictIdAndDictSort(DictCode.SEX,sexCode);
                    if(sex == null || sex == ""){
                        personnelInfo.setDept( "未知" );
                    }
                    personnelInfo.setSex( sex );
                }
                if(miJiCode!=null){
                    String miji=codeRepository.findByDictIdAndDictSort(DictCode.Mi_Ji_Code,miJiCode);
                    if(miji == null || miji == ""){
                        personnelInfo.setDept( "未知" );
                    }
                    personnelInfo.setMiJi( miji );
                }
                if(deptCode!=null){
                    String dept=codeRepository.findByDictIdAndDictSort(DictCode.DEPT_CODE,deptCode);
                    if(dept == null || dept == ""){
                        personnelInfo.setDept( "未知" );
                    }
                    personnelInfo.setDept( dept );
                }
                map.put( "personnelInfo",personnelInfo );
                map.put( "clanInfoList",cIList );
                map.put( "personnelRecordList",pRList );
                map.put( "msg","查询成功");
                logger.info( "查询成功" );
                return map;
            }else{
                map.put( "msg","查询为空");
                logger.error( "查询为空" );
                return map;
            }
        }catch (Throwable throwable){
            MDC.put( "ip",ip );
            logger.error( throwable.toString() );
            map.put( "msg","查询失败");
            return map;
        }
    }*/
}
