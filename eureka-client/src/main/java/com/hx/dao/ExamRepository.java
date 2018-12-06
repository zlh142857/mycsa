package com.hx.dao;/*
 */

import com.hx.model.exam.ExamChoose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ExamRepository extends JpaRepository<ExamChoose, Integer> {
    @Query(value = "SELECT * FROM exam_choose order by rand() limit 100",nativeQuery = true)
    List<ExamChoose> findAll();
}
