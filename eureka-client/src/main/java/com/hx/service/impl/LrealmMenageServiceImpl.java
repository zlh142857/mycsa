package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 11:16
 *@功能:
 */

import com.hx.service.LrealmMenageService;
import org.springframework.stereotype.Service;

@Service("/lrealmMenageService")
public class LrealmMenageServiceImpl implements LrealmMenageService {
    @Override
    public boolean lrealmList() {
        return true;
    }
}
