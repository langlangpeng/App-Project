package com.team.appinfo.controller;

import com.team.appinfo.entity.DevUser;
import com.team.appinfo.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DevUserController {
    @Autowired
    private DevUserService devUserService;

    @RequestMapping("/login")
    public String login(String inputCode,String devCode, String devPassword, HttpSession session, Model model){
        DevUser devUser = this.devUserService.login(devCode,devPassword);
        String randCode = session.getAttribute("codeValidate").toString();
        if (inputCode.equalsIgnoreCase(randCode)){
            if(devUser!=null){
                session.setAttribute("devUser",devUser);
                session.setMaxInactiveInterval(600);
                return "developer/main";
            }else{
                model.addAttribute("error","密码错误!");
                return "devlogin";
            }
        }else {
            model.addAttribute("error","验证码不正确!");
            return "devlogin";
        }

    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("devUser");
        return "devlogin";
    }
}
