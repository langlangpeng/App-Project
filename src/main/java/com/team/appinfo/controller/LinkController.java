package com.team.appinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LinkController {
    @RequestMapping("/goLoginPage")
    public String goLoginPage(){
        return "devlogin";
    }

    @RequestMapping("/goSearchPage")
    public String goSearchPage(){
        return "developer/appinfolist";
    }
}
