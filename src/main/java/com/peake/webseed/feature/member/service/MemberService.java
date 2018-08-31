package com.peake.webseed.feature.member.service;

import com.peake.webseed.core.Result;
import com.peake.webseed.core.Service;
import com.peake.webseed.feature.member.dto.MemberDTO;
import com.peake.webseed.feature.member.model.Member;
import me.chanjar.weixin.common.error.WxErrorException;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
public interface MemberService extends Service<Member> {
    Result login(Member member);

    MemberDTO getMemberByWechatCode(String code) throws WxErrorException;

    void loginByOpenId(String openId);
    Member findByOpenId(String openId);
}
