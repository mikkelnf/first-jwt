package com.enigma.controller.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyHeaderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("my-header");
//        if(token == null){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is null");
//        }
//        if(!token.equals("123")){
//            throw new Un
//        }
//        System.out.println("Pre handle from " + request.getRequestURI());
//        return true;
    }
}
