package com.hx.restController.exam;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:45
 *@功能:考试考核
 */

import com.hx.exam.ExamChoose;
import com.hx.service.exam.ExamService;
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
    @RequestMapping(value = "/examList",method = RequestMethod.GET)
    @ResponseBody
    public String examList(){
        return examService.examList();
    }


    @RequestMapping(value = "/insertExamInfo",method = RequestMethod.POST)
    @ResponseBody
    public String insertExamInfo(Integer userId,Integer score){
        return examService.insertExamInfo(userId,score);
    }


    @RequestMapping(value = "/insertExamChoose",method = RequestMethod.POST)
    @ResponseBody
    public String insertExamChoose(ExamChoose examChoose){
        return examService.insertExamChoose(examChoose);
    }

    //删除增加断路器,提示 服务器繁忙,未响应
}
