package com.peake.webseed.feature.wechatmp.controller;

import com.peake.webseed.core.AbstractController;
import com.peake.webseed.utils.WechatUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by CodeGenerator on 2018/08/29.
 */


@Controller
@RequestMapping("/mobile/wechat")
public class WechatController extends AbstractController {

    @GetMapping("/auth")
    public String login(HttpServletResponse response) throws IOException {
        WxMpService wxService = WechatUtils.getInstance().getWxService();
        String url = "http://peake.mynatapp.cc/server/mobile/wechat/authed";
        String s = wxService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        response.sendRedirect(s);
        return null;
    }

    @GetMapping("/authed")
    @ResponseBody
    public String aa(String code) throws WxErrorException {
        WxMpService wxMpService = WechatUtils.getInstance().getWxService();
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        WxMpUser user = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        return user.getCity() + user.getNickname();
    }
}
