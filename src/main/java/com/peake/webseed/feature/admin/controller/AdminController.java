package com.peake.webseed.feature.admin.controller;

import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.EnumErrorCode;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.admin.model.Admin;
import com.peake.webseed.feature.admin.service.AdminService;
import com.peake.webseed.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2018/08/29.
 */
@RestController
@RequestMapping("/manager/admin")
public class AdminController extends AbstractController {
    @Resource
    private AdminService adminService;


    @PostMapping("/login")
    public Result login(String username, String password) {
        if (ShiroUtils.getSubjct().isAuthenticated()) {
            return ResultGenerator.genSuccessResult();
        }
        if (StringUtils.isNoneBlank(username, password)) {
            password = password.toLowerCase();
            return adminService.login(username, password);
        } else {
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
    }

    @PostMapping("/add")
    public Result add(Admin admin) {
        if (StringUtils.isNoneBlank(admin.getUsername())) {
            return adminService.add(admin);
        } else {
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
    }

    @PostMapping("/logout")
    public Result logout() {
        ShiroUtils.logout();
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        adminService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Admin admin) {
        adminService.update(admin);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail() {
        Admin admin = adminService.findById(getAdmin().getPkId());
        return ResultGenerator.genSuccessResult(admin);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,Admin admin) {

        PageInfo pageInfo = adminService.findbyPage(page,size,"username",admin);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
