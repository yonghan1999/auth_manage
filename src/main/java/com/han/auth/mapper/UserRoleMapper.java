package com.han.auth.mapper;

import com.han.auth.entity.UserRoleKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    int deleteByRoleId(int rid);
}