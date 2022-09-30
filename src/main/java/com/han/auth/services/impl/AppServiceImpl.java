package com.han.auth.services.impl;

import com.github.pagehelper.PageHelper;
import com.han.auth.entity.App;
import com.han.auth.mapper.AppMapper;
import com.han.auth.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private final AppMapper appMapper;

    @Autowired
    public AppServiceImpl(AppMapper appMapper) {
        this.appMapper = appMapper;
    }

    @Override
    public List<App> getAppList(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        return appMapper.listAll();
    }
}
