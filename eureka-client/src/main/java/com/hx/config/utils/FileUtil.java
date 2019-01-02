package com.hx.config.utils;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/24 11:27
 *@功能:
 */

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class FileUtil {
    private static final String nextLine = "\r\n";
    private static final String twoHyphens = "--";
    //分割线  随便写一个
    private static final String boundary = "wk_file_2519775";
    /**
     *
     * 功能描述: 人员录入上传头像
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/12/24 11:27
     */
    public static String uploadFile(MultipartFile file) throws IOException {
        String floder="C:\\photoPerson";
        File f=new File(floder);
        String uuid=UUID.randomUUID().toString().replaceAll( "-","" );
        byte [] fileByte=file.getBytes();
        String filepath=floder+"\\"+uuid+".png";
        if(f.exists()){
            FileOutputStream out = new FileOutputStream(filepath);
            out.write(fileByte);
            out.flush();
            out.close();
        }else{
            f.mkdir();
            FileOutputStream out = new FileOutputStream(filepath);
            out.write(fileByte);
            out.flush();
            out.close();
        }
        return filepath;
    }

}
