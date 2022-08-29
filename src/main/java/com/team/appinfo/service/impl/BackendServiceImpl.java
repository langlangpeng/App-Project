package com.team.appinfo.service.impl;

import com.team.appinfo.entity.BackendUser;
import com.team.appinfo.entity.BackendUserExample;
import com.team.appinfo.entity.DevUser;
import com.team.appinfo.entity.DevUserExample;
import com.team.appinfo.mapper.BackendUserMapper;
import com.team.appinfo.mapper.DevUserMapper;
import com.team.appinfo.service.BackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackendServiceImpl implements BackendService {
    @Autowired(required = false)
    private BackendUserMapper backendUserMapper;
    @Override
    public BackendUser login(String username, String password) {
        BackendUserExample backendUserExample = new BackendUserExample();
        BackendUserExample.Criteria criteria = backendUserExample.createCriteria();

       criteria.andUsercodeEqualTo(username);
       criteria.andUserpasswordEqualTo(password);
        List<BackendUser> list = this.backendUserMapper.selectByExample(backendUserExample);
        if (list!=null&&list.size()==1){
            return list.get(0);
        }else {
            return null;
        }
    }
}
