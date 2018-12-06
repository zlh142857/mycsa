package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:47
 *@功能:考试考核
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.model.exam.ExamChoose;
import com.hx.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping(value = "/exam")
public class Exam {
    @Autowired
    private ExamService examService;
    @RequestMapping(value = "/examList",method = RequestMethod.GET)
    @ResponseBody
    public String examList(){
        Map<String,Object> map=examService.examList();
        return JSONObject.toJSONStringWithDateFormat( map,"yyyy-MM-dd HH:mm:ss" );
    }

    @RequestMapping(value = "/insertExamInfo",method = RequestMethod.GET)
    @ResponseBody
    public String insertExamInfo(Integer userId,Integer score){
        String insertMsg=examService.insertExamInfo(userId,score);
        return JSONObject.toJSONString( insertMsg);
    }


    @RequestMapping(value = "/insertExamChoose",method = RequestMethod.GET)
    @ResponseBody
    public String insertExamChoose(ExamChoose examChoose){
        String insertMsg=examService.insertExamChoose(examChoose);
        return JSONObject.toJSONString( insertMsg);
    }

}
