package com.hx.service;/*
 */


import com.hx.exam.ExamChoose;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public interface ExamService {
    Map<String,Object> examList(); //随机获取100道考题

    String insertExamInfo(Integer userId, Integer score,String username,String ip); //录入考试成绩信息

    String insertExamChoose(ExamChoose examChoose,String username,String ip); //录入考题
}
