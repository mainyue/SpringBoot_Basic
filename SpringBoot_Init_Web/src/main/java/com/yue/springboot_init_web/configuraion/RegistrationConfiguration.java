package com.yue.springboot_init_web.configuraion;

import com.yue.springboot_init_web.filter.MyFilter;
import com.yue.springboot_init_web.listener.MyListener;
import com.yue.springboot_init_web.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yue
 * @description
 * @create 2023-03-06 20:35
 */
@Configuration(proxyBeanMethods = true)
public class RegistrationConfiguration {

    @Bean
    public ServletRegistrationBean getServletBean(){
        MyServlet myServlet = new MyServlet();
        return  new ServletRegistrationBean(myServlet,"/my");
    }

    @Bean
    public FilterRegistrationBean getFilterBean(){
        MyFilter myFilter = new MyFilter();
        return new FilterRegistrationBean(myFilter, getServletBean());
    }

    @Bean
    public ServletListenerRegistrationBean getListener(){
        MyListener myListener = new MyListener();
        return new ServletListenerRegistrationBean(myListener);
    }
}
