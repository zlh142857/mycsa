package com.hx.restController.notice;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/7 9:35
 *@功能:公告管理
 */

import com.hx.config.GetIpUtil;
import com.hx.system.Notice;
import com.hx.service.notice.NoticeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/noticeController")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    /**
     *
     * 功能描述: 查询公告
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2019/1/2 16:05
     */
    @RequestMapping(value = "/queryNoticeList",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="queryNoticeListError")
    @ResponseBody
    public String queryNoticeList(){
        String noticeList=noticeService.queryNoticeList();
        return noticeList;
    }
    public String queryNoticeListError() {
        return "当前系统繁忙,请稍后重试";
    }
    /**
     *
     * 功能描述: 新增公告
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2019/1/2 16:05
     */
    @RequestMapping(value = "/insertNotice",method = RequestMethod.POST)
    @ResponseBody
    public String insertNotice(Notice notice, @RequestParam("username") String username, HttpServletRequest request){
        String ip=GetIpUtil.getIpAddr( request );
        String insertMsg=noticeService.insertNotice(notice,username,ip);
        return insertMsg;
    }
    public String insertNoticeError(Notice notice) {
        return "当前系统繁忙,请稍后重试";
    }

    /**
     *
     * 功能描述: 删除公告
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2019/1/2 16:05
     */
    @RequestMapping(value = "/delNotice",method = RequestMethod.POST)
    @ResponseBody
    public String delNotice(Integer noticeId, @RequestParam("username") String username, HttpServletRequest request){
        String ip=GetIpUtil.getIpAddr( request );
        String delMsg=noticeService.delNotice(noticeId,username,ip);
        return delMsg;
    }

}
