package com.hx.config.md5;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/8 17:08
 *@功能:
 */

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Md5 {
    public static String getPassword(String username,String password,String salt){
        int hashIterations =2;
        String algorithmName="md5";
        String newPassword = new SimpleHash(
                algorithmName,
                password,
                ByteSource.Util.bytes(username+salt),
                hashIterations
        ).toHex();
        return newPassword;
    }
}
