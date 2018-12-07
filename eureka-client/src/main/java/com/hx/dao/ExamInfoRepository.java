package com.hx.dao;/*
 */

import com.hx.exam.ExamInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ExamInfoRepository extends JpaRepository<ExamInfo, Integer> {
}
