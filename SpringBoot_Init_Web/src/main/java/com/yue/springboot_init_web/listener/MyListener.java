package com.yue.springboot_init_web.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author yue
 * @description
 * @create 2023-03-06 20:28
 */
@Slf4j
//@WebListener()
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyListener监听到项目初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ServletContextListener.super.contextDestroyed(sce);
    }
}
