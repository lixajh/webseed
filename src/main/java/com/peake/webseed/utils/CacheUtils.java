package com.peake.webseed.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class CacheUtils {

    public static String getUserId() {
        Subject currentUser = SecurityUtils.getSubject();
        if (null == currentUser) {
            return null;
        }
        String id = (String) currentUser.getPrincipal();
        if (StringUtils.isNotBlank(id)) {
            return id;
        }
        return null;
    }
}
