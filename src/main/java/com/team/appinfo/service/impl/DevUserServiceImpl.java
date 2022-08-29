package com.team.appinfo.service.impl;

import com.team.appinfo.entity.DevUser;
import com.team.appinfo.entity.DevUserExample;
import com.team.appinfo.mapper.DevUserMapper;
import com.team.appinfo.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevUserServiceImpl implements DevUserService {
    @Autowired(required = false)
    private DevUserMapper devUserMapper;
    @Override
    public DevUser login(String devname, String devpassword) {
        DevUserExample devUserExample = new DevUserExample();
        DevUserExample.Criteria criteria = devUserExample.createCriteria();

        criteria.andDevcodeEqualTo(devname);
        criteria.andDevpasswordEqualTo(devpassword);
        List<DevUser> list = this.devUserMapper.selectByExample(devUserExample);
        if (list!=null&&list.size()==1){
            return list.get(0);
        }else {
            return null;
        }
    }
}
