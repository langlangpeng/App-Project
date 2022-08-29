package com.team.appinfo.mapper;

import com.team.appinfo.entity.AppCategory;
import com.team.appinfo.entity.AppCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppCategoryMapper {
    int countByExample(AppCategoryExample example);

    int deleteByExample(AppCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    List<AppCategory> selectByExample(AppCategoryExample example);

    AppCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppCategory record, @Param("example") AppCategoryExample example);

    int updateByExample(@Param("record") AppCategory record, @Param("example") AppCategoryExample example);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);
}