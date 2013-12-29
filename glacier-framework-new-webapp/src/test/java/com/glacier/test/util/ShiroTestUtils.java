/*
 * @(#)ShiroTestUtils.java
 * @author zhenfei.zhang 
 * Copyright (c) 2012 Glacier SoftWare Company Limited. All Rights Reserved.
 */

package com.glacier.test.util;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.SubjectThreadState;
import org.apache.shiro.util.ThreadState;
import org.mockito.Mockito;

/**
 * @ClassName: ShiroTestUtils
 * @Description: TODO(在单元测试中的Shiro工具类)
 * @author zhenfei.zhang
 * @email zhangzhenfei_email@163.com
 * @date 2012-12-28 下午1:58:55
 */
public class ShiroTestUtils {

    private static ThreadState threadState;

    /**
     * 用Mockito快速創建一個已認證的用户.
     */
    public static void mockSubject(Object principal) {
        Subject subject = Mockito.mock(Subject.class);
        Mockito.when(subject.isAuthenticated()).thenReturn(true);
        Mockito.when(subject.getPrincipal()).thenReturn(principal);

        bindSubject(subject);
    }

    /**
     * 綁定Subject到當前線程.
     */
    protected static void bindSubject(Subject subject) {
        clearSubject();
        threadState = new SubjectThreadState(subject);
        threadState.bind();
    }

    /**
     * 清除當前線程中的Subject.
     */
    public static void clearSubject() {
        if (threadState != null) {
            threadState.clear();
            threadState = null;
        }
    }

}
