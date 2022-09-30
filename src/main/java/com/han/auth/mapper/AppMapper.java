package com.han.auth.mapper;

import com.han.auth.entity.App;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);

    App getByName(String appName);

    List<App> listAll();
}