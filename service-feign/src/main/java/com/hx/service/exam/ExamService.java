package com.hx.service.exam;/*
 */

import com.hx.exam.ExamChoose;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "eureka-client")
public interface ExamService {
    @RequestMapping(value = "/exam/examList",method = RequestMethod.GET)
    String examList();
    @RequestMapping(value = "/exam/insertExamInfo",method = RequestMethod.POST)
    String insertExamInfo(@RequestParam("userId") Integer userId,@RequestParam("score") Integer score, @RequestParam(value = "username")String username, @RequestParam(value = "request")HttpServletRequest request);
    @RequestMapping(value = "/exam/insertExamChoose",method = RequestMethod.POST)
    String insertExamChoose(@RequestParam("examChoose")ExamChoose examChoose, @RequestParam(value = "username")String username, @RequestParam(value = "request")HttpServletRequest request);
}
