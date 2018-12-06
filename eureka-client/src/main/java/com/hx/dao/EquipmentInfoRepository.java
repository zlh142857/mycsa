package com.hx.dao;/*
 */

import com.hx.model.facility.FacilityInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EquipmentInfoRepository extends JpaRepository<FacilityInformation, Integer> {
    @Query(value="SELECT * FROM facility_information ",
            countQuery = "SELECT count(id) FROM facility_information",nativeQuery = true)
    Page<FacilityInformation> findAll(Pageable pageable);
}
