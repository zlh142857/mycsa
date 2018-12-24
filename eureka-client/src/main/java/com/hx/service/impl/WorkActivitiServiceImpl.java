package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 11:20
 *@功能:
 */

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.hx.service.WorkActivitiService;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Service("/workActivitiService")
public class WorkActivitiServiceImpl implements WorkActivitiService {
    private static RateLimiter rateLimiter = null;
    @Override
    public String workExam(HttpServletRequest request) {

        try{
            //判断能否在1秒内得到令牌，如果不能则立即返回false，不会阻塞程序,降级处理
            if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
                System.out.println("短期无法获取令牌");
                return "短期无法获取令牌";
            }else{
                System.out.println("还有");
                return "OK";
            }
            //限流,对所有ip限流,令牌桶,会阻塞程序
            /*double e=rateLimiter.acquire(1);
            if(e>0.0){
                System.out.println("没有了");
                return "没有了";
            }else{
                System.out.println("还有");
                return "OK";
            }*/
        }catch (Throwable throwable){
            System.out.println(throwable);
            return "fail";
        }
        /*try {
            String ip = this.getIPAddress(request);
            String url = request.getRequestURL().toString();
            String key = "req_limit_".concat(url).concat(ip);
            // 有则返回，没有就添加后获取
            RateLimiter limiter = caches.get(key);
            return limiter.tryAcquire();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }*/


    }
    /**
     *
     * 功能描述: 开始产生令牌
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/19 9:19
     */
    @Override
    public void rateLimiterC() {
        rateLimiter=RateLimiter.create( 2 );
    }
    /**
     *
     * 功能描述: 清空令牌
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/19 9:19
     */
    @Override
    public void rateLimiterD() {
        try{
            //清空令牌,直接清空变量,比较暴力,综合考虑在这里最好选用清空变量
            rateLimiter=null;
            //清空令牌,赋值利率为0,也就是令牌产生量为0每秒
            //rateLimiter.setRate( 0 );
        }catch (Throwable throwable){
            System.out.println(throwable);
        }

    }

    /**
     *
     * 功能描述: 对同一个ip每秒限流两次
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/12/18 17:34
     */
    private static LoadingCache<String, RateLimiter> caches = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .build(new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String key) throws Exception {
                    // 新的IP初始化 (限流每秒两个令牌响应)
                    return RateLimiter.create(2);
                }
            });
    private String getIPAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("x-forwarded-for");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        // 对于通过多个代理的情况，第一个 IP 为客户端真实 IP，多个 IP 按照','分割
        // "***.***.***.***".length() = 15
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
