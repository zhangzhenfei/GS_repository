package com.glacier.permissions.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
    
    private static final long serialVersionUID = 15466454134453L;

    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public CaptchaUsernamePasswordToken() {
        super();
    }

    public CaptchaUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha) {
        super(username, password, rememberMe, host);
        System.out.println(username);
        System.out.println(password);
        System.out.println(rememberMe);
        System.out.println(host);
        System.out.println(captcha);
        this.captcha = captcha;
    }
}
