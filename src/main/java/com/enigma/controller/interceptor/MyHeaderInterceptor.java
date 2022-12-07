package com.enigma.controller.interceptor;

import com.enigma.controller.UrlMappings;
import com.enigma.exception.UnauthorizedException;
import com.enigma.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyHeaderInterceptor implements HandlerInterceptor {
    @Autowired
    RestTemplate restTemplate;

    @Value("${service.validate-token}")
    String authServiceUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            String tokenHeader = request.getHeader("Authorization");
            String[] tokenBearer = tokenHeader.split(" ");

            restTemplate.getForEntity(authServiceUrl + "?token=" + tokenBearer[1], String.class);
            return true;
        }catch (RestClientException e){
            throw new UnauthorizedException();
        }
    }
}
