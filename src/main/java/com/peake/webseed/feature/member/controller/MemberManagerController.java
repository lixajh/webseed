package com.peake.webseed.feature.member.controller;

import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.member.dto.MemberDTO;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.service.MemberService;
import com.peake.webseed.utils.ShiroUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by CodeGenerator on 2018/08/30.
 */
@RestController
@RequestMapping("/manager/member")
public class MemberManagerController extends AbstractController {

    Logger logger = LoggerFactory.getLogger(MemberManagerController.class);

    @Resource
    private MemberService memberService;

    @PostMapping("/update")
    public Result update(Member member) {
        memberService.update(member);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail() {
        Member member = memberService.findById(getMember().getPkId());
        return ResultGenerator.genSuccessResult(member);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Member member) {
        PageInfo pageInfo = memberService.findbyPage(page,size,"username",member);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
