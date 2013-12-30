/*
 * @(#)UserMybatisDaoTest.java
 * @author zhenfei.zhang 
 * Copyright (c) 2012 Glacier SoftWare Company Limited. All Rights Reserved.
 */
package com.glacier.permissions.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.glacier.basic.test.SpringTransactionalTestCase;
import com.glacier.permission.dao.MenuMapper;

/**
 * @ClassName: UserMybatisDaoTest
 * @Description: TODO(基于Mybatis的Dao测试)
 * @author zhenfei.zhang
 * @email zhangzhenfei_email@163.com
 * @date 2012-12-28 上午11:19:50
 */
@DirtiesContext
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-common.xml" })
public class MenuMybatisDaoTest extends SpringTransactionalTestCase {
    
    @Autowired
    private MenuMapper menuMapper;
    
    @Before
    public void before() {
        timeStamp = System.currentTimeMillis();
    }

    @After
    public void after() {
        System.out.println("\r\r执行耗时 : " + (System.currentTimeMillis() - timeStamp) / 1000f + " 秒 ");
    }

    @Test
    public void selectByUserId() {
        menuMapper.selectByUserId("07f211657c8c6b31ee4360c88917e5d2");
    }
    
}
