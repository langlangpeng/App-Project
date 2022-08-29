package com.team.appinfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.mapper.AppInfoMapper;
import com.team.appinfo.mapper.AppVersionMapper;
import com.team.appinfo.service.AppInfoService;
import com.team.appinfo.util.AppInfoCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired(required = false)
    private AppInfoMapper appInfoMapper;
    @Autowired(required = false)
    private AppVersionMapper appVersionMapper;
    @Override
    public PageInfo<AppInfo> getAppInfoByCondition(AppInfoCondition appInfoCondition) {
        PageHelper.startPage(appInfoCondition.getPage(),appInfoCondition.getPageSize());
        List<AppInfo> list = appInfoMapper.getAppInfoCondition(appInfoCondition);
        return new PageInfo<AppInfo>(list);
    }

    @Override
    public int addAppInfo(AppInfo appInfo) {
        return this.appInfoMapper.insertSelective(appInfo);
    }

    @Override
    public AppInfo getAppInfo(Long id) {
        return this.appInfoMapper.selectByPrimaryKey2(id);
    }

    @Override
    public int updateAppInfo(AppInfo appinfo) {
        return this.appInfoMapper.updateByPrimaryKeySelective(appinfo);
    }

    @Override
    @Transactional
    public void deleteAppInfo(Long id) {
        this.appVersionMapper.deleteByAppId(id);
        this.appInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<AppInfo> getAllNoPassAppInfo(AppInfoCondition appInfoCondition) {
        PageHelper.startPage(appInfoCondition.getPage(),appInfoCondition.getPageSize());

        List<AppInfo> list = appInfoMapper.getNoPassAppInfo(appInfoCondition);
        return new PageInfo<AppInfo>(list);
    }

    @Override
    public AppInfo getAppInfoForPass(Long appid) {
        return this.appInfoMapper.getAppInfoById2(appid);
    }

    @Override
    public int updateAppInfoState(Long appid,Long status) {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(appid);
        appInfo.setStatus(status);
        return this.appInfoMapper.updateByPrimaryKeySelective(appInfo);
    }
}
