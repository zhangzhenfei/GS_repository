package com.glacier.permission.entity;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.Length;

public class Menu {
    private String menuId;

    private String pid;

    /**
     * 上级菜单中文名《自定义字段》
     */
    private String parentCnName;

    /**
     * 菜单英文名称，英文字母大小写a-z,1-30个字符限制
     */
    @Pattern(regexp = "^[A-Za-z]{1,30}$", message = "{Menu.menuEnName.illegal}")
    private String menuEnName;

    /**
     * 菜单中文名称，中文字符，4-10个字符限制
     */
    @Pattern(regexp = "^[\u0391-\uFFE5]{4,10}$", message = "{Menu.menuCnName.illegal}")
    private String menuCnName;

    private String iconCls;

    @Pattern(regexp = "^[^\u4e00-\u9fa5]{0,100}$", message = "{Menu.url.illegal}")
    private String url;

    private Integer orderNum;

    @Length(max = 255, message = "{Menu.remark.illegal}")
    private String remark;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getParentCnName() {
        return parentCnName;
    }

    public void setParentCnName(String parentCnName) {
        this.parentCnName = parentCnName;
    }

    public String getMenuEnName() {
        return menuEnName;
    }

    public void setMenuEnName(String menuEnName) {
        this.menuEnName = menuEnName;
    }

    public String getMenuCnName() {
        return menuCnName;
    }

    public void setMenuCnName(String menuCnName) {
        this.menuCnName = menuCnName;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ReflectionToStringBuilder.toString(this);
    }
}