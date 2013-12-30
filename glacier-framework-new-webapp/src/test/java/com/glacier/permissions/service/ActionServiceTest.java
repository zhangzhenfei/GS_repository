package com.glacier.permissions.service;

/*
 * @(#)ActionServiceTest.java
 * @author zhenfei.zhang 
 * Copyright (c) 2012 Glacier SoftWare Company Limited. All Rights Reserved.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.glacier.basic.test.SpringTransactionalTestCase;
import com.glacier.permission.entity.User;
import com.glacier.test.util.ShiroTestUtils;

/**
 * @ClassName: MenuServiceTest
 * @Description: TODO(菜单管理业务测试类)
 * @author zhenfei.zhang
 * @email zhangzhenfei_email@163.com
 * @date 2012-12-28 下午2:06:15
 */
@DirtiesContext
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-common.xml" })
public class ActionServiceTest extends SpringTransactionalTestCase {

    @Autowired
    private ActionService actionService;// 注入业务Bean

    @Before
    public void setUp() {// 创建通过认证用户(模拟登录)
        ShiroTestUtils.mockSubject(new User("07f211657c8c6b31ee4360c88917e5d2", "admin", "admin"));
    }

    @After
    public void tearDown() {// 注销
        ShiroTestUtils.clearSubject();
    }
    
    @Test
    public void test(){
        actionService.getPAAuthByCondition("sdf", "sdf");
    }

}
