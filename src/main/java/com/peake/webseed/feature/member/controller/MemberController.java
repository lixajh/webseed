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
@RequestMapping("/mobile/member")
public class MemberController extends AbstractController {

    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Resource
    private MemberService memberService;

    @PostMapping("/add")
    public Result add(Member member) {
        memberService.save(member);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        memberService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

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

    @GetMapping("/toAuth")
    public String toAuth(HttpServletResponse response) throws IOException {
//        if (ShiroUtils.getSubjct().isAuthenticated()){
//            response.sendRedirect("http://peake.mynatapp.cc/mobilefront/#/index?result=0&isNew=false");
//        }else{
//            WxMpService wxService = WechatUtils.getInstance().getWxService();
//            String url = "http://peake.mynatapp.cc/server/mobile/member/wechatLogin";
//            String s = wxService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
//            response.sendRedirect(s);
//        }
        response.sendRedirect("http://peake.mynatapp.cc/mobilefront/#/index?result=0&isNew=1");//todo for test
        return null;
    }

    @GetMapping("/wechatLogin")
//    @ResponseBody
    //https://www.jianshu.com/p/7882ee243298
    public String wechatLogin(HttpServletResponse response, String code) throws WxErrorException, IOException {

        MemberDTO memberDTO = memberService.getMemberByWechatCode(code);
        Member member = memberDTO.getMember();
        boolean isNew = memberDTO.isNew();
        String redirectUrl = "http://peake.mynatapp.cc/mobilefront/#/index?result=";

        try {
            memberService.loginByOpenId(member.getOpenId());
            redirectUrl = redirectUrl + "0";
        } catch (AuthenticationException e) {
            redirectUrl = redirectUrl + "-1";
        } catch (AuthorizationException e) {
            redirectUrl = redirectUrl + "-1";
        }
//        redirectUrl = redirectUrl +"&isNew="+isNew;
        redirectUrl = redirectUrl +"&isNew="+1;//todo for test
        response.sendRedirect(redirectUrl);
        return null;
    }

    @RequestMapping("/logout")
    public Result logout() {
        ShiroUtils.logout();
        return ResultGenerator.genSuccessResult();
    }
}
