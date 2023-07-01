package com.ccty.service;

import com.ccty.entity.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ITUserServiceTest {
    @Autowired
    private ITUserService itUserService;

    @Test
    public void testUser(){
        TUser tUser = itUserService.getById("1");
        System.out.println(tUser);
    }

}