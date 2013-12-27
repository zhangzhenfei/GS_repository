package com.glacier.permissions.web.vo.permissions;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AuthActionView {

    private String action;

    private String actionName;

    private boolean defaultAuth;

    private String authSet;

    private boolean ownAuth;

    private boolean hasAuthSet;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public boolean isDefaultAuth() {
        return defaultAuth;
    }

    public void setDefaultAuth(boolean defaultAuth) {
        this.defaultAuth = defaultAuth;
    }

    public String getAuthSet() {
        return authSet;
    }

    public void setAuthSet(String authSet) {
        this.authSet = authSet;
    }

    public boolean isOwnAuth() {
        return ownAuth;
    }

    public void setOwnAuth(boolean ownAuth) {
        this.ownAuth = ownAuth;
    }

    public boolean isHasAuthSet() {
        return hasAuthSet;
    }

    public void setHasAuthSet(boolean hasAuthSet) {
        this.hasAuthSet = hasAuthSet;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ReflectionToStringBuilder.toString(this);
    }

}
