package com.peake.webseed.feature.wechatmp.controller;

import com.peake.webseed.core.AbstractController;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
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
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxc4980c9f9cc9b7fe"); // 设置微信公众号的appid
        config.setSecret("8acbd001836c14af2bc75d0d617657c6"); // 设置微信公众号的app corpSecret
//        config.setToken("..."); // 设置微信公众号的token
//        config.setAesKey("..."); // 设置微信公众号的EncodingAESKey

        WxMpService wxService = new WxMpServiceImpl();// 实际项目中请注意要保持单例，不要在每次请求时构造实例，具体可以参考demo项目
        wxService.setWxMpConfigStorage(config);
        String url = "http://peake.mynatapp.cc/server/mobile/wechat/aa";
        String s = wxService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        response.sendRedirect(s);
        return null;
    }

    @GetMapping("/aa")
    @ResponseBody
    public String aa(String username, String password) {

        return "sssssss";
    }
}
