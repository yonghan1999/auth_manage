package com.han.auth.mapper;

import com.han.auth.entity.AppRoleKey;
import com.han.auth.entity.Role;
import com.han.auth.entity.UserRoleKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAll();

    List<Role> getByAppId(Integer id);

    List<Role> getUserRolesByUid(Integer id);
}