package com.hx.dao.personnel;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 15:44
 *@功能:
 */

import com.hx.personnel.PersonnelInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonnelInfoRepository extends JpaRepository<PersonnelInfo, Integer> {
    /*@Query(value="SELECT perId,perName,birTime,sexCode,miTypeCode,miJob,workStatusCode,phone,poliStatus,unempPer," +
            "deptCode,job,location,deptLeader,ifJiyaoCode,ifMiCode,familyName,familyType," +
            "familyPhone,nowLive FROM PersonnelInfo ",
            countQuery = "SELECT count(perId) FROM PersonnelInfo")*/
   /* @Query(value="SELECT per_id,per_name,bir_time,sex_code,mi_type_code,mi_job,work_status_code,phone,poli_status,unemp_per," +
            "dept_code,job,location,dept_leader,if_jiyao_code,if_mi_code,family_name,family_type," +
            "family_phone,now_live FROM Personnel_info ",
            countQuery = "SELECT count(per_id) FROM personnel_info",nativeQuery = true)*/
    @Query(value="SELECT * FROM personnel_info ",
            countQuery = "SELECT count(per_id) FROM personnel_info",nativeQuery = true)
    Page<PersonnelInfo> findAll(Pageable pageable);
}
