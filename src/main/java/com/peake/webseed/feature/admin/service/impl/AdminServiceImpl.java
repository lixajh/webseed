package com.peake.webseed.feature.admin.service.impl;

import com.peake.webseed.common.enums.EnumDataStatus;
import com.peake.webseed.core.AbstractService;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.admin.mapper.AdminMapper;
import com.peake.webseed.feature.admin.model.Admin;
import com.peake.webseed.feature.admin.service.AdminService;
import com.peake.webseed.utils.PasswordUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/29.
 */
@Service
@Transactional
public class AdminServiceImpl extends AbstractService<Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Result login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            return ResultGenerator.genFailResult(e.getMessage());
        } catch (AuthorizationException e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genSuccessResult();
    };

    @Override
    public Result add(Admin admin) {

        admin.setSalt(PasswordUtils.getRanSalt());
        admin.setPassword(PasswordUtils.generatePassword(PasswordUtils.DEFAULT_PASSWORD,admin.getSalt()));
        admin.setCreateTime(now());
        admin.setDataStatus(EnumDataStatus.normal.getValue());
        save(admin);
        long id = admin.getPkId();
        System.out.println("___________id:" + id);
        return ResultGenerator.genSuccessResult();
    };
}
