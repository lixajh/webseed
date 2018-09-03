package com.peake.webseed.feature.member.service.impl;

import com.peake.webseed.common.shiro.ThirdPartyLoginToken;
import com.peake.webseed.core.AbstractService;
import com.peake.webseed.core.Result;
import com.peake.webseed.feature.member.dto.MemberDTO;
import com.peake.webseed.feature.member.mapper.MemberMapper;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.service.MemberService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
@Service
@Transactional
public class MemberServiceImpl extends AbstractService<Member> implements MemberService {

    Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource
    private MemberMapper MemberMapper;

    @Override
    public Result login(Member member) {
        return null;
    }

    @Override
    public Member findByOpenId(String openId) {
        return findBy("openId", openId);
    }

    @Override
    public MemberDTO getMemberByWechatCode(String code) throws WxErrorException {
//        WxMpService wxMpService = WechatUtils.getInstance().getWxService();
//        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
//        WxMpUser user = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
//        Member member = findByOpenId(user.getOpenId());
        Member member = findByOpenId("ozqVc0VzImLHzu_NGlk_siyBH83U");
        boolean isNew = false;
//        if (member == null){
//            member = new Member();
//            member.setNickname(user.getNickname());
//            member.setOpenId(user.getOpenId());
//            member.setCreateTime(now());
//            member.setDataStatus(EnumDataStatus.normal.getValue());
//            save(member);
//            isNew = true;
//        }
        return new MemberDTO(member,isNew);
    }

    @Override
    public void loginByOpenId(String openId) {
        ThirdPartyLoginToken token = new ThirdPartyLoginToken(openId, 1);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        Member member = findByOpenId(openId);
        member.setLastLoginTime(now());
        member.setUpdateTime(now());
        update(member);
    }
}
