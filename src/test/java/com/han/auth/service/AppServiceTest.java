package com.han.auth.service;

import com.han.auth.entity.App;
import com.han.auth.services.PermissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class AppServiceTest {

    @Autowired
    PermissionService appService;

    @Test
    void addApp() {
        App app = new App();
        app.setName("test");
        app.setCurrentCode("20220101");
        app.setCurrentVersion("1.0");
        app.setSupportCode("20210101");
        app.setSupportVersion("0.9");
        app.setCreateTime(new Date(System.currentTimeMillis()));
        appService.addApp(app);
    }

}
