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
    @Query(value="SELECT * FROM personnel_info ",
            countQuery = "SELECT count(per_id) FROM personnel_info",nativeQuery = true)
    Page<PersonnelInfo> findAll(Pageable pageable);
}
