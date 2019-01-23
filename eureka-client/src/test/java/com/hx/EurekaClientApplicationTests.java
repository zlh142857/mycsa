package com.hx;
import com.hx.utils.Base;
import com.hx.utils.FtpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaClientApplicationTests {
    private Logger logger=LoggerFactory.getLogger( this.getClass() );
    @Test
    public void contextLoads() {
       /* List<Object []> content = codeRepository.findCodeByDict(DictCode.SEX );
        int size=content.size();
        SysDictData sysDictData=new SysDictData(  );
        List<SysDictData> list=new ArrayList<>(  );
        for(int i=0;i<size;i++){
            sysDictData.setDictLabel( content.get( i )[0].toString() );
            sysDictData.setDictSort( (Integer)content.get( i )[1] );
            list.add( sysDictData );
        }
        System.out.println(JSONObject.toJSONString( list ));
*/
    }


}
