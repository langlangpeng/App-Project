package com.team.appinfo.service;

import com.team.appinfo.entity.DevUser;
import org.springframework.beans.factory.annotation.Autowired;

public interface DevUserService {
    public DevUser login (String devname,String devpassword);
}
