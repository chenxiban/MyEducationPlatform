package com.cxb.zbq.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 * 
 * @Description:   feign支持文件上传的配置类
 * @ClassName:     FeignSupportConfig.java 
 * @author         Administrator 
 * @Date           2018年12月8日 上午12:22:24  
 * @Email          1119616605@qq.com
 */
@Configuration  
public class MultipartSupportConfig {  
    @Autowired  
    private ObjectFactory<HttpMessageConverters> messageConverters;  
          
    @Bean  
    public Encoder feignFormEncoder() {  
        return new SpringFormEncoder(new SpringEncoder(messageConverters));  
    }  
 }