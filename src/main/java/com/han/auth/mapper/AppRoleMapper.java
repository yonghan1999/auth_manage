package com.han.auth.mapper;

import com.han.auth.entity.AppRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppRole record);

    int insertSelective(AppRole record);

    AppRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppRole record);

    int updateByPrimaryKey(AppRole record);

    List<AppRole> getByAppId(Integer id);
}