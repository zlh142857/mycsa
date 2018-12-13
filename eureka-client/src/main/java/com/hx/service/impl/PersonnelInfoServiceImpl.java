package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 15:43
 *@功能:人员信息库
 */

import com.hx.UserInfo;
import com.hx.config.md5.Md5;
import com.hx.config.md5.Salt;
import com.hx.config.utils.DictCode;
import com.hx.dao.CodeRepository;
import com.hx.dao.PersonnelInfoRepository;
import com.hx.dao.UserInfoRepository;
import com.hx.personnel.PersonnelInfo;
import com.hx.service.PersonnelInfoService;
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

@Service(value = "/personnelInfoService")
public class PersonnelInfoServiceImpl implements PersonnelInfoService {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private PersonnelInfoRepository personnelInfoRepository;
    @Autowired
    private CodeRepository codeRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public Map<String, Object> queryPersonnelList(Integer page,Integer size) {
        try{
            Map<String,Object> map=new HashMap<>(  );
            Pageable pageable = PageRequest.of(page, size,Sort.Direction.DESC,"create_time");
            Page<PersonnelInfo> personnelInfoList=personnelInfoRepository.findAll(pageable);
            List<PersonnelInfo> lsit= personnelInfoList.getContent();
            for (PersonnelInfo personnelInfo : lsit) {
                Integer sexCode=personnelInfo.getSexCode();
                Integer miTypeCode=personnelInfo.getMiTypeCode();
                Integer workStatusCode=personnelInfo.getWorkStatusCode();
                Integer deptCode=personnelInfo.getDeptCode();
                Integer ifJiyaoCode=personnelInfo.getIfJiyaoCode();
                Integer ifMiCode=personnelInfo.getIfMiCode();
                if(sexCode!=null){
                    String sex=codeRepository.findByDictIdAndDictSort(DictCode.SEX,sexCode);
                    personnelInfo.setSex( sex );
                }
                if(miTypeCode!=null){
                    String miType=codeRepository.findByDictIdAndDictSort(DictCode.MI_JI,miTypeCode);
                    personnelInfo.setMiType( miType );
                }
                if(workStatusCode!=null){
                    String workStatus=codeRepository.findByDictIdAndDictSort(DictCode.WORK_STATUS,workStatusCode);
                    personnelInfo.setWorkStatus( workStatus );
                }
                if(deptCode!=null){
                    String dept=codeRepository.findByDictIdAndDictSort(DictCode.DEPT_CODE,deptCode);
                    personnelInfo.setDept( dept );
                }
                if(ifJiyaoCode!=null){
                    String ifJiyao=codeRepository.findByDictIdAndDictSort(DictCode.IS_JI_YAO,ifJiyaoCode);
                    personnelInfo.setIfJiyao( ifJiyao );
                }
                if(ifMiCode!=null){
                    String ifMi=codeRepository.findByDictIdAndDictSort(DictCode.IS_MI,ifMiCode);
                    personnelInfo.setIfMi( ifMi );
                }
            }
            map.put( "personnelInfoList",personnelInfoList );
            map.put( "msg","查询成功");
            return map;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+"报错行号:"+Thread.currentThread().getStackTrace()[1].getLineNumber()+";异常"+throwable.toString() );            Map<String,Object> map=new HashMap<>(  );
            map.put( "msg","查询失败");
            return map;
        }

    }

    @Override
    public String insertPersonnel(PersonnelInfo personnelInfo) {
        try{
            PersonnelInfo personnel=personnelInfoRepository.save(personnelInfo);
            String insertMsg="";
            if(personnel!=null){
                Integer perId=personnel.getPerId();
                Integer deptCode=personnel.getDeptCode();
                String deptLeader=personnel.getDeptLeader();
                String personnelName=personnel.getPerName();
                UserInfo userInfo=new UserInfo();
                userInfo.setPersonnelId( perId );
                userInfo.setDeptCode( deptCode );
                userInfo.setDeptLeader( deptLeader );
                userInfo.setPersonnelName( personnelName );
                userInfo.setPassword( "123456" );
                UserInfo userInfo1=userInfoRepository.save( userInfo );
                if(userInfo1 != null){
                    insertMsg="录入成功";
                    logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:录入成功" );
                }else{
                    insertMsg="录入失败";
                    logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:新增userInfo1==null" );
                }
            }else{
                logger.info( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+";操作:新增personnel==null" );
                insertMsg="录入失败";
            }
            return insertMsg;
        }catch (Throwable throwable){
            logger.error( "类名:"+this.getClass().getName()+";方法名:"+Thread.currentThread().getStackTrace()[1].getMethodName()+"报错行号:"+Thread.currentThread().getStackTrace()[1].getLineNumber()+";异常"+throwable.toString() );            String insertMsg="录入失败,请重新录入";
            return insertMsg;
        }
    }
}
