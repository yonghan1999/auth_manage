package com.han.auth.mapper;

import com.han.auth.entity.App;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AppMapperTest {

    @Autowired
    AppMapper appMapper;

    @Test
    void listALl() {
        List<App> res = appMapper.listAll();
        assert res != null && res.size() > 0;
    }
}
