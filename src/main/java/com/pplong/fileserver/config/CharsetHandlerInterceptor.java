package com.pplong.fileserver.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CharsetHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        System.out.println(URLDecoder.decode(request.getRequestURI(), StandardCharsets.UTF_8));
        for (String headerName : response.getHeaderNames()) {
            System.out.println(headerName + "|  "+response.getHeader(headerName));
        }
        request.setCharacterEncoding("UTF-8");


        response.setContentType("text/html;charset=UTF-8");
        return true;
    }
}
