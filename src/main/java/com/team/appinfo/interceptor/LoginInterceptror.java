package com.team.appinfo.interceptor;

import com.team.appinfo.entity.DevUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptror implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("1");
        HttpSession session = httpServletRequest.getSession();
        DevUser devUser = (DevUser) session.getAttribute("devUser");
        if (devUser!=null){
            return true;
        }else {
//            httpServletResponse.sendRedirect("/index");
            httpServletResponse.sendRedirect("goLoginPage");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
