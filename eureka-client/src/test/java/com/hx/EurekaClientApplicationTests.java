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
import java.util.concurrent.*;


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
    /*创建一个固定线程池,线程池内三个线程同时执行了run()方法
    目前能看出线程池内多个线程同时执行一个方法
    更改之后,可以三个线程同时分别执行不同的一个任务,第四个任务要等待有空闲线程之后才能执行
    但是execute(new runnable)没有返回值,可以使用callable,经过测试没问题
    * */
    @Test
    public void fixedThreadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        Future<String> future = fixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println( "当前线程" + Thread.currentThread().getName() + "当前时间:" + System.currentTimeMillis() );
                Thread.sleep(2000);
                return "call方法返回值";
            }
        });
        Future<String> future2 = fixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println( "当前线程" + Thread.currentThread().getName() + "当前时间:" + System.currentTimeMillis() );
                Thread.sleep(2000);
                return "call2方法返回值";
            }
        });
        Future<String> future3 = fixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println( "当前线程" + Thread.currentThread().getName() + "当前时间:" + System.currentTimeMillis() );
                Thread.sleep(2000);
                return "call3方法返回值";
            }
        });
        Future<String> future4 = fixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println( "当前线程" + Thread.currentThread().getName() + "当前时间:" + System.currentTimeMillis() );
                return "call4方法返回值";
            }
        });
        try {
            System.out.println("获取返回值: "+future.get());
            System.out.println("获取返回值2: "+future2.get());
            System.out.println("获取返回值3: "+future3.get());
            System.out.println("获取返回值4: "+future4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        fixedThreadPool.shutdown();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            System.out.println(e+"异常了");
        }
        System.out.println("当前线程名称:"+Thread.currentThread().getName()+"当前时间:"+ System.currentTimeMillis());
    }

    @Test
    public void fixedThreadPoolTest2() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("当前线程"+Thread.currentThread().getName()+"当前时间:"+ System.currentTimeMillis());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("当前第二个线程"+Thread.currentThread().getName()+"当前时间:"+ System.currentTimeMillis());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("当前第三个线程"+Thread.currentThread().getName()+"当前时间:"+ System.currentTimeMillis());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("当前第四个线程"+Thread.currentThread().getName()+"当前时间:"+ System.currentTimeMillis());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        fixedThreadPool.shutdown();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            System.out.println(e+"异常了");
        }
        System.out.println("当前线程名称:"+Thread.currentThread().getName()+"当前时间:"+ System.currentTimeMillis());
    }
}
