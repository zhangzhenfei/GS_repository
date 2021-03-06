/*
 * @(#)RoleController.java
 * @author zhenfei.zhang 
 * Copyright (c) 2012 Glacier SoftWare Company Limited. All Rights Reserved.
 */
package com.glacier.permissions.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.glacier.core.controller.AbstractController;
import com.glacier.jqueryui.util.JqPager;
import com.glacier.permission.entity.Authority;
import com.glacier.permission.entity.Role;
import com.glacier.permissions.service.MenuService;
import com.glacier.permissions.service.RoleService;

/**
 * @ClassName: RoleController
 * @Description: TODO(角色Controller)
 * @author zhenfei.zhang
 * @email zhangzhenfei_email@163.com
 * @date 2013-10-2 下午12:15:48
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends AbstractController{

    @Autowired
    private RoleService roleService;// 注入角色业务Bean
    
    @Autowired
    private MenuService menuService;// 注入菜单业务Bean

    // 进入角色列表展示页面
    @RequestMapping(value = "/index.htm")
    private Object intoIndexPage() {
        ModelAndView mav = new ModelAndView("permissions_mgr/role_mgr/role");
        return mav;
    }
    
    // 进入角色Form表单页面
    @RequestMapping(value = "/intoForm.htm")
    private Object intoRoleFormPage(String roleId) {
        ModelAndView mav = new ModelAndView("permissions_mgr/role_mgr/role_form");
        if(StringUtils.isNotBlank(roleId)){
            mav.addObject("roleData", roleService.getRole(roleId));
        }
        return mav;
    }
    
    // 进入角色操作授权展示页面
    @RequestMapping(value = "/actionAuth.htm")
    private Object intoActionAuthPage(String roleId) {
        ModelAndView mav = new ModelAndView("permissions_mgr/role_mgr/roleActionAuth");
        mav.addObject("allMenuTreeNodeData", menuService.getAllTreeMenuNode(false,roleId));
        mav.addObject("roleId", roleId);
        return mav;
    }

    // 获取表格结构的所有菜单数据
    @RequestMapping(value = "/list.json", method = RequestMethod.POST)
    @ResponseBody
    private Object listActionAsGridByMenuId(String menuId, JqPager pager) {
        return roleService.listAsGrid(pager);
    }
    
    // 增加角色
    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    @ResponseBody
    private Object addRole(@Valid Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {// 后台校验的错误信息
            return returnErrorBindingResult(bindingResult);
        }
        return roleService.addRole(role);
    }
    
    // 修改角色
    @RequestMapping(value = "/edit.json", method = RequestMethod.POST)
    @ResponseBody
    private Object editRole(@Valid Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {// 后台校验的错误信息
            return returnErrorBindingResult(bindingResult);
        }
        return roleService.editRole(role);
    }

    //保存角色菜单权限
    @RequestMapping(value = "/saveRoleMenuAuths.json", method = RequestMethod.POST)
    @ResponseBody
    private Object saveRoleMenuAuths(String roleId, @RequestParam List<String> menuIds) {
        return roleService.saveRoleMenuAuths(roleId, menuIds);
    }
    
    //保存角色菜单操作权限
    @RequestMapping(value = "/saveRoleMenuActionAuths.json", method = RequestMethod.POST)
    @ResponseBody
    private Object saveRoleMenuActionAuths(Authority authority) {
        return roleService.saveRoleMenuActionAuths(authority);
    }
}
