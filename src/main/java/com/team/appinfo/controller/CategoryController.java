package com.team.appinfo.controller;

import com.team.appinfo.entity.AppCategory;
import com.team.appinfo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired(required = false)
    private CategoryService categoryService;

    @RequestMapping("/getCategoryByPid")
    @ResponseBody
    public List<AppCategory> getCategoryByPid(Long id){
        return this.categoryService.getCategoryByParent(id);
    }

}
