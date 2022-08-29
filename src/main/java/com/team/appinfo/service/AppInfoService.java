package com.team.appinfo.service;

import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.util.AppInfoCondition;

public interface AppInfoService {
    public PageInfo<AppInfo> getAppInfoByCondition(AppInfoCondition appInfoCondition);

    public int addAppInfo(AppInfo appInfo);

    public AppInfo getAppInfo(Long id);

    public int updateAppInfo(AppInfo appinfo);

    public void deleteAppInfo(Long id);

    public PageInfo<AppInfo> getAllNoPassAppInfo(AppInfoCondition appInfoCondition);

    public AppInfo getAppInfoForPass(Long appid);

    public int updateAppInfoState(Long state,Long appid);

}
