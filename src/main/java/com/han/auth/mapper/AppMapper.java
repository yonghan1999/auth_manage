package com.han.auth.mapper;

import com.han.auth.entity.App;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);

    App getByName(String appName);
}