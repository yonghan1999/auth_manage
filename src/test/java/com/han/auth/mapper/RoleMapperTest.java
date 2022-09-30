package com.han.auth.mapper;

import com.han.auth.entity.App;
import com.han.auth.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    void getUserRolesByUid() {
        List<Role> res = roleMapper.getUserRolesByUid(1);
        assert res != null && res.size() > 0;
    }

    @Test
    void getByAppId() {

    }

    @Test
    void selectAll() {

    }
}
