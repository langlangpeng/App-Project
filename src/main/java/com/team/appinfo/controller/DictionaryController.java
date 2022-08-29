package com.team.appinfo.controller;

import com.team.appinfo.constant.SystemConstant;
import com.team.appinfo.entity.DataDictionary;
import com.team.appinfo.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DictionaryController {
    @Autowired(required = false)
    public DictionaryService dictionaryService;

    @RequestMapping("/getAppState")
    @ResponseBody
    public List<DataDictionary> getAppState(){
        return dictionaryService.getDictionary(SystemConstant.APP_STATUS);
    }

    @RequestMapping("/getFlatForm")
    @ResponseBody
    public List<DataDictionary> getFlatFormList(){
        return dictionaryService.getDictionary(SystemConstant.APP_FLATFORM);
    }
}
