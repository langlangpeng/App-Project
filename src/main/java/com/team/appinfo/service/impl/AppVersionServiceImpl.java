package com.team.appinfo.service.impl;

import com.team.appinfo.entity.AppVersion;
import com.team.appinfo.mapper.AppVersionMapper;
import com.team.appinfo.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;
    @Override
    public List<AppVersion> getAppVersionByAppId(Long id) {
        return appVersionMapper.getVersionInfoByAppId(id);
    }

    @Override
    public int addAppVersion(AppVersion appVersion) {
        return appVersionMapper.insertSelective(appVersion);
    }

    @Override
    public AppVersion getLastVersionByAppId(Long id) {
        return appVersionMapper.getLastVersionInfo(id);
    }
}
