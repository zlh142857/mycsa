package com.hx.dao.personnel;/*
 */

import com.hx.personnel.PersonnelRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonnelRecordRepository extends JpaRepository<PersonnelRecord, Integer> {
    @Query(value="SELECT * FROM personnel_record WHERE per_id=:perId",
    nativeQuery = true)
    PersonnelRecord findByPerId(@Param( "perId" ) Integer perId);
}
