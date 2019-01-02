package com.hx.dao.personnel;/*
 */

import com.hx.personnel.ClanInfo;
import com.hx.personnel.PersonnelRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClanInfoRepository extends JpaRepository<ClanInfo, Integer> {
    @Query(value="SELECT * FROM clan_info WHERE per_id=:perId",
            nativeQuery = true)
    ClanInfo findByPerId(@Param( "perId" ) Integer perId);
}
