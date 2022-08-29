package com.team.appinfo.mapper;

import com.team.appinfo.util.AppInfoCondition;
import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.entity.AppInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppInfoMapper {
    int countByExample(AppInfoExample example);

    int deleteByExample(AppInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    List<AppInfo> selectByExample(AppInfoExample example);

    AppInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppInfo record, @Param("example") AppInfoExample example);

    int updateByExample(@Param("record") AppInfo record, @Param("example") AppInfoExample example);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

    List<AppInfo> getAppInfoCondition(AppInfoCondition appInfoCondition);

    AppInfo selectByPrimaryKey2(Long id);

    List<AppInfo> getNoPassAppInfo(AppInfoCondition appInfoCondition);

    AppInfo getAppInfoById2(Long id);
}