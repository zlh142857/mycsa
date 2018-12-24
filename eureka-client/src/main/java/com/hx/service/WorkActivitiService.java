package com.hx.service;/*
 */

import javax.servlet.http.HttpServletRequest;

public interface WorkActivitiService {
    String workExam(HttpServletRequest request);

    void rateLimiterC();

    void rateLimiterD();
}
