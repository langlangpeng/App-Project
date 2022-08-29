package com.team.appinfo.service;

import com.team.appinfo.entity.AppVersion;

import java.util.List;

public interface AppVersionService {
    List<AppVersion> getAppVersionByAppId(Long id);
    int addAppVersion(AppVersion appVersion);
    AppVersion getLastVersionByAppId(Long id);
}
