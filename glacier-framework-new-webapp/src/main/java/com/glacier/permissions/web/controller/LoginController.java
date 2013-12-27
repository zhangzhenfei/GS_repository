/*
 * @(#)LoginController.java
 * @author zhenfei.zhang 
 * Copyright (c) 2012 Glacier SoftWare Company Limited. All Rights Reserved.
 */
package com.glacier.permissions.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: LoginController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhenfei.zhang
 * @email zhangzhenfei_email@163.com
 * @date 2013-8-15 下午4:11:13
 */
@Controller
public class LoginController {
    /**
     * @Title: login
     * @Description: TODO(进入登录页面)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String login() {
        if (null != SecurityUtils.getSubject() && null != SecurityUtils.getSubject().getSession()) {
            SecurityUtils.getSubject().logout();// 进入登录页面，默认把登录用户注销
        }
        return "login";
    }

    /**
     * @Title: index
     * @Description: TODO(登录成功进入首页)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public Object index() {
        return "index";
    }

    /**
     * @Title: fail
     * @Description: TODO(该方法调用前会被Filter拦截，交给shiro验证，如果验证失败会调用该方法)
     * @param @param userName
     * @param @param model
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM)
    String userName, Model model) {
        if (null != SecurityUtils.getSubject() && null != SecurityUtils.getSubject().getSession()) {
            SecurityUtils.getSubject().logout();// 进入登录页面，默认把登录用户注销
        }
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        return "login";
    }
}
