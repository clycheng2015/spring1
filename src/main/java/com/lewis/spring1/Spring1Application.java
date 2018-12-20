package com.lewis.spring1;

import com.lewis.spring1.common.CrosFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
//坑点2，别忘了扫包
@MapperScan(basePackages = {"com.lewis.spring1.bean.mapper","com.lewis.spring1.dao"})
public class Spring1Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Spring1Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {

        return builder.sources(this.getClass());
    }

    /**
     * 解决跨域问题
     * */
    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");//所有请求都经过这个Filter
        bean.setFilter(new CrosFilter());//设置过滤器
        return bean;
    }

    /**
     * 解决LogAspect RequestContextHolder.getRequestAttributes();空指针 问题
     * */
    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }
}


