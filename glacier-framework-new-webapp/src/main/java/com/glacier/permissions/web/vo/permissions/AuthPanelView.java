package com.glacier.permissions.web.vo.permissions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AuthPanelView {

    private String panelCnName;

    private String panelEnName;

    private List<AuthActionView> panelAuthData = new ArrayList<AuthActionView>();

    public String getPanelCnName() {
        return panelCnName;
    }

    public void setPanelCnName(String panelCnName) {
        this.panelCnName = panelCnName;
    }

    public String getPanelEnName() {
        return panelEnName;
    }

    public void setPanelEnName(String panelEnName) {
        this.panelEnName = panelEnName;
    }

    public List<AuthActionView> getPanelAuthData() {
        return panelAuthData;
    }

    public void setPanelAuthData(List<AuthActionView> panelAuthData) {
        this.panelAuthData = panelAuthData;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ReflectionToStringBuilder.toString(this);
    }

}
