package com.team.appinfo.service;

import com.team.appinfo.entity.BackendUser;

public interface BackendService {
    public BackendUser login(String username,String password);
}
