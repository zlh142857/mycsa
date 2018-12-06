package com.hx.service;/*
 */

import com.hx.model.exam.ExamChoose;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface ExamService {
    @RequestMapping(value = "/exam/examList",method = RequestMethod.GET)
    String examList();
    @RequestMapping(value = "/exam/insertExamInfo",method = RequestMethod.POST)
    String insertExamInfo(@RequestParam("userId") Integer userId,@RequestParam("score") Integer score);
    @RequestMapping(value = "/exam/insertExamChoose",method = RequestMethod.POST)
    String insertExamChoose(@RequestParam("examChoose")ExamChoose examChoose);
}
