package com.team.appinfo.service;

import com.team.appinfo.entity.AppCategory;

import java.util.List;

public interface CategoryService {
    List<AppCategory> getCategoryByParent(Long parentId);
}
