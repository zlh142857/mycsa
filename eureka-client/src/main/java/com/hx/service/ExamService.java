package com.hx.service;/*
 */

import com.hx.model.exam.ExamChoose;

import java.util.Map;


public interface ExamService {
    Map<String,Object> examList(); //随机获取100道考题

    String insertExamInfo(Integer userId, Integer score); //录入考试成绩信息

    String insertExamChoose(ExamChoose examChoose); //录入考题
}
