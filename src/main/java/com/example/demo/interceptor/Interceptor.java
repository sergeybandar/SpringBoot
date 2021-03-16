package com.example.demo.interceptor;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        String key = request.getHeader("Key");
//        if (userService.valid(key)) return true;
//        else {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            return false;
//        }
//
//    }

}
