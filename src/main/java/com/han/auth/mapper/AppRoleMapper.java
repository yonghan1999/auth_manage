package com.han.auth.mapper;

import com.han.auth.entity.AppRoleKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppRoleMapper {
    int deleteByPrimaryKey(AppRoleKey key);

    int insert(AppRoleKey record);

    int insertSelective(AppRoleKey record);

    List<AppRoleKey> getByAppId(Integer id);
}