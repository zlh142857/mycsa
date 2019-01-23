package com.hx.utils;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/26 11:03
 *@功能:工作流流程图的文件名,也叫流程定义名,貌似是,我忘了
 * 工作流xml文件需要的常量数据:流程图id,assignee,message
 */

public class ProKey {
    public static final String CommonKey="bad"; //原版流程图id

    public static final String COMMONKEY="commonApprove"; //新版通用流程图id

    public static final String SENDDOCUMENT="sendDocument"; //发文流程图id

    public static final String RECEIVEDOCUMENT="receiveDocument"; //收文流程图id

    public static final String USER="user";  //用户提交申请assignee

    public static final String DEPTLEADER="deptLeader";//部门领导assignee

    public static final String YUANLEADER="yuanLeader";//院领导assignee

    public static final String APPROVE="批准";//message:批准

    public static final String PASS="通过";//message:通过

    public static final String REJECT="驳回";//message:驳回

    public static final String OPERATING="拟办";//message:拟办

    public static final String APPLY="提交申请";//message:提交申请
}
