package com.peake.webseed.common.redis;


import com.peake.webseed.feature.admin.model.Admin;

/**
 * Created by Administrator on 2017/3/1 14:57.
 */
public interface CacheService extends  RedisService{

    Admin getAdminInfo();

}
