package com.utils;

import cn.dev33.satoken.secure.SaSecureUtil;

public class Encryption {
    private Encryption() {
    }

    public static String encryption(String text) {
        return SaSecureUtil.md5BySalt(text, "XU");
    }

    public static void main(String[] args) {
        System.out.println(encryption("test1"));
    }
}
