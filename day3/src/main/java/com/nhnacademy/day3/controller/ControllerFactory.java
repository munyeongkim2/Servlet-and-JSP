package com.nhnacademy.day3.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
@Slf4j
public class ControllerFactory  {
    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void init(Set<Class<?>> c){
        //todo beanMap에 key = method + servletPath, value = Controller instance
        for (Class<?> cls : c) {
            try {
                Object controllerInstance = cls.getDeclaredConstructor().newInstance();
                String method = cls.getAnnotation(RequestMapping.class).method().name();
                String servletPath = cls.getAnnotation(RequestMapping.class).value();
                String key = method + servletPath;
                beanMap.put(key, controllerInstance);
            } catch(Exception e){
                log.error(e.getMessage());
            }
        }
    }

    public Object getBean(String method, String path){
        //todo beanMap 에서 method+servletPath을 key로 이용하여 Controller instance를 반환합니다.

        return beanMap.get(method+path);
    }
}