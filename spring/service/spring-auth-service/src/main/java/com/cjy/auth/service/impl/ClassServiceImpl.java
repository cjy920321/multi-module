package com.cjy.auth.service.impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClassServiceImpl {

    public static void sendClass() {
        Map<String, String> map = new HashMap<>();
        getClass(Map.class);
    }

    public static void main(String[] args) {
        sendClass();
    }

    public static  <T> void getClass(Class<T> clazz) {
        System.out.println(clazz.getTypeName());
    }
}

