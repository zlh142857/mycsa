package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 11:20
 *@功能:
 */

import com.hx.service.WorkActivitiService;
import org.springframework.stereotype.Service;

@Service("/workActivitiService")
public class WorkActivitiServiceImpl implements WorkActivitiService {
    @Override
    public boolean workExam() {
        return true;
    }
}
