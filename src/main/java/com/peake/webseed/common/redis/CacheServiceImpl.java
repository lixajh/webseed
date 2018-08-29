package com.peake.webseed.common.redis;

import com.peake.webseed.common.enums.EnumUserType;
import com.peake.webseed.feature.admin.model.Admin;
import com.peake.webseed.feature.admin.service.AdminService;
import com.peake.webseed.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl extends RedisServiceImpl implements CacheService {
    private static final String ADMIN_INFO_KEY = "admin_info_key:";
    private static final long EXPRIE_TIME = 3600;

    @Autowired
    AdminService adminService;

    @Override
    public Admin getAdminInfo() {

        if (ShiroUtils.getUserType() != EnumUserType.manager) {
            return null;
        }

        Long userId = ShiroUtils.getUserId();
        if (userId == null) {
            return null;
        }
        try{
            Object o = get(ADMIN_INFO_KEY + userId);
            if (o != null) {
                Admin admin = (Admin) o;
                return admin;
            } else {
               return adminFromDb(userId);
            }
        }catch (Exception e){
            return adminFromDb(userId);
        }
    }

    private Admin adminFromDb(Long userId){
        Admin admin1 = adminService.findById(userId);
        if (admin1 != null) {
            set(ADMIN_INFO_KEY + userId, admin1, EXPRIE_TIME);
        }
        return admin1;
    }
}
