package com.hx.restController.exam;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:47
 *@功能:考试考核
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.exam.ExamChoose;
import com.hx.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/insertExamInfo",method = RequestMethod.POST)
    @ResponseBody
    public String insertExamInfo(Integer userId,Integer score,String username,@RequestParam("ip")String ip){
        String insertMsg=examService.insertExamInfo(userId,score,username,ip);
        return JSONObject.toJSONString( insertMsg);
    }


    @RequestMapping(value = "/insertExamChoose",method = RequestMethod.POST)
    @ResponseBody
    public String insertExamChoose(ExamChoose examChoose,String username,@RequestParam("ip")String ip){
        String insertMsg=examService.insertExamChoose(examChoose,username,ip);
        return JSONObject.toJSONString( insertMsg);
    }

}
