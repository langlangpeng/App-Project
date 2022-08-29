package com.team.appinfo.service.impl;

import com.team.appinfo.entity.AppCategory;
import com.team.appinfo.entity.AppCategoryExample;
import com.team.appinfo.mapper.AppCategoryMapper;
import com.team.appinfo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private AppCategoryMapper appCategoryMapper;
    @Override
    public List<AppCategory> getCategoryByParent(Long parentId) {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        if (parentId == null)
            criteria.andParentidIsNull();
        else
            criteria.andParentidEqualTo(parentId);
        return appCategoryMapper.selectByExample(appCategoryExample);
    }
}
