package com.hx.restController.exam;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:45
 *@功能:考试考核
 */

import com.hx.exam.ExamChoose;
import com.hx.service.exam.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/exam")
public class Exam {
    @Autowired
    private ExamService examService;
    /**
     *
     * 功能描述: 获取考题
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2019/1/2 16:05
     */
    @RequestMapping(value = "/examList",method = RequestMethod.GET)
    @ResponseBody
    public String examList(){
        return examService.examList();
    }

    /**
     *
     * 功能描述: 添加考试成绩
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2019/1/2 16:05
     */
    @RequestMapping(value = "/insertExamInfo",method = RequestMethod.POST)
    @ResponseBody
    public String insertExamInfo(Integer userId, Integer score, @RequestParam("username") String username, HttpServletRequest request){
        return examService.insertExamInfo(userId,score,username,request);
    }

    /**
     *
     * 功能描述: 新增考题
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2019/1/2 16:06
     */
    @RequestMapping(value = "/insertExamChoose",method = RequestMethod.POST)
    @ResponseBody
    public String insertExamChoose(ExamChoose examChoose, @RequestParam("username") String username, HttpServletRequest request){
        return examService.insertExamChoose(examChoose,username,request);
    }

    //删除增加断路器,提示 服务器繁忙,未响应
}
