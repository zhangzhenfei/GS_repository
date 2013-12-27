/*
 * @(#)MenuController.java
 * @author cong.yan 
 * Copyright (c) 2012 Glacier SoftWare Company Limited. All Rights Reserved.
 */
package com.glacier.permissions.web.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.glacier.permission.entity.Action;
import com.glacier.permission.entity.Menu;
import com.glacier.permission.entity.Panel;
import com.glacier.permissions.service.ActionService;
import com.glacier.permissions.service.MenuService;
import com.glacier.permissions.service.PanelService;

/**
 * @ClassName: MenuController
 * @Description: TODO(菜单Controller)
 * @author cong.yan
 * @email 361277877@qq.com
 * @date 2013-2-27 上午09:24:01
 */
@Controller
@RequestMapping(value = "/res")
public class ResourcesController extends AbstractController {

    @Autowired
    private MenuService menuService;// 注入菜单业务Bean
    
    @Autowired
    private PanelService panelService;// 注入面板业务Bean

    @Autowired
    private ActionService actionService;// 注入操作业务Bean
    
    
    // 进入菜单列表展示页面
    @RequestMapping(value = "/index.htm")
    private Object intoIndexPage(String menuId) {
        ModelAndView mav = new ModelAndView("permissions_mgr/res_mgr/res");
        return mav;
    }

    // 进入菜单Form表单页面
    @RequestMapping(value = "/menu/intoForm.htm")
    private Object intoMenuFormPage() {
        ModelAndView mav = new ModelAndView("permissions_mgr/res_mgr/menu_form");
        mav.addObject("allMenuTreeNodeData", menuService.getAllTreeMenuNode(true,""));
        return mav;
    }
    
    // 进入面板Form表单页面
    @RequestMapping(value = "/panel/intoForm.htm")
    private Object intoPanelFormPage() {
        ModelAndView mav = new ModelAndView("permissions_mgr/res_mgr/panel_form");
        mav.addObject("allMenuTreeNodeData", menuService.getAllTreeMenuNode(false,""));
        return mav;
    }
    
    // 进入操作Form表单页面
    @RequestMapping(value = "/action/intoForm.htm")
    private Object intoActionFormPage() {
        ModelAndView mav = new ModelAndView("permissions_mgr/res_mgr/action_form");
        mav.addObject("allMenuTreeNodeData", menuService.getAllTreeMenuNode(false,""));
        return mav;
    }

    // 查看详细页面
    @RequestMapping(value = "/menu/intoDetails.htm")
    private Object intoDetailsPage() {
        ModelAndView mav = new ModelAndView("permissions_mgr/res_mgr/menu_details");
        return mav;
    }

    // 获取当前用户授权菜单树
    @RequestMapping(value = "/menu/getPrincipalUserMenu.json", method = RequestMethod.POST)
    @ResponseBody
    private Object getPrincipalUserMenu() {
        return menuService.getPrincipalUserMenu();
    }
    
    // 获取菜单下的树结构的所有菜单数据
    @RequestMapping(value = "/menu/list.json", method = RequestMethod.POST)
    @ResponseBody
    private Object listMenuAsTreeByMenuId() {
        return menuService.listAsTree();
    }
    
    // 获取菜单下的表格结构的所有面板数据
    @RequestMapping(value = "/panel/list.json", method = RequestMethod.POST)
    @ResponseBody
    private Object listPanelAsGridByMenuId(String menuId,JqPager pager) {
        return panelService.listAsGrid(menuId,pager);
    }

    // 获取表格结构的所有菜单数据
    @RequestMapping(value = "/action/list.json", method = RequestMethod.POST)
    @ResponseBody
    private Object listActionAsGridByCondition(String menuId,String panelId,JqPager pager) {
        return actionService.listAsGrid(menuId,panelId,pager);
    }

    // 增加菜单
    @RequestMapping(value = "/menu/add.json", method = RequestMethod.POST)
    @ResponseBody
    private Object addMenu(@Valid Menu menu, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {// 后台校验的错误信息
            return returnErrorBindingResult(bindingResult);
        }
        return menuService.addMenu(menu);
    }
    
    // 增加面板
    @RequestMapping(value = "/panel/add.json", method = RequestMethod.POST)
    @ResponseBody
    private Object addPanel(@Valid Panel panel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {// 后台校验的错误信息
            return returnErrorBindingResult(bindingResult);
        }
        return panelService.addPanel(panel);
    }
    
    // 增加操作
    @RequestMapping(value = "/action/add.json", method = RequestMethod.POST)
    @ResponseBody
    private Object addAction(@Valid Action action, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {// 后台校验的错误信息
            return returnErrorBindingResult(bindingResult);
        }
        return actionService.addAction(action);
    }

    // 修改菜单
    @RequestMapping(value = "/menu/edit.json", method = RequestMethod.POST)
    @ResponseBody
    private Object editMenu(@Valid Menu menu, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {// 后台校验的错误信息
            return returnErrorBindingResult(bindingResult);
        }
        return menuService.editMenu(menu);
    }
    
    // 修改面板
    @RequestMapping(value = "/panel/edit.json", method = RequestMethod.POST)
    @ResponseBody
    private Object editPanel(@Valid Panel panel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {// 后台校验的错误信息
            return returnErrorBindingResult(bindingResult);
        }
        return panelService.editPanel(panel);
    }
    
    //修改操作
    @RequestMapping(value = "/action/edit.json", method = RequestMethod.POST)
    @ResponseBody
    private Object editAction(@Valid Action action, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {// 后台校验的错误信息
            return returnErrorBindingResult(bindingResult);
        }
        return actionService.editAction(action);
    }
    
    //删除菜单
    @RequestMapping(value = "/menu/del.json", method = RequestMethod.POST)
    @ResponseBody
    public Object delMenu(Menu menu) {
        return menuService.delMenu(menu);
    }
    
    
    //删除操作
    @RequestMapping(value = "/action/del.json", method = RequestMethod.POST)
    @ResponseBody
    public Object delActions(@RequestParam List<String> actionIds,@RequestParam List<String> actionCnNames) {
        return actionService.delActions(actionIds,actionCnNames);
    }
    
    
    //根据菜单Id和角色Id获取面板操作权限
    @RequestMapping(value = "/action/getPAAuthByCondition.json", method = RequestMethod.POST)
    @ResponseBody
    public Object getPAAuthByCondition(@RequestParam String menuId,@RequestParam String roleId) {
        return actionService.getPAAuthByCondition(menuId, roleId);
    }
    
    @RequestMapping(value = "/panel/getPanelsByMenuId.json", method = RequestMethod.POST)
    @ResponseBody
    public Object getPanelsByMenuId(String menuId) {
        return panelService.getPanelsByMenuId(menuId);
    }
    
}
