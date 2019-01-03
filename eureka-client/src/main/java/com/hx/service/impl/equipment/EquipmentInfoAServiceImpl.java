package com.hx.service.impl.equipment;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 11:24
 *@功能:
 */

import com.hx.config.utils.DictCode;
import com.hx.dao.code.CodeRepository;
import com.hx.dao.equipment.EquipmentInfoRepository;
import com.hx.facility.FacilityInformation;
import com.hx.service.EquipmentInfoAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="/equipmentInfoService")
public class EquipmentInfoAServiceImpl implements EquipmentInfoAService {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private EquipmentInfoRepository equipmentInfoRepository;
    @Autowired
    private CodeRepository codeRepository;
    @Override
    public Map<String, Object> queryEquipmentList(Integer page, Integer size,String username,String ip) {
        Map<String,Object> map=new HashMap<>(  );
        try{
            MDC.put( "username",username );
            MDC.put( "ip",ip );
            Pageable pageable = PageRequest.of(page, size,Sort.Direction.ASC,"id");
            Page<FacilityInformation> facilityInformationList=equipmentInfoRepository.findAll(pageable);
            List<FacilityInformation> list= facilityInformationList.getContent();
            for (FacilityInformation facilityInformation : list) {
                Integer facilityStatusCode=facilityInformation.getFacilityStatusCode();
                Integer isMiCode=facilityInformation.getIsMiCode();
                Integer miLevelCode=facilityInformation.getMiLevelCode();
                if(facilityStatusCode!=null){
                    String facilityStatus=codeRepository.findByDictIdAndDictSort(DictCode.Facility_Status_Code,facilityStatusCode);
                    facilityInformation.setFacilityStatus( facilityStatus );
                }
                if(isMiCode!=null){
                    String isMi=codeRepository.findByDictIdAndDictSort(DictCode.IS_MI,isMiCode);
                    facilityInformation.setIsMi( isMi );
                }
                if(miLevelCode!=null){
                    String miLevel=codeRepository.findByDictIdAndDictSort(DictCode.Mi_Ji_Code,miLevelCode);
                    facilityInformation.setMiLevel( miLevel );
                }
            }
            map.put( "facilityInformationList",facilityInformationList );
            map.put( "msg","查询成功");
            logger.info( "查询设备成功");
            return map;
        }catch (Throwable throwable){
            MDC.put( "ip",ip );
            logger.error(throwable.toString() );
            map.put( "msg","查询失败");
            return map;
        }

    }

    @Override
    public String insertEquipment(FacilityInformation facilityInformation,String username,String ip) {
        try{
            MDC.put( "username",username );
            MDC.put( "ip",ip );
            FacilityInformation facility=equipmentInfoRepository.save(facilityInformation);
            String insertMsg="";
            if(facility!=null){
                insertMsg="录入成功";
                logger.info( "录入成功");
            }else{
                insertMsg="录入失败";
                logger.error( "保存facility==null");
            }
            return insertMsg;
        }catch (Throwable throwable){
            MDC.put( "ip",ip );
            logger.error(throwable.toString() );
            String insertMsg="录入失败,请重新录入";
            return insertMsg;
        }
    }
}
