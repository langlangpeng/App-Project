package com.team.appinfo.controller;

import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.entity.AppVersion;
import com.team.appinfo.service.AppInfoService;
import com.team.appinfo.service.AppVersionService;
import com.team.appinfo.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class VersionController {
    @Autowired(required = false)
    private AppVersionService appVersionService;
    @Autowired(required = false)
    private AppInfoService appInfoService;

    private final static String savePath = "upload/apk";

    @RequestMapping("/goAddVersion")
    public String goAddVersion(Long id, Model model){
        List<AppVersion> list = appVersionService.getAppVersionByAppId(id);
        model.addAttribute("list",list);
        return "developer/appversionadd";
    }

    @RequestMapping("/addAppVersion")
    public String addAppVersion(HttpServletRequest request, AppVersion appVersion, @RequestParam(value = "a_downloadLink") CommonsMultipartFile file){
        String path = request.getSession().getServletContext().getRealPath(savePath);
        String fileName = FileUploadUtil.uploadFile(path, file);
        appVersion.setDownloadlink(savePath+"/"+fileName);
        appVersion.setApkfilename(file.getOriginalFilename());
        Date day = new Date();
        appVersion.setModifydate(day);
        this.appVersionService.addAppVersion(appVersion);
        return "redirect:goAddVersion?id="+appVersion.getAppid();
    }

}
