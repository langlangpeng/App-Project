package com.team.appinfo.controller;

import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.entity.AppVersion;
import com.team.appinfo.entity.BackendUser;
import com.team.appinfo.entity.DevUser;
import com.team.appinfo.service.AppInfoService;
import com.team.appinfo.service.AppVersionService;
import com.team.appinfo.util.AppInfoCondition;
import com.team.appinfo.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


@Controller
public class AppInfoController {
    @Autowired(required = false)
    private AppInfoService appInfoService;
    @Autowired(required = false)
    private AppVersionService appVersionService;
    private final static String savePath = "upload/logo";
    private final static String savePath_apk = "upload/apk";

    @RequestMapping("/searchApp")
    public String searchApp(AppInfoCondition appInfoCondition, Model model, HttpSession session){
        DevUser devUser = (DevUser) session.getAttribute("devUser");
        appInfoCondition.setDevid(devUser.getId());
//        appInfoCondition.setDevid(new Long("1"));

        PageInfo<AppInfo> pageInfo = appInfoService.getAppInfoByCondition(appInfoCondition);
        //将信息填充到页面
        //分页信息
        model.addAttribute("pageInfo",pageInfo);
        //查询条件的信息
        model.addAttribute("condition",appInfoCondition);
        //返回视图
        return "developer/appinfolist";

    }
    @RequestMapping("addAppInfo")
    public String addAppInfo(HttpSession session,Model model,AppInfo appInfo,HttpServletRequest request, @RequestParam(value = "a_logoPicPath",required = false) CommonsMultipartFile file){
//    System.out.println("文件名称:"+file.getOriginalFilename());
//    System.out.println("文件大小:"+file.getSize());
//    System.out.println("文件类型:"+file.getContentType());
        try{
            String path = request.getSession().getServletContext().getRealPath(savePath);
            String filename = FileUploadUtil.uploadFile(path,file);
            if (filename==null){
                System.out.println("上传失败");
            }else {
                System.out.println("上传成功："+filename);
                appInfo.setLogopicpath(savePath+"/"+filename);
                appInfo.setLogolocpath(path+"/"+filename);
//                this.appInfoService.addAppInfo(appInfo);
                DevUser devUser=(DevUser)session.getAttribute("devUser");
                appInfo.setDevid(devUser.getId());
                appInfoService.addAppInfo(appInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error","保存失败");
        }
        return "redirect:searchApp";
    }
    @RequestMapping("/getAppInfo")
    public String getAppInfo(Long id,Model model){
        AppInfo appInfo = this.appInfoService.getAppInfo(id);
        model.addAttribute("appInfo",appInfo);
        return "developer/appinfomodify";
    }


    @RequestMapping("/updateAppInfo")
    public String updateAppInfo(HttpSession session,HttpServletRequest request,AppInfo appInfo,String oldPath,@RequestParam(value = "a_logoPicPath",required = false) CommonsMultipartFile file){
        try{
            if (!file.isEmpty()){
                String path = request.getSession().getServletContext().getRealPath(savePath);
                String filename = FileUploadUtil.uploadFile(path,file);
                appInfo.setLogopicpath(savePath+"/"+filename);
                appInfo.setLogolocpath(path+"/"+filename);
                File f = new File(request.getSession().getServletContext().getRealPath(oldPath));
                f.delete();
            }else {
                session.setAttribute("error","上传错误！");
                return "redirect:getAppInfo?id="+appInfo.getId();
            }
            this.appInfoService.updateAppInfo(appInfo);
            return "redirect:searchApp";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:getAppInfo?id="+appInfo.getId();
    }
    @RequestMapping("/deleteAppInfo")
    public String deleteAppInfo(Long appid,String oldPath,HttpServletRequest request,AppInfo appInfo){
        try {
            appInfoService.deleteAppInfo(appid);
            String delPath = request.getSession().getServletContext().getRealPath(oldPath);
            File f = new File(delPath);
            if (f.exists()){
                f.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:searchApp";
    }
    @RequestMapping("/noPassAppInfo")
    public String noPassAppInfo(AppInfoCondition appInfoCondition,Model model,HttpSession session){

//        DevUser devUser = (DevUser) session.getAttribute("devUser");
//        appInfoCondition.setDevid(devUser.getId());

        PageInfo<AppInfo> pageInfo = appInfoService.getAllNoPassAppInfo(appInfoCondition);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("condition",appInfoCondition);
        //返回视图
        return "backend/applist";
    }
    @RequestMapping("/goCheck")
    public String goAppCheck(Long appid,Model model){
        AppInfo appInfo = this.appInfoService.getAppInfoForPass(appid);
        AppVersion appVersion = this.appVersionService.getLastVersionByAppId(appid);
        model.addAttribute("appInfo",appInfo);
        model.addAttribute("appVersion",appVersion);
        return "backend/appcheck";
    }
    @RequestMapping("/checkAppInfo")
    public String checkAppInfo(Long id,Long status){
        int i = this.appInfoService.updateAppInfoState(id,status);
        System.out.println(i);
        if (i>0){
            return "redirect:noPassAppInfo";
        }else {
            return "redirect:goCheck?appid="+id;
        }
    }
    @RequestMapping("/upDownApp")
    @ResponseBody
    public String upDownApp(Long appid,Long status){
        try {
            this.appInfoService.updateAppInfoState(appid,status);
            return "{\"result\":1}";
        }catch (Exception e){
            return "{\"result\":0}";
        }
    }
}
