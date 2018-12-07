package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:45
 *@功能:考试考核
 */

import com.hx.exam.ExamChoose;
import com.hx.service.ExamService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exam")
public class Exam {
    @Autowired
    private ExamService examService;
    @RequestMapping(value = "/examList/{id}",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="examListError")
    public String examList(){
        return examService.examList();
    }
    public String examListError() {
        return "获取考题失败!";
    }


    @RequestMapping(value = "/insertExamInfo/{id}",method = RequestMethod.POST)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="insertExamInfoError")
    public String insertExamInfo(Integer userId,Integer score){
        return examService.insertExamInfo(userId,score);
    }
    public String insertExamInfoError() {
        return "录入考试成绩失败!";
    }


    @RequestMapping(value = "/insertExamChoose/{id}",method = RequestMethod.POST)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="insertExamChooseError")
    public String insertExamChoose(ExamChoose examChoose){
        return examService.insertExamChoose(examChoose);
    }
    public String insertExamChooseError() {
        return "录入考题失败!";
    }
}
