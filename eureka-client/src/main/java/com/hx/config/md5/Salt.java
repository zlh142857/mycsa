package com.hx.config.md5;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/8 17:19
 *@功能:
 */

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

public class Salt {
    public static String getSalt(){
        RandomNumberGenerator randomNumberGenerator =new SecureRandomNumberGenerator();
        return randomNumberGenerator.nextBytes().toHex();
    }
}
