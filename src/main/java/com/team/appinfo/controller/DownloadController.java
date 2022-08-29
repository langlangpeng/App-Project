package com.team.appinfo.controller;

import com.team.appinfo.service.AppInfoService;
import com.team.appinfo.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class DownloadController {
    @Autowired(required = false)
    private AppInfoService appInfoService;
    @Autowired(required = false)
    private AppVersionService appVersionService;
    @RequestMapping("/download")
    public void download(String path, String fname, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filePath = request.getSession().getServletContext().getRealPath(path);
        FileInputStream fileInputStream = new FileInputStream(filePath);

        byte []bs = new byte[fileInputStream.available()];
        fileInputStream.read(bs);
        fileInputStream.close();

        //1.设置下载的响应头
        response.setHeader("Content-Disposition","attachment;fileName="+fname);
        //2.设置下载的文件类型
//        response.setContentType("application/vnd.android.package-archive");
        response.setContentType("image/jpeg");
        //3.往响应流中出输出数据
        ServletOutputStream sos=response.getOutputStream();
        sos.write(bs); //写响应的数据
        sos.close(); //关闭

    }
}
