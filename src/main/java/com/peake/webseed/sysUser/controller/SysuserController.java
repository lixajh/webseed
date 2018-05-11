package com.peake.webseed.sysUser.controller;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.sysUser.model.Sysuser;
import com.peake.webseed.sysUser.service.SysuserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/05/11.
*/
@Api(value="/sysuser", tags="用户模块")
@RestController
@RequestMapping("/sysuser")
public class SysuserController {
    @Resource
    private SysuserService sysuserService;

    @ApiOperation(value="/sysuser", notes="用户模块")
    @ApiImplicitParam(value="sysuser", name="用户模块" ,dataType="Sysuser")
    @PostMapping("/add")
    public Result add(Sysuser sysuser) {
        sysuserService.save(sysuser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        sysuserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Sysuser sysuser) {
        sysuserService.update(sysuser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Sysuser sysuser = sysuserService.findById(id);
        return ResultGenerator.genSuccessResult(sysuser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Sysuser> list = sysuserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
