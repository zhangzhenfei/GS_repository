/*
 * @(#)UserMybatisDaoTest.java
 * @author zhenfei.zhang 
 * Copyright (c) 2012 Glacier SoftWare Company Limited. All Rights Reserved.
 */
package com.glacier.rems.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.glacier.basic.test.SpringTransactionalTestCase;
import com.glacier.basic.util.RandomGUID;
import com.glacier.permission.dao.UserMapper;
import com.glacier.permission.entity.User;
import com.glacier.permission.entity.UserExample;
import com.glacier.permission.entity.util.UserBuiltin;
import com.glacier.permission.entity.util.UserStatus;

/**
 * @ClassName: UserMybatisDaoTest
 * @Description: TODO(基于Mybatis的Dao测试)
 * @author zhenfei.zhang
 * @email zhangzhenfei_email@163.com
 * @date 2012-12-28 上午11:19:50
 */
@DirtiesContext
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-common.xml" })
public class UserMybatisDaoTest extends SpringTransactionalTestCase {
    
    @Before
    public void before() {
        timeStamp = System.currentTimeMillis();
    }

    @After
    public void after() {
        System.out.println("\r\r执行耗时 : " + (System.currentTimeMillis() - timeStamp) / 1000f + " 秒 ");
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll() {
        userMapper.selectByExample(new UserExample());
    }
    
    @Test
    public void add() {
        User user  = new User();
        user.setUsername("admintest");
        user.setPassword(user.getUsername());
        user.setBuiltin(UserBuiltin.builtin);
        user.setUserId(RandomGUID.getRandomGUID());
        user.setStatus(UserStatus.enable);
        userMapper.insert(user);
    }

}
