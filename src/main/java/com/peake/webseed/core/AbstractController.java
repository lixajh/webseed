package com.peake.webseed.core;

import com.peake.webseed.common.redis.CacheService;
import com.peake.webseed.feature.admin.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;

public abstract  class AbstractController {
    @Autowired
    CacheService cacheService;

    protected Admin getAdmin(){
        return cacheService.getAdminInfo();
    }
}
