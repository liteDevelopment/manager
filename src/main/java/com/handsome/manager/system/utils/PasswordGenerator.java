package com.handsome.manager.system.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhanglihui
 * @date 2020-05-03 18:24
 */
public class PasswordGenerator {

    public static void main(String[] args) {
        // $2a$10$PlfalHVD2vSeVTn9ou5QsOKyXGKJJTvNIIwuBuxN6CZKPcwedh5ly     Huawei123
        System.out.println(new BCryptPasswordEncoder().encode("Huawei123"));
    }
}
