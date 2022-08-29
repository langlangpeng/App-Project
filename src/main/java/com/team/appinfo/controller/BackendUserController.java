package com.team.appinfo.controller;

import com.team.appinfo.entity.BackendUser;
import com.team.appinfo.entity.DevUser;
import com.team.appinfo.service.BackendService;
import com.team.appinfo.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BackendUserController {
    @Autowired
    private BackendService backendService;

    @RequestMapping("/admin/")
    public String login(String userCode, String userPassword, HttpSession session, Model model){
        BackendUser backendUser = this.backendService.login(userCode,userPassword);
        if(backendUser!=null){
            session.setAttribute("backendUser",backendUser);
            session.setMaxInactiveInterval(600);
            return "backend/main";
        }else{
            model.addAttribute("error","密码错误!");
            return "backendlogin";
        }
    }@RequestMapping("/logout2")
    public String logout(HttpSession session){
        session.removeAttribute("backendUser");
        return "backendlogin";
    }
}
