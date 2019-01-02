package com.hx.config.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.util.UUID;

import static org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE;

/**
 *
 * 功能描述:这个ftp工具类用于人员录入头像照片存储,因为每一个工具类用户名密码都不一样也就是说,文件名不一样,这样的话,就不需要另外新建用户名,直接存储文件就可以了
 *
 * @param: 
 * @return: 
 * @auther: 张立恒
 * @date: 2018/12/27 14:21
 */
public class FtpUtil {
    //ftp服务器地址
    public static String hostname = "172.16.107.114";
    //ftp服务器端口号默认为21
    public static Integer port = 21 ;
    //ftp登录账号,在搭建服务器时使用useradd添加新的普通账户
    public static String username = "zlh";
    //ftp登录密码,在搭建服务器时使用passwd添加新的密码
    public static String password = "zlh142857";
    //存放文件夹,普通用户存放路径为/home/用户名文件夹  下,ftp配置文件需要配置chroot_local_user=NO和禁止匿名登录
    //public static String floder = username;

    public static FTPClient ftpClient = null;

    public static String ftpUpload(InputStream inputstream)throws Exception{
        String uuid=UUID.randomUUID().toString().replaceAll( "-","" );
        String filename=uuid+".jpg";
        //String filepath=floder+"\\"+filename;
        //初始化
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        ftpClient.connect(hostname); //连接ftp服务器
        ftpClient.login(username, password);
        ftpClient.enterLocalPassiveMode();
        int replyCode = ftpClient.getReplyCode(); //是否成功登录服务器
        if(!FTPReply.isPositiveCompletion(replyCode)){
            return null;
        }else{
            //直接存放到用户名文件夹下
            ftpClient.setFileType(BINARY_FILE_TYPE);
            ftpClient.storeFile(filename, inputstream);
            //退出登录
            ftpClient.logout();
            return filename;
        }
    }
    public static void ftpDown(String filename,HttpServletResponse response)throws Exception{
        //初始化
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        ftpClient.connect(hostname); //连接ftp服务器
        ftpClient.login(username, password);
        InputStream inputStream = null;
        OutputStream writer = null;
        inputStream = ftpClient.retrieveFileStream(filename);
        writer = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buf)) != -1) {
            writer.write(buf, 0, len); //写
        }
        if(inputStream != null){
            inputStream.close();
        }
        if(writer != null){
            writer.close();
        }
        if (ftpClient!=null&&ftpClient.isConnected()) {
            ftpClient.logout();//退出FTP服务器
            ftpClient.disconnect();//关闭FTP连接
        }
    }
    /**
     * 初始化ftp服务器
     */
    public static void initFtpClient() {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        try {
            System.out.println("connecting...ftp服务器:"+hostname);
            ftpClient.connect(hostname); //连接ftp服务器
            //ftpClient.login(username, password); //登录ftp服务器
            int replyCode = ftpClient.getReplyCode(); //是否成功登录服务器
            if(!FTPReply.isPositiveCompletion(replyCode)){
                System.out.println("connect failed...ftp服务器:"+hostname);
            }
            System.out.println("connect successfu...ftp服务器:"+hostname);
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     * @param pathname ftp服务保存地址
     * @param fileName 上传到ftp的文件名
     *  @param originfilename 待上传文件的名称（绝对地址） *
     * @return
     */
    public static boolean uploadFile( String pathname, String fileName,String originfilename){
        boolean flag = false;
        InputStream inputStream = null;
        try{
            System.out.println("开始上传文件");
            inputStream = new FileInputStream(new File(originfilename));
            initFtpClient();
            ftpClient.setFileType(BINARY_FILE_TYPE);
            //CreateDirecroty(pathname);
            //ftpClient.makeDirectory(pathname);
            //ftpClient.changeWorkingDirectory(pathname);
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
            System.out.println("上传文件成功");
        }catch (Exception e) {
            System.out.println("上传文件失败");
            e.printStackTrace();
        }finally{
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    /**
     * 上传文件
     * @param pathname ftp服务保存地址
     * @param fileName 上传到ftp的文件名
     * @param inputStream 输入文件流
     * @return
     */
    public static boolean uploadFile2( String pathname, String fileName,InputStream inputStream){
        boolean flag = false;
        try{
            System.out.println("开始上传文件");
            initFtpClient();
            ftpClient.setFileType(BINARY_FILE_TYPE);
            //CreateDirecroty(pathname);
            //ftpClient.makeDirectory(pathname);
            //ftpClient.changeWorkingDirectory(pathname);
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
            System.out.println("上传文件成功");
        }catch (Exception e) {
            System.out.println("上传文件失败");
            e.printStackTrace();
        }finally{
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    //改变目录路径
    public static boolean changeWorkingDirectory(String directory) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                System.out.println("进入文件夹" + directory + " 成功！");

            } else {
                System.out.println("进入文件夹" + directory + " 失败！开始创建文件夹");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }

    //创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
    public static boolean CreateDirecroty(String remote) throws IOException {
        boolean success = true;
        String directory = remote + "/";
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + "/" + subDirectory;
                if (!existFile(path)) {
                    if (makeDirectory(subDirectory)) {
                        changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(subDirectory);
                    }
                } else {
                    changeWorkingDirectory(subDirectory);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    //判断ftp服务器文件是否存在
    public static boolean existFile(String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }
    //创建目录
    public static boolean makeDirectory(String dir) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("创建文件夹" + dir + " 成功！");

            } else {
                System.out.println("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /** * 下载文件 *
     * @param pathname FTP服务器文件目录 *
     * @param filename 文件名称 *
     * @param localpath 下载后的文件路径 *
     * @return */
    public static boolean downloadFile(String pathname, String filename, String localpath){
        boolean flag = false;
        OutputStream os=null;
        try {
            System.out.println("开始下载文件");
            initFtpClient();
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for(FTPFile file : ftpFiles){
                if(filename.equalsIgnoreCase(file.getName())){
                    File localFile = new File(localpath + "/" + file.getName());
                    os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(file.getName(), os);
                    os.close();
                }
            }
            ftpClient.logout();
            flag = true;
            System.out.println("下载文件成功");
        } catch (Exception e) {
            System.out.println("下载文件失败");
            e.printStackTrace();
        } finally{
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
    /** * 删除文件 *
     * @param pathname FTP服务器保存目录 *
     * @param filename 要删除的文件名称 *
     * @return */
    public boolean deleteFile(String pathname, String filename){
        boolean flag = false;
        try {
            System.out.println("开始删除文件");
            initFtpClient();
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.dele(filename);
            ftpClient.logout();
            flag = true;
            System.out.println("删除文件成功");
        } catch (Exception e) {
            System.out.println("删除文件失败");
            e.printStackTrace();
        } finally {
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }



}
