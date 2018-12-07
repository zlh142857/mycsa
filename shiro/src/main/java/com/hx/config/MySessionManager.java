package com.hx.config;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/15 11:41
 *@功能:
 */


import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;


public class MySessionManager extends DefaultWebSessionManager {
    private final String TOKEN = "token";
    /**
     * 目的:为了从每个ajax中获取token,也就是sessionid,代替默认的方法来管理会话,(前后端分离保持当前回话一致,我的理解)
     * 前后端分离将从请求头中获取token
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        // 从请求头中获取token
        String token = WebUtils.toHttp(request).getHeader(TOKEN);
        // 判断是否有值
        if (!StringUtils.isEmpty(token)) {
            // 设置当前session状态
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "token");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return token;
        }
        // 若header获取不到token则尝试从cookie中获取
        return super.getSessionId(request, response);
    }

}
