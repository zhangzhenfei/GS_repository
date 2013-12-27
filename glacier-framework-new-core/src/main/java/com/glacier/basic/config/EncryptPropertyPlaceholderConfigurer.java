/*
 * @(#)EncryptPropertyPlaceholderConfigurer.java
 * @author zhenfei.zhang 
 * Copyright (c) 2012 Glacier SoftWare Company Limited. All Rights Reserved.
 */
package com.glacier.basic.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.glacier.basic.util.DESUtils;

/**
 * @ClassName: EncryptPropertyPlaceholderConfigurer
 * @Description: TODO(Bean启动读取资源文件解密配置类)
 * @author zhenfei.zhang
 * @email zhangzhenfei_email@163.com
 * @date 2012-12-3 下午3:29:26
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private String[] encryptPropNames = { "connection.username", "connection.password", "mail.password"};// 要进行解密的属性请放在数组里

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            return decryptValue;
        } else {
            return propertyValue;
        }
    }

    /**
     * 判断是否是加密的属性
     * 
     * @param propertyName
     * @return
     */
    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropName : encryptPropNames) {
            if (encryptPropName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}