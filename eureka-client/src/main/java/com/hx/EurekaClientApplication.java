package com.hx;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@EnableEurekaClient
@ConditionalOnClass
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAsync  //多线程异步调用
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
   /* @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("1024MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("10240MB");
        return factory.createMultipartConfig();
    }*/
   private CorsConfiguration buildConfig() {
       CorsConfiguration corsConfiguration = new CorsConfiguration();
       corsConfiguration.addAllowedOrigin("*");
       corsConfiguration.addAllowedHeader("*");
       corsConfiguration.addAllowedMethod("*");
       return corsConfiguration;
   }

    /**
     * 跨域过滤器
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }


}
