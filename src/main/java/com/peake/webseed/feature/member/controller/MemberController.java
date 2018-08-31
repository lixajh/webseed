package com.peake.webseed.feature.member.controller;

import com.github.pagehelper.PageInfo;
import com.peake.webseed.common.shiro.ThirdPartyLoginToken;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.service.MemberService;
import com.peake.webseed.utils.ShiroUtils;
import com.peake.webseed.utils.WechatUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
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
    public String login(HttpServletResponse response) throws IOException {
        if (ShiroUtils.getSubjct().isAuthenticated()){
//            response.sendRedirect("http://peake.mynatapp.cc/mobilefront/#/index?result=0&isNew=false");
            response.sendRedirect("http://peake.mynatapp.cc/mobilefront/#/index?result=0&isNew=true");//todo for test
        }else{
            WxMpService wxService = WechatUtils.getInstance().getWxService();
            String url = "http://peake.mynatapp.cc/server/mobile/member/wechatLogin";
            String s = wxService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
            response.sendRedirect(s);
        }

        return null;
    }

    @GetMapping("/wechatLogin")
//    @ResponseBody
    //https://www.jianshu.com/p/7882ee243298
    public String wechatLogin(HttpServletResponse response, String code) throws WxErrorException, IOException {
        WxMpService wxMpService = WechatUtils.getInstance().getWxService();
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        WxMpUser user = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        Member member = memberService.findBy("openId", user.getOpenId());
        boolean isNew = false;
        if (member == null){
            member = new Member();
            member.setNickname(user.getNickname());
            member.setOpenId(user.getOpenId());
            memberService.save(member);
            isNew = true;
        }

        String redirectUrl = "http://peake.mynatapp.cc/mobilefront/#/index?result=";
        ThirdPartyLoginToken token = new ThirdPartyLoginToken(member.getOpenId(), 1);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            redirectUrl = redirectUrl + "0";
        } catch (AuthenticationException e) {
            redirectUrl = redirectUrl + "-1";
        } catch (AuthorizationException e) {
            redirectUrl = redirectUrl + "-1";
        }
//        redirectUrl = redirectUrl +"&isNew="+isNew;
        redirectUrl = redirectUrl +"&isNew="+true;//todo for test
        response.sendRedirect(redirectUrl);
        return null;
    }

    @RequestMapping("/logout")
    public Result logout() {
        ShiroUtils.logout();
        return ResultGenerator.genSuccessResult();
    }
}
