package com.yue.springboot_init_web.configuraion;

import com.yue.springboot_init_web.bean.Pet;
import com.yue.springboot_init_web.converter.MyConverter;
import com.yue.springboot_init_web.interceptor.LoginInterceptor;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.Servlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yue
 * @description :替换SpringBoot默认的SpringMVC配置
 * 方式一：直接实现WebMvcConfigurer
 * 方式二：将webMvcConfigurer的实现注入容器中
 * @create 2023-02-23 1:09
 */
@ServletComponentScan(basePackages = "com.yue.springboot_init_web")
@Configuration
public class MvcConfiguration /* implements WebMvcConfigurer */ {
    //方式一

    //    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper pathHelper = new UrlPathHelper();
//        pathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(pathHelper);
//    }
    //方式二
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void configurePathMatch(PathMatchConfigurer configurer) {
//                UrlPathHelper pathHelper = new UrlPathHelper();
//                pathHelper.setRemoveSemicolonContent(false);
//                configurer.setUrlPathHelper(pathHelper);
//            }
//        };
//    }
    //添加自定义转换器
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                MyConverter myConverter = new MyConverter();
                converters.add(myConverter);
            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                HashMap<String, MediaType> map = new HashMap<>();
                map.put("yue",MediaType.parseMediaType("application/x-yue"));
                ParameterContentNegotiationStrategy negotiationStrategy = new ParameterContentNegotiationStrategy(map);
                HeaderContentNegotiationStrategy header = new HeaderContentNegotiationStrategy();
                ArrayList<ContentNegotiationStrategy> list = new ArrayList<>();
                list.add(header);
                list.add(negotiationStrategy);
                configurer.strategies(list);
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                MyConverter myConverter = new MyConverter();
                converters.add(myConverter);
            }


            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        //阿猫,3
                        if (!source.isEmpty()) {
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(split[1]);
                            return pet;
                        }
                        System.out.println("pet 为空");
                        return null;
                    }
                });
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
               registry.addInterceptor(new LoginInterceptor())
                       .addPathPatterns("/**")
                       .excludePathPatterns("/","/login");
            }
        };


    }


}
