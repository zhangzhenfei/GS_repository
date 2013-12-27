package com.glacier.permissions.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.glacier.permission.entity.User;
import com.glacier.security.util.Digests;
import com.glacier.security.util.Encodes;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UserService {
    
    /**
     * 加密方式
     */
    public static final String HASH_ALGORITHM = "SHA-1";

    /**
     * 计算次数
     */
    public static final int HASH_INTERATIONS = 1024;

    /**
     * 盐值长度
     */
    public static final int SALT_SIZE = 8;
    
    /**
     * 设定盐值和设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));
        byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }
    
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        UserService userService = new UserService();
        userService.entryptPassword(user);
        System.out.println(user);
    }

}
