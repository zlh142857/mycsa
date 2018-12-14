package com.hx;

import com.alibaba.fastjson.JSONObject;
import com.hx.config.utils.DictCode;
import com.hx.dao.CodeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaClientApplicationTests {
    @Autowired
    private CodeRepository codeRepository;
    @Test
    public void contextLoads() {
        List<Object []> content = codeRepository.findCodeByDict(DictCode.SEX );
        int size=content.size();
        SysDictData sysDictData=new SysDictData(  );
        List<SysDictData> list=new ArrayList<>(  );
        for(int i=0;i<size;i++){
            sysDictData.setDictLabel( content.get( i )[0].toString() );
            sysDictData.setDictSort( (Integer)content.get( i )[1] );
            list.add( sysDictData );
        }
        System.out.println(JSONObject.toJSONString( list ));

    }

}
