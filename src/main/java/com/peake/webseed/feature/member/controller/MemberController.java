package com.peake.webseed.feature.member.controller;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.service.MemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peake.webseed.utils.WechatUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/08/30.
 */
@RestController
@RequestMapping("/mobile/member")
public class MemberController {

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
    public Result detail(@RequestParam Long id) {
        Member member = memberService.findById(id);
        return ResultGenerator.genSuccessResult(member);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Member member) {
        PageInfo pageInfo = memberService.findbyPage(page,size,"username",member);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/toAuth")
    public String login(HttpServletResponse response) throws IOException {
        WxMpService wxService = WechatUtils.getInstance().getWxService();
        String url = "http://peake.mynatapp.cc/server/mobile/member/wechatLogin";
        String s = wxService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        response.sendRedirect(s);
        return null;
    }

    @GetMapping("/wechatLogin")
    @ResponseBody
    public String wechatLogin(String code) throws WxErrorException {
        WxMpService wxMpService = WechatUtils.getInstance().getWxService();
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        WxMpUser user = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        Member member = memberService.findBy("openId", user.getOpenId());
        if (member != null){
            return "sss"+member.getNickname();
        }
        member = new Member();
        member.setNickname(user.getNickname());
        member.setOpenId(user.getOpenId());
        memberService.save(member);
        return user.getCity() + user.getNickname();
    }
}
