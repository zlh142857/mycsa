package com.hx;

import com.alibaba.fastjson.JSONObject;
import com.hx.shiro.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceFeignApplicationTests {

    @Test
    public void contextLoads() {
        List<UserInfo> list=new ArrayList<>(  );
        UserInfo userinfo=new UserInfo();
        userinfo.setPassword( "123456" );
        UserInfo userinfo2=new UserInfo();
        userinfo2.setPassword( "123456" );
        list.add( userinfo );
        list.add( userinfo2 );
        System.out.println(list.toString());
    }

}
